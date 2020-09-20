fun main(args : Array<String>) {
    val range =  1 .. 25
    for (d in range) {
        println(fizzBuzzW(d))
    }
}

fun fizzBuzz(data: Int) : String {

    var result : String = ""

    if (data % 3 == 0) result = "Fizz"
    if (data % 5 == 0) result = "${result}Buzz"
    //if ((data % 3 != 0) && (data % 5 != 0)) result = "No FizzBuzz"
    return "$data: $result"
}

fun fizzBuzzW(data: Int) : String =
    when {
        (data % 3 == 0) && (data % 5 != 0) -> "$data: Fizz"
        (data % 5 == 0) && (data % 3 != 0) -> "$data: Buzz"
        (data % 5 == 0) && (data % 3 == 0) -> "$data: FizzBuzz"
        else -> "$data: "
    }

