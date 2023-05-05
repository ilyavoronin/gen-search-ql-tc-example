import gen.searchQL.exec.ExecutionEngine
import impl.ObjSourceImpl
import impl.WBuildConf
import impl.WObject
import teamCity.server.TeamCityServer

fun main() {
    val queries = listOf(
        """
             find buildConf
             in 
                 project (id ("project0")) 
                 or
                 project (id ("project1"))
             with trigger (type ("scheduled"))
         """.trimIndent(),

        """
            find trigger
            in 
                 project (id ("project0"))
                 or
                 buildConf (id ("conf0"))
        """.trimIndent(),

        """
            find id in project (id ("project0")) -> {build_conf or template}
        """.trimIndent(),

        """
            find id in project (id ("project0")) -> {build_conf->{id} or template->{id}}
        """.trimIndent(),

        """
            find id in project( feature( type("unique_type") ) ) -> {id}
        """.trimIndent(),

        """
            find trigger
            in
            	project
            	(
            		name ("abacaba")
            		and
            		(build_conf (name ("T1")) or not build_conf (name ("T2")) )
            	) -> {
            		build_conf
            		(
            		   name ("abacaba")
            		) and
            		template
            		(
            		   id ("qwerty")
            		)
            	}.{type ("1")}

            	or 

            	project 
            	(
            	   name ("aba2")
            	).{type ("2")}
            
            
            with type ("scheduled")
        """.trimIndent(),

        """
            find trigger in project( id("project0") ) and project( id("project0") ) -> { build_conf( id("conf0") ) }
             with type("scheduled")
        """.trimIndent(),

        """
            find trigger in buildConf( param( name("conf2_name0") ) )
        """.trimIndent(),

        """
            find trigger in project( id("project0") ) and project( id("project0") ) -> {
        
                build_conf( id("conf0") ) and build_conf( name("Conf0") ) 
                or 
                build_conf( id("conf1") ) and build_conf( name("Conf1") ) 
                or
                build_conf( id("conf2") ) and build_conf( name("Conf2") ) and build_conf( name("Conf2") ) and build_conf( param( name("conf2_name0") ) )
                or
                build_conf( id("conf3") ) and build_conf( name("Conf5") )
                or 
                build_conf( id("conf50") )
            }
            with type("scheduled")
        """.trimIndent(),

        """
            find trigger in buildConf( id("conf50") )
        """.trimIndent(),

        """
            find trigger in project( feature( type("feature1") ) ) and (
            project( id("project0") ) -> {
        
                build_conf( id("conf0") ) and build_conf( name("Conf0") ) 
                or 
                build_conf( id("conf1") ) and build_conf( name("Conf1") ) 
                or
                build_conf( id("conf2") ) and build_conf( name("Conf2") ) and build_conf( name("Conf2") ) and build_conf( param( name("conf2_name0") ) )
                or
                build_conf( id("conf3") ) and build_conf( name("Conf5") )
                or 
                build_conf( id("conf50") )
            } or 
            project( feature( type("feature1") ) ) -> {
        
                build_conf( id("conf0") ) and build_conf( name("Conf0") ) 
                or 
                build_conf( id("conf1") ) and build_conf( name("Conf1") ) 
                or
                build_conf( id("conf2") ) and build_conf( name("Conf2") ) and build_conf( name("Conf2") ) and build_conf( param( name("conf2_name0") ) or id("conf10") )
                or
                build_conf( id("conf3") ) and build_conf( name("Conf5") )
                or 
                build_conf( id("conf50") )
            }
            )
            with type("scheduled")
        """.trimIndent()
    )

    val server = TeamCityServer(10)
    val exec = ExecutionEngine(ObjSourceImpl(server))

    for ((i, q) in queries.withIndex()) {
        println("Result $i")
        val res = exec.execute(q) as List<WObject>
        println(res.joinToString(", ") { it.string() })
        println("OK")
    }
}