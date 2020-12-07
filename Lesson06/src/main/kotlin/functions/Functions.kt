package functions

class LazyClass(val initializer: () -> Int) {
    val initial : Int by lazy { initializer() }
}

class Counter {
    var numberOfGets = 0
    var number : Int = 0
    get() {
        numberOfGets++
        return field
    }
}

fun Int.isOdd() : Boolean = this % 2 != 0
fun Int.isEven() : Boolean = this % 2 == 0
val isEven: Int.() -> Boolean = {this % 2 == 0}
val isOdd: Int.() -> Boolean = {this % 2 == 1}

fun Collection<String>.formatString(
    prefix: String = "[",
    suffix: String = "]",
    delim: String = ","
) : String {
    return this.joinToString(delim, prefix, suffix)
}

fun Collection<String>.format(
    prefix: String = "[",
    suffix: String = "]",
    delim: String = ",",
    processor : (String) -> String = { it }
) : String {
    val result = StringBuilder()
    result.append(prefix)
    for ((index, elem) in this.withIndex()) {
        if (index != 0)
            result.append(delim)
        result.append(processor(elem))

    }
    result.append(suffix)
    return result.toString()
}

fun main() {

    /*val counter = Counter()
    for (i in 1..10) {
        counter.number
    }
    println(counter.numberOfGets)*/
     val init : () -> Int = {
         println("init")
         3
    }

   /* val lazyClass = LazyClass(init)
    lazyClass.initial
    lazyClass.initial

    println(3.isEven())
    println(3.isOdd())
    println(isOdd(5)) */

    println(listOf("123", "456", "789").formatString())
    println(listOf("123", "456", "789", "94040", "874u4i4")
        .format("<", ">", ";", {""+it.length}) )


}