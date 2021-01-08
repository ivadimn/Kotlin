import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject
import org.apache.pdfbox.rendering.PDFRenderer
import java.awt.image.BufferedImage
import java.io.File
import java.io.FileOutputStream
import javax.imageio.ImageIO


fun main(args: Array<String>) {

    val files = listOf(
        "/home/vadim/Kotlin/kpdf/get-0.png",
        "/home/vadim/Kotlin/kpdf/get-1.png",
        "/home/vadim/Kotlin/kpdf/get-2.png",
        "/home/vadim/Kotlin/kpdf/get-3.png",
    )

    val doc = PDDocument()

    for (file in files) {
        val page = PDPage()
        doc.addPage(page)
        val image = ImageIO.read(File(file))
        // createFromFile is the easiest way with an image file
        // if you already have the image in a BufferedImage,
        // call  instead

        //val pdImage = PDImageXObject.createFromFile(file, doc);
        val pdImage = LosslessFactory.createFromImage(doc, image)

        // draw the image at full size at (x=20, y=20)
        val contents = PDPageContentStream(doc, page)

        // draw the image at full size at (x=20, y=20)
        contents.drawImage(pdImage, 20f, 20f)

        // to draw the image at half size at (x=20, y=20) use
        // contents.drawImage(pdImage, 20, 20, pdImage.getWidth() / 2, pdImage.getHeight() / 2);
    }

    val file = File("test.pdf")
    file.createNewFile()
    val outputStream = FileOutputStream(file)
    doc.save(outputStream)
    outputStream.flush()
    outputStream.close()

    println("File was created")


}