package impl

import gen.searchQL.objects.BuildConf
import gen.searchQL.objects.Project
import gen.searchQL.objects.Template
import teamCity.objects.TCBuildConf
import teamCity.server.TeamCityServer

class WBuildConf(override val buildConf: TCBuildConf, val server: TeamCityServer): WCommonBuildConf(), BuildConf, WObject {
    override fun parentProject(): List<Project> {
        return listOf(WProject(server.projects[buildConf.parentId]!!, server))
    }

    override fun parentTemplate(): List<Template> {
        return listOf()
    }

    override fun equals(other: Any?): Boolean {
        return other is WBuildConf && other.buildConf.id == buildConf.id
    }

    override fun hashCode(): Int {
        return buildConf.id.hashCode()
    }

    override fun string(): String {
        return "Conf(${buildConf.id})"
    }
}