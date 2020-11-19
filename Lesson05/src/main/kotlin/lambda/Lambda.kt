package lambda

import com.sun.jdi.connect.Connector

data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 29),
    Person("Bob", 31),
    Person("Carol", 31)
)

val list = listOf(1.1, 2.0, 3.0, 4.0, 5.0, 5.0, 6.0, 7.0, 8.0, 8.0, 9.0, 9.0)
val nullableList : List<Int?> = listOf(1, 2, 3, 4,  null, 5, null, 6, 7, 8, 9)

val listOflist = listOf(
        listOf("123", "465", "789", "cia", "oon"),
        listOf("ibm", "ibs", "kpmg"),
)

val map = mapOf(1 to "one", 2 to "two", 2 to "three", 4 to  "four")


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

    println(map.mapValues { it.value.toUpperCase() })
    //any
   /* println(people.any { it.age == 31 })
    println(people.all { it.age == 31 })
    println(people.count { it.age == 31 })
    println(people.findLast { it.age == 31 })*/

    println( people.sumBy { it.age }  )
    println( people.map { it.age.toDouble() }.average())
    //fold reduce
    //println(list.fold(1.0,  { acc: Double, elem : Double -> acc * elem}))
    //println(list.reduce { acc, d -> acc * d })
    //println(people.groupBy { it.age })
    //println(people.associateBy { it.age })
    //println(people.partition { it.age > 30 })
    println(listOflist.flatten().flatMap { it.toList() })
}