package impl

import gen.searchQL.objects.*
import teamCity.objects.TCVcsRoot

class WVcsRoot(override val vcsRoot: TCVcsRoot) : WCommonVcsRoot(), VcsRoot {
    override fun parentProject(): List<Project> {
        return listOf()
    }
}