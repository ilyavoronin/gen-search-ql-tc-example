package impl

import gen.searchQL.objects.*
import teamCity.objects.TCArtifactDependency
import teamCity.objects.TCBuildConf
import teamCity.objects.TCSnapshotDependency

class WDependency(private val artifactDeps: List<TCArtifactDependency>, private val snapshotDep: TCSnapshotDependency?,
                  override val buildConf: TCBuildConf
): WCommonBuildConf(), Dependency {
    override fun getArtifact(): List<ArtifactDependency> {
        return artifactDeps.map { WArtitifactDep(it) }
    }

    override fun getSnapshot(): SnapshotDependency {
        return WSnapshotDependency(snapshotDep)
    }
}