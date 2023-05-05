package impl

import gen.searchQL.objects.*
import teamCity.objects.TCTrigger

class WTrigger(val trig: TCTrigger) : Trigger, WObject, WObjectWithMetrics("Trigger") {
    override fun getType(): Type {
        return WType(trig.type)
    }

    override fun equals(other: Any?): Boolean {
        return other is WTrigger && other.trig.id == trig.id
    }

    override fun hashCode(): Int {
        return trig.id.hashCode()
    }

    override fun string(): String {
        return "Trigger(${trig.id})"
    }
}