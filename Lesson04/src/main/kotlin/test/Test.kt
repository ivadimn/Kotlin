package test

import com.sun.jdi.connect.Connector

fun String?.isEmptyOrNull() : Boolean = this?.isEmpty() ?: true



fun main(args : Array<String>) {
    println("".isEmptyOrNull())
    println(null.isEmptyOrNull())
    println("kjdskjd".isEmptyOrNull())

}