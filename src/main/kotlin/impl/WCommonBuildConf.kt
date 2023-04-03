package impl

import gen.searchQL.*
import teamCity.objects.TCBuildConf

abstract class WCommonBuildConf : CommonBuildConf {
    abstract val buildConf: TCBuildConf

    override fun getId(): Id {
        return WId(buildConf.id)
    }

    override fun getName(): Name {
        return WName(buildConf.name)
    }

    override fun getTrigger(withinherited: WithInheritedMod): List<Trigger> {
        return buildConf.triggers.map { WTrigger(it) }
    }

    override fun getStep(withinherited: WithInheritedMod): List<Step> {
        return buildConf.steps.map { WStep(it) }
    }

    override fun getParam(withinherited: WithInheritedMod, resolved: ResolvedMod): List<Param> {
        return buildConf.params.map { WParam(it.name, it.value) }
    }

    override fun getDep(): List<Dependency> {
        val res = mutableListOf<Dependency>()
        for ((key, v) in buildConf.adeps) {
            res.add(WDependency(v, buildConf.sdeps[key], v[0].conf))
        }
        return res
    }

    override fun getVcs_entry(): List<VcsRootEntry> {
        return buildConf.vcsRoots.map { WVcsRootEntry(it) }
    }

    override fun getFeature(): List<Feature> {
        return buildConf.features.map { WFeature(it) }
    }
}