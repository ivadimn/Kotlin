import model.PDFDocument;
import model.PDFPage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static core.UtilsKt.*;

public class Render {

    public static PDFDocument loadDocument(File file) throws IOException {
        PDFDocument pdfDoc = null;
        PDDocument pdDoc = PDDocument.load(file);
        pdfDoc = new PDFDocument(pdDoc, file.getAbsolutePath());
        List<BufferedImage> images = getImagesFromPdf(pdDoc);
        for (int i = 0; i < images.size(); i++) {
            pdfDoc.addPage(new PDFPage(images.get(i), i));
        }
        return pdfDoc;
    }

    public static void saveToFile(PDDocument doc, List<PDFPage> pages, File file) throws IOException {
        PDDocument targetDoc = new PDDocument();
        for (int i = 0; i < pages.size(); i++) {
            PDFPage page = pages.get(i);
            if (page.getInDocument()) {
                targetDoc.addPage(doc.getPage(i));
            }
            else {
                BufferedImage image = page.getImage();
                PDPage p = new PDPage();
                System.out.println(String.format("width - %f, height - %f", p.getMediaBox().getWidth(), p.getMediaBox().getHeight()));
                targetDoc.addPage(p);
                imageToPage(targetDoc, image, p);
                //page.setNumber(i);
            }
        }
        targetDoc.save(file);
    }

    public static void saveAsImages(File file, List<PDFPage> pages) throws IOException {
        String ext = getFileExtension(file.getName());
        if (ext == null)
            ext = "png";
        for (int i = 0; i < pages.size(); i++) {
            //f = String.format("%s%s%s-%d.%s", path, sep, name, i, ext);
            String f = createIndexedFileName(i, file);
            //System.out.println(f);
            BufferedImage img = pages.get(i).getImage();
            ImageIO.write(img, ext, new File(f));
        }
    }

    public static void saveImage(BufferedImage image, File file) throws IOException {
        String ext = getFileExtension(file.getName());
        if (ext == null)
            ext = "png";
        ImageIO.write(image, ext, file);
    }

    public static void savePdf(PDDocument doc, File file) throws IOException {
        doc.save(file);
    }

    private static void imageToPage(PDDocument doc, BufferedImage img, PDPage page) throws IOException {
        PDImageXObject pdImage = LosslessFactory.createFromImage(doc, img);
        try (PDPageContentStream contents = new PDPageContentStream(doc, page))  {
            String s = String.format("pdImage width = %d, pdImage height = %d",
                    pdImage.getWidth(), pdImage.getHeight());
            System.out.println(s);
            contents.drawImage(pdImage, 5, 5);

        }
    }

    private static List<BufferedImage> getImagesFromPdf(PDDocument pdDoc) throws IOException {
        ArrayList<BufferedImage> images = new ArrayList<>();
        PDFRenderer renderer = new PDFRenderer(pdDoc);
        int numPages = pdDoc.getNumberOfPages();
        for (int i = 0; i < numPages; i++) {
            PDPage p = pdDoc.getPage(i);
            //System.out.println(String.format("width - %f, height - %f", p.getMediaBox().getWidth(), p.getMediaBox().getHeight()));
            images.add(renderer.renderImage(i));
        }
        return images;
    }

}
