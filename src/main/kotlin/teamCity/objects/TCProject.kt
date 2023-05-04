package teamCity.objects


class TCProject(
    var id: String,
    var parentId: String?,
    var name: String = id,
    var buildConfs: List<TCBuildConf> = listOf(),
    var templates: List<TCTemplate> = listOf(),
    var vcsRoots: List<TCVcsRoot> = listOf(),
    var subprojects: List<TCProject> = listOf(),
    var features: MutableList<TCFeature> = mutableListOf(),
    var archived: Boolean = false,
) {
}