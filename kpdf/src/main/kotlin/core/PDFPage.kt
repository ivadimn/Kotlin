package core

import java.awt.image.BufferedImage

class PDFPage(
    var image : BufferedImage,
    var inDocument : Boolean,
    var numPage : Int
)