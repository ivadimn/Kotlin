package calc

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

fun isValidId(id : String) : Boolean {
    if (id.length <= 4) return false
    val fch = id.first()
    if ((fch != '_') or (!fch.isLetter()))  return false
    id.contains("""[]""")
}

fun main() {

    val s = "lkd;lk;ks;"
    println(s.print())
    println(255.print())
    println(true.print())
    println(fib(2))
    println(fib(3))
    println(fib(12))
    println(listOf(1, 2, 3, 4, 5, 6, 7).sum())

}