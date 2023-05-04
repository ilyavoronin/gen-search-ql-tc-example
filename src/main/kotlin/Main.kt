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