package oop

sealed class Person(
   open val name : String,
   open val age :Int
) {
    data class User(
        override val name : String,
        override val age :Int

    ) : Person(name, age)
}