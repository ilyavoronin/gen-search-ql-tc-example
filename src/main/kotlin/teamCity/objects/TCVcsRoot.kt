package teamCity.objects

class TCVcsRoot(
    val id: String,
    val name: String,
    var params: List<TCParam>,
    var type: String,
    var rules: List<String>
) {
}