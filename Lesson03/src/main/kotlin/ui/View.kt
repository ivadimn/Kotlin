package ui

interface View {
    fun click()
    fun whoAmI() = println("I'm a view")
}

interface Shape {
    fun whoAmI() = println("I'm a shape")
}

class Button : View, Shape {
    override fun click() = println("Button click")
    //override fun whoAmI() = println("I'm a button")
    override fun whoAmI() {
        super<View>.whoAmI()
        super<Shape>.whoAmI()
    }
}

class TextView : View {
    override fun click() = println("TextView click")
    override fun whoAmI() = println("I'm a TextView")
}

fun main() {
    val v1 : View = Button()
    val v2 : View = TextView()
    v1.whoAmI()
    v2.whoAmI()
}