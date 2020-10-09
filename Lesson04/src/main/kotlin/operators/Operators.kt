package operators

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) : Point {
        return Point(x + other.x, y + other.y)
    }
}

class Rect(val ul : Point, val lr : Point)

operator fun Rect.contains(p: Point) : Boolean {
    return p.x in ul.x .. lr.x && p.y in ul.y .. lr.y
}

class Hedgehog {
    fun whoAmI() {
        println("I am Hendehog")
    }
}

class Snake {
    fun whoAmI() {
        println("I am Snake")
    }
}

class BarbWire {
    fun whoAmI() {
        println("I am BarbWare")
    }
}

operator fun Hedgehog.plus(s: Snake) : BarbWire = BarbWire()
operator fun Snake.plus(s: Hedgehog) : BarbWire = BarbWire()

val name : String by lazy {
    println("inicialization")
    "name initialized"
}

class LateInit {
    lateinit var late : String

    fun init(value: String) {
        late = value
    }
}

fun main(args : Array<String>) {
  /*  val point1 = Point(3, 3)
    val point2 = Point(5, 5)

    println(point1 + point2)

    val rect = Rect(Point(4, 4), Point(20, 10))
    println(point1 in rect)
    println(point2 in rect)*/

 /*   val hedgehog = Hedgehog()
    val snake = Snake()
    (hedgehog + snake).whoAmI()
    (snake + hedgehog).whoAmI()*/

    println(name)
    println(name)

    val lateInit = LateInit()
    lateInit.init("yes")
    println(lateInit.late)

}