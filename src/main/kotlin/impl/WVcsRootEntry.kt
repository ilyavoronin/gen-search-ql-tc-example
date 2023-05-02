package impl

import gen.searchQL.objects.*
import teamCity.objects.TCVcsRoot

class WVcsRootEntry(override val vcsRoot: TCVcsRoot): WCommonVcsRoot(), VcsRootEntry {
    override fun getRules(): List<Rule> {
        return vcsRoot.rules.map { WRule(it) }
    }
}