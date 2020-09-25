package over

enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255);

    override fun toString(): String =
        when(this) {
            RED -> "Red"
            GREEN -> "Green"
            BLUE -> "Blue"
        }
}



fun main() {
    val cs = mutableListOf<Color>(Color.RED, Color.BLUE, Color.GREEN, Color.RED, Color.RED)
    val list = mutableListOf<Color>()
    cs.forEach { list.add(it) }
    cs.removeAt(0)
    println(cs.toString())
    //println(list.toString())

}

