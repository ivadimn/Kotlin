package calculator

class Calculator (
    private var result : Int = 0
) {
    fun get() = result
    fun add(other : Int) {
        result += other
    }
    fun mul(other : Int) {
        result *= other
    }
    fun sub(other : Int) {
        result -= other
    }
    fun div(other : Int) {
        assert(other != 0) {"Divizion by zero"}
        result /= other
    }
}

fun main() {
    val calc = Calculator(12)
    calc.add(10)
    println(calc.get())
}