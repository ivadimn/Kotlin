import model.PDFDocument;
import model.PDFPage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static core.UtilsKt.getFileExtension;

public class Render {

    public static PDFDocument loadDocument(File file) {
        PDFDocument pdfDoc = null;
        try {
            PDDocument pdDoc = PDDocument.load(file);
            pdfDoc = new PDFDocument(pdDoc, file.getAbsolutePath());
            PDFRenderer renderer = new PDFRenderer(pdDoc);
            int numPages = pdDoc.getNumberOfPages();
            for (int i = 0; i < numPages; i++) {
                pdfDoc.addPage(new PDFPage(renderer.renderImage(i), i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pdfDoc;
    }

    public static void saveToFile(PDDocument doc, List<PDFPage> pages, File file) throws IOException {
        PDDocument targetDoc = new PDDocument();
        for (int i = 0; i < pages.size(); i++) {
            PDFPage page = pages.get(i);
            if (page.getInDocument()) {
                targetDoc.addPage(doc.getPage(page.getNumber()));
            }
            else {
                PDPage p = new PDPage();
                targetDoc.addPage(p);
                imageToPage(targetDoc, page.getImage(), p);
                //page.setNumber(i);
            }
        }
        targetDoc.save(file);
    }

    public static void saveAsImages(File file, List<PDFPage> pages) throws IOException {
        String fName = file.getName();
        String ext = getFileExtension(fName);
        String name = fName;
        String path = file.getPath();
        for (int i = 0; i < pages.size(); i++) {
            String f = String.format("%s%s-%d.%s", path, name, i, ext);
            BufferedImage img = pages.get(i).getImage();
            ImageIO.write(img, ext, new File(f));
        }
    }

    public static void savePdf(PDDocument doc, File file) throws IOException {
        doc.save(file);
    }

    private static void imageToPage(PDDocument doc, BufferedImage img, PDPage page) throws IOException {
        PDImageXObject pdImage = LosslessFactory.createFromImage(doc, img);
        try (PDPageContentStream contents = new PDPageContentStream(doc, page))  {
            contents.drawImage(pdImage, 20, 20);
        }
    }



}
