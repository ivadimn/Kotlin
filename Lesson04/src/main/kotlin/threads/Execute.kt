package threads

import java.lang.Thread.sleep
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main(args : Array<String>) {

    println("Введите количество миллисекунд ...")
    val countTime : Long  = readLine()?.toLongOrNull() ?: 2000
    val executor =  Executors.newSingleThreadScheduledExecutor()
    executor.schedule({
        printMessages()
        println("Finish")
        }, countTime, TimeUnit.MILLISECONDS)
    println("Поток инициировали")
    executor.shutdown()

}

fun printMessages() {
    for (i in 0 .. 10) {
        println(i)
        sleep(1000)
    }
}