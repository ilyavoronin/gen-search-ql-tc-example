import gen.searchQL.exec.ExecutionEngine
import impl.ObjSourceImpl
import impl.WBuildConf
import teamCity.server.TeamCityServer

fun main() {
    val query = """
        find buildConf in project (id ("project3"))
    """.trimIndent()

    val server = TeamCityServer(10)
    val exec = ExecutionEngine(ObjSourceImpl(server))
    val res = exec.execute(query) as List<WBuildConf>
    println(res.joinToString(", ") { it.buildConf.id })
    println("OK")
}