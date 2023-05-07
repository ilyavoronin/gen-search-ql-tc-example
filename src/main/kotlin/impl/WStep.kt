package impl

import gen.searchQL.objects.*
import teamCity.objects.TCBuildConf
import teamCity.objects.TCStep
import teamCity.objects.TCTemplate
import teamCity.server.tcServer

class WStep(val step: TCStep, val parentConf: TCBuildConf?, val parentTemp: TCTemplate?) : Step, WObjectWithMetrics("Step"), WObject {
    override fun getType(): Type {
        return WType(step.type)
    }

    override fun parentBuildConf(): List<BuildConf> {
        return parentConf?.let { listOf(WBuildConf(it, tcServer)) } ?: listOf()
    }

    override fun parentTemplate(): List<Template> {
        return parentTemp?.let { listOf(WTemplate(it)) } ?: listOf()
    }

    override fun string(): String {
        return "Step(${step.id})"
    }

    override fun equals(other: Any?): Boolean {
        return other is WStep && other.step.id == step.id
    }

    override fun hashCode(): Int {
        return step.id.hashCode()
    }
}