package ui

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.AffineTransform
import java.awt.image.AffineTransformOp
import java.awt.image.BufferedImage
import javax.swing.BorderFactory
import javax.swing.JList
import javax.swing.JPanel

class SmallImagePanel(
    private val image : BufferedImage
) : JPanel() {

    var isFocused = false
    val goldNumber = 1.618F
    val panelWidth = 120
    val panelHeight = panelWidth  * goldNumber

    init {
        setBorder()
        preferredSize = Dimension(panelWidth, panelHeight.toInt())
    }

    fun setBorder() {
        border = when(isFocused) {
            true -> BorderFactory.createLineBorder(Color.YELLOW, 3, false)
            false -> BorderFactory.createLineBorder(Color.GRAY, 3, false)
        }
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        val g2 = g?.create() as Graphics2D
        val w = image.width
        val h = image.height
        val bi = BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR)
        val gl = bi.graphics
        gl.drawImage(image, 0, 0, null)
        val sx : Double = preferredSize.width.toDouble() / w
        val sy : Double = sx
        val transform = AffineTransform()
        transform.setToScale(sx, sy)
        val top = AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC)
        setBorder()
        var x = 0
        if (size.width > w * sx) {
            x = (size.width - (w * sx).toInt()) / 2
        }
        g2.drawImage(bi, top, x + 5, 5)
        g2.dispose()
    }


}