package impl

import gen.searchQL.ArtifactDependency
import gen.searchQL.Rule
import teamCity.objects.TCArtifactDependency

class WArtitifactDep(private val dep: TCArtifactDependency): ArtifactDependency {
    override fun getRules(resolved: Boolean): List<Rule> {
        return dep.rules.map { WRule(it) }
    }

    override fun getBool(): Boolean {
        return true
    }
}