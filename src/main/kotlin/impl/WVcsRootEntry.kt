package impl

import gen.searchQL.objects.*
import teamCity.objects.TCVcsRoot

class WVcsRootEntry(override val vcsRoot: TCVcsRoot): WCommonVcsRoot(), VcsRootEntry {
    override fun getRules(): List<Rule> {
        return vcsRoot.rules.map { WRule(it) }
    }

    override fun equals(other: Any?): Boolean {
        return other is WVcsRootEntry && other.vcsRoot.id == vcsRoot.id
    }

    override fun hashCode(): Int {
        return vcsRoot.id.hashCode()
    }
}