package teamCity.objects


class TCProject(
    var id: String,
    var name: String = id,
    var buildConfs: List<TCBuildConf> = listOf(),
    var templates: List<TCTemplate> = listOf(),
    var vcsRoots: List<TCVcsRoot> = listOf(),
    var subprojects: List<TCProject> = listOf(),
    var features: List<TCFeature> = listOf(),
    var archived: Boolean = false,
) {
}