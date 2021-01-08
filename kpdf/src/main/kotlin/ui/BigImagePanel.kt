package ui

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.AffineTransform
import java.awt.image.AffineTransformOp
import java.awt.image.BufferedImage
import javax.swing.BorderFactory
import javax.swing.JPanel

class BigImagePanel(
    val image : BufferedImage
) : JPanel() {

    init {
        setBorder()
        preferredSize = Dimension(image.width, image.height + 20)
    }

    fun setBorder() {
        border = BorderFactory.createLineBorder(Color.BLACK, 1, false)
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)

        val g2 = g?.create() as Graphics2D
        val size = size
        val w = image.width
        var x = 0
        if (size.width > w) {
            x = (size.width - w) / 2
        }
        g2.drawImage(image, x, 10, null)
        g2.dispose()
    }


}