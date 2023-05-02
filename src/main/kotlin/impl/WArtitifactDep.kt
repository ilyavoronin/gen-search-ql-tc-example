package impl

import gen.searchQL.objects.ArtifactDependency
import gen.searchQL.objects.Rule
import teamCity.objects.TCArtifactDependency

class WArtitifactDep(private val dep: TCArtifactDependency): ArtifactDependency {
    override fun getRules(resolved: Boolean): List<Rule> {
        return dep.rules.map { WRule(it) }
    }

    override fun getBool(): Boolean {
        return true
    }
}