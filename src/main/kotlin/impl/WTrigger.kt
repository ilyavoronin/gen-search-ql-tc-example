package impl

import gen.searchQL.objects.*
import teamCity.objects.TCTrigger

class WTrigger(val trig: TCTrigger) : Trigger {
    override fun getType(): Type {
        return WType(trig.type)
    }
}