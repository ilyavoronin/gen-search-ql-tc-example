package impl

import gen.searchQL.*
import teamCity.objects.TCVcsRoot

abstract class WCommonVcsRoot : CommonVcsRoot {
    abstract val vcsRoot: TCVcsRoot

    override fun getId(): Id {
        return WId(vcsRoot.id)
    }

    override fun getName(): Name {
        return WName(vcsRoot.name)
    }

    override fun getParam(resolved: ResolvedMod): List<Param> {
        return vcsRoot.params.map { WParam(it.name, it.value) }
    }

    override fun getType(): Type {
        return WType(vcsRoot.type)
    }
}