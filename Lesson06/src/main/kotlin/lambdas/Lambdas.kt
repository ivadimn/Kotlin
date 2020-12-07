package lambdas

class Person(val name: String, val age: Int) {
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

class Book(val title : String, val authors: List<String>) {

    var recenzent : Person? = null
    override fun toString(): String {
        return "Book(title='$title', authors=$authors)"
    }
}


fun Book.withRecenzent(action: Person.() -> Unit ) : Book {
    return apply {
        val rec = Person("aaaa", 31).apply { action }
        recenzent = rec
    }
}
val books = listOf(Book("Mars", listOf("Pete", "Sam", "Nick")),
    Book("Mors", listOf("Pete", "Jary" )),
    Book("Mars", listOf("Pete", "Jack", "John")),
    Book("Good Man", listOf("Jack", "Jary")),
    Book("Women", listOf("John", "Sam")),
)

val persons = listOf(
    Person("John", 28),
    Person("Olga", 38),
    Person("Karl", 19),
    Person("Pete", 21),
    Person("Sara", 21),
    Person("Jack", 38),
    Person("Nataly", 19),
)

val selector = {p: Person? -> p?.name}
val selectorAge = {p: Person? -> p?.age}

fun main() {
    /*println(selector(persons.maxByOrNull { it.age }))
    println(persons.groupBy(selectorAge))
    println(books.flatMap { it.authors }.toSet())*/
    /*listOf(1, 2, 3, 4, 5).asSequence()
        .map { print("map($it) ")
               it * it }
        .filter { print("filter($it) ")
                    it % 2 == 0}.toList() */

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}