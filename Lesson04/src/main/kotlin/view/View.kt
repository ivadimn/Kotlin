package view

import JavaClickListener
import JavaView

data class Person(val name: String, val age : Int)
val people = listOf(
        Person("Alice", 34),
        Person("Bob", 31),
        Person("Carol", 29),
        Person("Mike", 29)
)

fun hi(msg : String) = println(msg)
fun Person.isAdult() : Boolean = age >= 18

fun main(args : Array<String>) {
    /*val javaView = JavaView()
    javaView.setOnClickListener(object : JavaClickListener {
        override fun onClick(view: JavaView?) {
            println("Java View click listener")
        }
    })

    javaView.setOnClickListener { view -> println("Java View click listener") }

    val sum = {x: Int, y: Int -> x + y}
    //println(sum(2, 3))

    {println("Hello")}()*/

    val ageSort = {p: Person ->p.age}
    println(
        //people.minByOrNull({ p: Person -> p.age })
        //people.minByOrNull(){ p: Person -> p.age }
        //people.minByOrNull{ p: Person -> p.age }
        //people.minByOrNull{ p -> p.age }
        //people.minByOrNull{ it.age }
        //people.minByOrNull(Person::age)
        people.minByOrNull(ageSort)
    )

    val hello = ::hi
    hello("Hello")

    var counter = 0
    people.forEach{
        counter++
    }
    println(counter)

    val create = ::Person
    val max = create("Max", 23)
    val adult = Person::isAdult
    println(adult(max))
    val maxage = max::age
    println(maxage())
}