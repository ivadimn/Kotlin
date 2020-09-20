package strings

fun String.lastChatOf() : Char = get(length - 1)

fun String.allMatchesOf(regex: String) : List<String> {
    val l = mutableListOf<String>()
    regex.toRegex().findAll(this).forEach { l.add(it.value) }
    return l
}

var StringBuilder.lastCh : Char
get() = get(length - 1)
set(value : Char)  {
    this.setCharAt(length - 1, value)
}

fun List<String>.firstElement() : String? = if(this.size > 0) this[0] else null
fun main() {
    val html = "<html><head>Hello</head><h1>Heading</h1><p>Greet!<br></html>"
    val regex = """<[a-zA-Z0-1/^>]+>"""
    val list = html.allMatchesOf(regex)
    list.forEach { println(it) }

    val sb : StringBuilder = StringBuilder("any string")
    println(sb.lastCh)
}