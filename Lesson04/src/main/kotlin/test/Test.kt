package test

import com.sun.jdi.connect.Connector

fun String?.isEmptyOrNull() : Boolean = this?.isEmpty() ?: true

infix fun Int.sm(other : Int) : Int = this + other

fun main(args : Array<String>) {
    println(22.sm(12))
    println(22 sm 12)
}