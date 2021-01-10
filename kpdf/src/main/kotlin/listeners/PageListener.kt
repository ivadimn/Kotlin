package listeners

import java.io.File

interface PageListener {
    fun insertPage(index : Int, file : File)
    fun deletePage(index: Int)
    fun exportPage(index: Int)
}