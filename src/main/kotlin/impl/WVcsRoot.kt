package impl

import gen.searchQL.objects.*
import teamCity.objects.TCVcsRoot

class WVcsRoot(override val vcsRoot: TCVcsRoot) : WCommonVcsRoot(), VcsRoot {
    override fun parentProject(): List<Project> {
        return listOf()
    }

    override fun equals(other: Any?): Boolean {
        return other is WVcsRoot && other.vcsRoot.id == vcsRoot.id
    }

    override fun hashCode(): Int {
        return vcsRoot.id.hashCode()
    }
}