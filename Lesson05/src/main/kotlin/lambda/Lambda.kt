package lambda

import com.sun.jdi.connect.Connector

data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 29),
    Person("Bob", 31),
    Person("Carol", 31)
)

val list = listOf(1, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9, 9)
val nullableList : List<Int?> = listOf(1, 2, 3, 4,  null, 5, null, 6, 7, 8, 9)

fun main(args : Array<String>) {

    /*val sum : (Int, Int) -> Int =  {x: Int, y: Int -> x + y}
    val some : () -> Unit = {println("hello")}

    println(sum(1, 2))
    some()*/

    //println(list.filter { it % 3 == 0 })
    //println(people.filter { it.age > 30 })
    //println(nullableList.filter {x -> x != null &&  x % 3 == 0 })

    //println(people.first { it.age == 31 })
    //println(people.last { it.age == 31 })
    //println(people.firstOrNull { it.age == 40 })

    //println(people.maxByOrNull { it.age }?.age)
    //println(people.minByOrNull { it.age })
    println(list.distinct().map { it * it })
    println(people.filter { it.age > 30 }.map { it.name })
}