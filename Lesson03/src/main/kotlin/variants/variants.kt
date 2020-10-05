package variants

import kotlin.random.Random

fun primtContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

open class Animal {
    fun feed() {
        println("Animal feed ...")
    }
}

class Cat(val name : String) : Animal() {
    fun cleanLitter() {
        println("Cat name is $name")
    }
}

class Herd<aT : Animal> {
    val size: Int get() = Random.nextInt(0, 10)
    val members  = mutableListOf<T>()
    operator fun get(i: Int) : T {
        return members.get(i)
    }
    fun includeMemeber(mamber : T) {
        members.add(mamber)
    }
}

fun main(args: Array<String>) {
    primtContents(listOf("abc", "bac"))
    val strings = mutableListOf("abc", "cab")
    addAnswer(strings)

}

