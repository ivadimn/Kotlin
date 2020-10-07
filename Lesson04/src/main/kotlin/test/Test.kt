package test

import com.sun.jdi.connect.Connector

fun String?.isEmptyOrNull() : Boolean = this?.isEmpty() ?: true

infix fun Int.sm(other : Int) : Int = this + other

data class RationalNumber(val numerator : Int, val denominator : Int) {

    companion object {
        fun gcd(a: Int, b: Int) :Int {
            return if (a == 0 || b == 0) a + b
            else if (a > b)  gcd(b,a % b )
            else gcd(a,b % a)
        }
    }
    operator fun plus(other : RationalNumber) : RationalNumber {
        val n = numerator * other.denominator + denominator * other.numerator
        val d = denominator * other.denominator
        val cd = gcd(n, d)
        return RationalNumber(n / cd, d / cd)
    }

    operator fun minus(other : RationalNumber) : RationalNumber {
        val n = numerator * other.denominator - denominator * other.numerator
        val d = denominator * other.denominator
        val cd = gcd(n, d)
        return RationalNumber(n / cd, d / cd)
    }

    operator fun times(other : RationalNumber) : RationalNumber {
        val n = numerator * other.numerator
        val d = denominator * other.denominator
        val cd = gcd(n, d)
        return RationalNumber(n / cd, d / cd)
    }

    operator fun div(other : RationalNumber) : RationalNumber {
        val n = numerator * other.denominator
        val d = denominator * other.numerator
        val cd = gcd(n, d)
        return RationalNumber(n / cd, d / cd)
    }
}

fun main(args : Array<String>) {
    println(22.sm(12))
    println(22 sm 12)
    val rn1 = RationalNumber(3, 4)
    val rn2 = RationalNumber(1, 5)
    println(rn1 / rn2)
}