package impl

import gen.searchQL.Step
import gen.searchQL.Type
import teamCity.objects.TCStep

class WStep(val step: TCStep) : Step {
    override fun getType(): Type {
        return WType(step.type)
    }
}