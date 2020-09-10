import java.math.BigDecimal

class Person(
    val name: String,
    var isMarried: Boolean
)

class Rectangle(val width :Int, val height :Int) {
    val isSquare: Boolean
        get() = width == height
}

enum class Color(val r :Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0), BLUE(0, 0, 255), INDIGO(75, 0, 150),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color : Color) =
    when (color) {
        Color.RED -> "Каждый"
        Color.ORANGE -> "Охотник"
        Color.YELLOW -> "Желает"
        Color.GREEN -> "Знать"
        Color.BLUE -> "Где"
        Color.INDIGO -> "Сидит"
        Color.VIOLET -> "Фазан"
    }

fun main(args: Array<String>) {
    println("Hello Kotlin!!!!")
    val person = Person("Vadim", false)

    println("${person.name}, ${person.isMarried}")
    person.isMarried = true
    println("${person.name}, ${person.isMarried}")

    var position :String? = "manager"
    //position = null
    println("Length position is ${position?.length ?: 0}")

    println(greeting(first = "Olga", last="Petrova"))

    val rect = Rectangle(50, 50)
    println(rect.isSquare)
    println(Color.INDIGO.rgb())
    println(getMnemonic(Color.VIOLET))
    val  words = "Java" .. "Yaml"
    val  digs = '0' .. '9'
    for (d in digs) {
        println(d)
    }

    println(japaneseSalary(-BigDecimal.TEN, 0))

}

fun greeting(first : String, last: String = "Ivanova") :String {
    require(!first.isBlank()) {"Нужно указать имя"}
    require(!last.isBlank()) {"Нужно указать фамилию"}
    return "Hello, $first $last"
}

fun japaneseSalary(base : BigDecimal, years: Int) :BigDecimal {
    require(base > BigDecimal.ZERO) {"Base salary can't be negative"}
    return base + (years * 10000).toBigDecimal()
}