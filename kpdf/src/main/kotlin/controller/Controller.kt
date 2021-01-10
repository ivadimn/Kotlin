package controller

import core.getFileExtension
import model.PDFDocument
import model.PDFPage
import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO


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
    }

    fun saveAs(key : String, file: File) {
        val doc = pdfDocs[key]
        if (doc != null)
            Render.saveToFile(doc.document, doc.pages, file)
    }

    fun exportAsImages(key : String, file: File) {
        val doc = pdfDocs[key]
        if (doc != null)
            Render.saveAsImages(file, doc.pages)
    }

    fun exportAsImage(image : BufferedImage, file: File) {
        Render.saveImage(image, file)
    }

}