package impl

import gen.searchQL.*
import teamCity.objects.TCVcsRoot
import gen.searchQL.objects.*

abstract class WCommonVcsRoot(typeName: String) : CommonVcsRoot, WObjectWithMetrics(typeName) {
    abstract val vcsRoot: TCVcsRoot

    override fun getId(): Id {
        return WId(vcsRoot.id)
    }

    override fun getName(): Name {
        return WName(vcsRoot.name)
    }

    override fun getParam(resolved: Boolean): List<Param> {
        return vcsRoot.params.map { WParam(it.name, it.value) }
    }

    override fun getType(): Type {
        return WType(vcsRoot.type)
    }
}