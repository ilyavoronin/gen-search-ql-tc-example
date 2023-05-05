import gen.searchQL.exec.ExecutionEngine
import impl.ObjSourceImpl
import impl.WObject
import teamCity.server.tcServer
import kotlin.system.measureTimeMillis

fun main() {
    val queries = listOf(
        //0
        """
             find buildConf
             in 
                 project (id ("project0")) 
                 or
                 project (id ("project1"))
             with trigger (type ("scheduled"))
         """.trimIndent(),

        //1
        """
            find trigger
            in 
                 project (id ("project0"))
                 or
                 buildConf (id ("conf0"))
        """.trimIndent(),


        //2
        """
            find id in project (id ("project0")) -> {build_conf or template}
        """.trimIndent(),

        //3
        """
            find id in project (id ("project0")) -> {build_conf->{id} or template->{id}}
        """.trimIndent(),

        //4
        """
            find id in project( feature( type("unique_type") ) ) -> {id}
        """.trimIndent(),

        //5
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

        //6
        """
            find trigger in project( id("project0") ) and project( id("project0") ) -> { build_conf( id("conf0") ) }
             with type("scheduled")
        """.trimIndent(),

        //7
        """
            find trigger in buildConf( param( name("conf2_name0") ) )
        """.trimIndent(),

        //8
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

        //9
        """
            find trigger in buildConf( id("conf50") )
        """.trimIndent(),

        //10
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

    val exec = ExecutionEngine(ObjSourceImpl(tcServer))

    // warm-up query
    exec.execute("""find id in project( id("project0") ) -> {id}""")

    for ((i, q) in queries.withIndex()) {
        tcServer.clearMetrics()
        var res: List<WObject>
        val time = measureTimeMillis {
            res = exec.execute(q) as List<WObject>
        }
        println("Case $i. $time ms")
        println("Result(${res.joinToString(", ") { it.string() }})")
        println("Metrics: ${tcServer.getMetricsStr()}\n")
    }
}