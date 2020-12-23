import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.rendering.PDFRenderer
import java.io.File
import javax.imageio.ImageIO


fun main(args: Array<String>) {
    var document : PDDocument? = null

    document = PDDocument.load(File("gen1.pdf"))

    val numpages = document.numberOfPages
    val renderer = PDFRenderer(document)
    println(numpages)
    for (n in 0 until numpages) {
        val image = renderer.renderImage(n)
        ImageIO.write(image, "PNG", File("get-${n}.png"))
        println("page $n")
    }


}