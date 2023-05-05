package impl

import gen.searchQL.objects.*
import teamCity.objects.TCStep

class WStep(val step: TCStep) : Step {
    override fun getType(): Type {
        return WType(step.type)
    }

    override fun equals(other: Any?): Boolean {
        return other is WStep && other.step.id == step.id
    }

    override fun hashCode(): Int {
        return step.id.hashCode()
    }
}