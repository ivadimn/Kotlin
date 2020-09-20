package graphics

class Rectangle(
    val height: Int,
    val width: Int
) {
    val isSquare: Boolean
    get() = height == width

    val area : Int
    get() = height * width

    var depth: Int = 0
    set(value)  {
        println("Old value = $field,  new value = $value")
        field = value
    }
}

fun main() {
    println(Rectangle(12, 13).isSquare)
    println(Rectangle(12, 13).area)
    val r = Rectangle(3, 4)
    r.depth = 3

}