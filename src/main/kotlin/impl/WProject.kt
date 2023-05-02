package impl

import gen.searchQL.objects.*
import teamCity.objects.TCProject

class WProject(private val tcProject: TCProject) : Project {
    override fun getId(): Id {
        return WId(tcProject.id)
    }

    override fun getName(): Name {
        return WName(tcProject.name)
    }

    override fun getFeature(): List<Feature> {
        return tcProject.features.map { WFeature(it) }
    }

    override fun getVcs_root(): List<VcsRoot> {
        return tcProject.vcsRoots.map { WVcsRoot(it) }
    }

    override fun getArchived(): Archived {
        return WArchived(tcProject.archived)
    }

    override fun getProject(): List<Project> {
        return tcProject.subprojects.map { WProject(it) }
    }

    override fun getBuild_conf(): List<BuildConf> {
        return tcProject.buildConfs.map { WBuildConf(it) }
    }

    override fun getTemplate(): List<Template> {
        return tcProject.templates.map { WTemplate(it)}
    }
}