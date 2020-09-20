package cru

enum class Cru(
    val level: Int
) {
    CRU(80), PREMIER(90), GRAND(100);
    override fun toString() = when(this) {
            CRU     -> "Base cru"
            PREMIER -> "Premire cru"
            GRAND   -> "Grand cru"
        }
}

fun main() {
    println(Cru.GRAND)
    val  cru = Cru.valueOf("CRU")
    Cru.values().forEach { println(it) }
}