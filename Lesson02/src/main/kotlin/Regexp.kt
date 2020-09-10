fun main() {
    val line = "abc 123 def"
    val regexp = """.*\d{3}.*"""
    val pattern = regexp.toRegex()

    println(line.matches(pattern))
    println(isDate("32 MAY 2020"))
    println(isDay("29"))
}

fun isDate(date : String) :Boolean {
    val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
    val reg = """(0[1-9]{1}|1[0-9]{1}|2[0-9]{1}|3[0-1]{1})\s$month\s\d{4}"""
    //val reg = """\d{2}\s$month\s\d{4}"""
    val pattern = reg.toRegex()
    return date.matches(pattern)
}

fun isDay(day : String) : Boolean {
    val reg = """(1[0-9]{1}|2[0-9]{1})"""
    val pattern = reg.toRegex()
    return day.matches(pattern)
}