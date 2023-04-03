package impl

import gen.searchQL.Feature
import gen.searchQL.Type
import teamCity.objects.TCFeature

class WFeature(private val feature: TCFeature) : Feature {
    override fun getType(): Type {
        return WType(feature.type)
    }
}