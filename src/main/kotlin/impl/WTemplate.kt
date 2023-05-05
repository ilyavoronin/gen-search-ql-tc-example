package impl

import gen.searchQL.objects.*
import teamCity.objects.TCTemplate

class WTemplate(private val template: TCTemplate) : Template, WObjectWithMetrics("Template") {
    override fun getInheritedBy(): List<BuildConf> {
        return listOf()
    }

    override fun getId(): Id {
        return WId(template.id)
    }

    override fun getName(): Name {
        return WName(template.name)
    }

    override fun getTrigger(): List<Trigger> {
        return template.triggers.map { WTrigger(it) }
    }

    override fun getStep(): List<Step> {
        return template.steps.map { WStep(it) }
    }

    override fun getParam(resolved: Boolean): List<Param> {
        return template.params.map { WParam(it.name, it.value) }
    }

    override fun getDep(): List<Dependency> {
        val res = mutableListOf<Dependency>()
        for ((key, v) in template.adeps) {
            res.add(WDependency(v, template.sdeps[key], v[0].conf))
        }
        return res
    }

    override fun getVcs_entry(): List<VcsRootEntry> {
        return template.vcsRoots.map { WVcsRootEntry(it) }
    }

    override fun getFeature(): List<Feature> {
        return template.features.map{ WFeature(it) }
    }

    override fun parentProject(): List<Project> {
        return listOf()
    }

    override fun equals(other: Any?): Boolean {
        return other is WTemplate && other.template.id == template.id
    }

    override fun hashCode(): Int {
        return template.id.hashCode()
    }
}