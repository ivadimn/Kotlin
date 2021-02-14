package collections

data class Repo(
    val id : Int,
    val name : String,
    var starred : Boolean = false
)

val raw = listOf(
    Repo(1, "repo_1"),
    Repo(2, "repo_2"),
    Repo(3, "repo_3"),
    Repo(4, "repo_4"),
    Repo(5, "repo_5")
)

val starred = listOf(
    Repo(1, "repo_1"),
    Repo(3, "repo_3"),
    Repo(5, "repo_5")
)


fun main() {
    val stars = raw.intersect(starred)
    raw.forEach { repo -> if (repo in starred) repo.starred = true }
    println(raw)
}