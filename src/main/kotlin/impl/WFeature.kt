package impl

import gen.searchQL.objects.*
import teamCity.objects.TCFeature

class WFeature(private val feature: TCFeature) : Feature {
    override fun getType(): Type {
        return WType(feature.type)
    }

    override fun equals(other: Any?): Boolean {
        return other is WFeature && other.feature.id == feature.id
    }

    override fun hashCode(): Int {
        return feature.id.hashCode()
    }
}