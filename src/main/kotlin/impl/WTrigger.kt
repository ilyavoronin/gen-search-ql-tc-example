package impl

import gen.searchQL.objects.*
import teamCity.objects.TCTrigger

class WTrigger(val trig: TCTrigger) : Trigger, WObject {
    override fun getType(): Type {
        return WType(trig.type)
    }

    override fun string(): String {
        return "Trigger(${trig.type})"
    }
}