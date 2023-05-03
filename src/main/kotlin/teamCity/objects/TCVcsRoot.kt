package teamCity.objects

class TCVcsRoot(
    val id: String,
    val parentId: String,
    val parentType: String,
    val name: String,
    var params: List<TCParam>,
    var type: String,
    var rules: List<String>
) {
}