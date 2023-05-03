package teamCity.objects

class TCBuildConf(
    val id: String,
    val parentId: String,
    val name: String,
    var triggers: List<TCTrigger> = listOf(),
    var steps: List<TCStep> = listOf(),
    var params: List<TCParam> = listOf(),
    var adeps: Map<String, List<TCArtifactDependency>> = mapOf(),
    var sdeps: Map<String, TCSnapshotDependency> = mapOf(),
    var vcsRoots: List<TCVcsRoot> = listOf(),
    var features: List<TCFeature> = listOf()
) {
}