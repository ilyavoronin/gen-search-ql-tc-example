package impl

import gen.searchQL.exec.ObjectsSource
import gen.searchQL.exec.ValueObject
import gen.searchQL.objects.BuildConf
import gen.searchQL.objects.Project
import gen.searchQL.objects.Template
import gen.searchQL.objects.VcsRoot
import teamCity.server.TeamCityServer
import java.lang.RuntimeException

class ObjSourceImpl(val tcServer: TeamCityServer) : ObjectsSource {
    override fun getAllProject(): List<Project> {
        return tcServer.projects.values.map { WProject(it) }
    }

    override fun getProjectById(v: ValueObject): List<Project> {
        return tcServer.projects[(v as ValueObject.String).v]?.let { listOf(WProject(it)) } ?: emptyList()
    }

    override fun getProjectByName(v: ValueObject): List<Project> {
        return tcServer.projectByName[(v as ValueObject.String).v]?.let { listOf(WProject(it)) } ?: emptyList()
    }

    override fun getAllBuildConf(): List<BuildConf> {
        return tcServer.buildConfs.values.map { WBuildConf(it) }
    }

    override fun getBuildConfById(v: ValueObject): List<BuildConf> {
        return tcServer.buildConfs[(v as ValueObject.String).v]?.let { listOf(WBuildConf(it)) } ?: emptyList()
    }

    override fun getBuildConfByName(v: ValueObject): List<BuildConf> {
        return tcServer.buildConfByName[(v as ValueObject.String).v]?.let { listOf(WBuildConf(it)) } ?: emptyList()
    }

    override fun getAllTemplate(): List<Template> {
        return tcServer.templates.values.map { WTemplate(it) }
    }

    override fun getTemplateById(v: ValueObject): List<Template> {
        return tcServer.templates[(v as ValueObject.String).v]?.let { listOf(WTemplate(it)) } ?: emptyList()
    }

    override fun getTemplateByName(v: ValueObject): List<Template> {
        return tcServer.templateByName[(v as ValueObject.String).v]?.let { listOf(WTemplate(it)) } ?: emptyList()
    }

    override fun getAllVcsRoot(): List<VcsRoot> {
        return tcServer.vcsRoots.values.map { WVcsRoot(it) }
    }
}