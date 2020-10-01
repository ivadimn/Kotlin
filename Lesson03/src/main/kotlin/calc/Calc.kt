package calc

import java.lang.IllegalArgumentException

fun Any.print() : String  =
    when (this) {
        is String ->  "String: ${this}"
        is Int ->  "Int: ${this.toString()}"
        else -> "Don't Know ..."
    }

fun fib(d : Int) : Int {
    var fibs = mutableListOf<Int>(0, 1)
    if(d < 2) return fibs[d]
    for (i in 1 .. d)
        fibs.add(fibs[i - 1] + fibs[i])
    return fibs[d]
}

fun List<Int>.sum() : Int {
    var result = 0
    this.forEach { result += it }
    return result
}

fun isValidIdentifier0(id : String) : Boolean {
    val regex = """[_a-zA-z]{1}[a-zA-Z0-9_]{1,}"""
    return id.matches(regex.toRegex())
}

fun isValidIdentifier(id : String) : Boolean {

    if (id.length == 0) return false
    val fCh = id.first()
    if (fCh != '_' && fCh !in 'a'..'z' && fCh !in 'A'..'Z') return false
    val ss = id.substring(1, id.length)
    for (c in ss) {
        if (c != '_' && c !in 'a'..'z' && c !in 'A'..'Z' && c !in '0'..'9') return false
    }
    return true
}

interface Animal {
    fun say()
}

class Dog : Animal {
    override fun say() {
        println("Собака гавкает")
    }
}

class Goat : Animal {
    override fun say() {
        println("Козёл блеет")
    }
}

class Cow : Animal {
    override fun say() {
        println("Корова мычит")
    }
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right : Expr) : Expr

fun eval(e: Expr) : Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Invalid expression")
    }
fun  main() {
    /*val farm = listOf<Animal>(Dog(), Goat(), Cow())
    farm.forEach { it.say() }

    println(eval(Sum( Sum( Num(2), Num(7)), Num(10))))*/
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}