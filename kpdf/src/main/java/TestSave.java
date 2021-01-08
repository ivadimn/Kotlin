import model.PDFPage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestSave {

    static String[] files = {
            "/home/vadim/Kotlin/kpdf/get-0.png",
            "/home/vadim/Kotlin/kpdf/get-1.png",
            "/home/vadim/Kotlin/kpdf/get-2.png",
            "/home/vadim/Kotlin/kpdf/get-3.png"
    };

    public static void main(String[] args) throws IOException {
        List<BufferedImage> images = new ArrayList<BufferedImage>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            BufferedImage image = ImageIO.read(new File(file));
            images.add(image);
        }

        saveToFile(images, new File("test-1.pdf"));
        System.out.println("File was saved ");
    }

    public static PDDocument saveToFile(List<BufferedImage> pages, File file) throws IOException {
        PDDocument targetDoc = new PDDocument();
        for (int i = 0; i < pages.size(); i++) {
            BufferedImage page = pages.get(i);
            PDPage p = new PDPage();
            targetDoc.addPage(p);
            imageToPage(targetDoc, page, p);
        }

        targetDoc.save(file);
        return targetDoc;
    }

    private static void imageToPage(PDDocument doc, BufferedImage img, PDPage page) throws IOException {
        PDImageXObject pdImage = LosslessFactory.createFromImage(doc, img);
        try (PDPageContentStream contents = new PDPageContentStream(doc, page))  {
            contents.drawImage(pdImage, 20, 20);
        }
    }


}
