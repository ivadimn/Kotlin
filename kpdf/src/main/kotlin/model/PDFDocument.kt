package model

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory
import org.apache.pdfbox.rendering.PDFRenderer
import java.awt.image.BufferedImage

class PDFDocument(var document : PDDocument,
                    val fileName : String) {

    private val pdfPages : MutableList<PDFPage> = mutableListOf()
    var title : String
    init {
        title = fileName
    }

    val pages
    get() = pdfPages

    fun addPage(page :PDFPage) {
        pdfPages.add(page)
    }

    fun insertPage(index : Int, page :PDFPage) {
        pdfPages.add(index, page)
    }

    fun addImage(image :BufferedImage) {
        val page = PDFPage(image, -1)
        addPage(page)
    }

    fun insertImage(index : Int, image :BufferedImage) {
        val page = PDFPage(image, -1)
        insertPage(index, page)
    }

    fun removePage(index : Int) {
        if (pdfPages[index].inDocument)
            document.removePage(index)
        pdfPages.removeAt(index)
    }
}