package impl

import gen.searchQL.objects.BuildConf
import gen.searchQL.objects.Project
import gen.searchQL.objects.Template
import teamCity.objects.TCBuildConf

class WBuildConf(override val buildConf: TCBuildConf): WCommonBuildConf(), BuildConf {
    override fun parentProject(): List<Project> {
        return listOf()
    }

    override fun parentTemplate(): List<Template> {
        return listOf()
    }
}