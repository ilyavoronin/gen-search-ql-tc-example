package impl

import gen.searchQL.objects.*
import teamCity.objects.TCSnapshotDependency

class WSnapshotDependency(private val snapshotDependency: TCSnapshotDependency?): SnapshotDependency {
    override fun getOption(): List<Option> {
        return snapshotDependency?.options?.map { WOption(it.name, it.value) } ?: listOf()
    }

    override fun getBool(): Boolean {
        return snapshotDependency != null
    }
}