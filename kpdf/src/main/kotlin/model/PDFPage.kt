package model

import java.awt.image.BufferedImage

data class PDFPage(
    private val imagePage: BufferedImage,
    var number : Int
)  {
    val image
    get() = imagePage

    val inDocument
    get() = number >= 0


}
