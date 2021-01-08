package controller

import Render.loadDocument
import model.PDFDocument
import model.PDFPage
import ui.MainFrame
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO
import javax.swing.JOptionPane
import javax.swing.Renderer
import javax.swing.SwingContainer
import javax.swing.SwingUtilities

object Controller {

    private val pdfDocs = mutableMapOf<String, PDFDocument>()

    fun openDocument(fileName: String, key : String) {
        val pdfDocument = Render.loadDocument(File(fileName))
        pdfDocs.put(key, pdfDocument)
    }

    fun getPages(key: String) : List<PDFPage> {
        return pdfDocs[key]?.pages ?: emptyList()
    }

    fun insertPage(key: String, index : Int, file: File) {
        val image : BufferedImage = ImageIO.read(file)
        pdfDocs[key]?.insertImage(index, image)
    }

    fun removePage(key: String, index : Int) {
        pdfDocs[key]?.removePage(index)
    }

    fun save(key : String) {
        val doc = pdfDocs[key]
        if (doc != null)
            Render.saveToFile(doc.document, doc.pages, File(key))
            //Repository.savePdf(doc, )
    }

}