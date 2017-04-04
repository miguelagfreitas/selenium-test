package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;

/**
 * Created by Miguel Freitas
 */


public class PdfDecoder {

    private String pdfFilePath;
    private File input;
    private PDDocument pdf;
    private StringBuilder sb;
    private PDFTextStripper pts;


    public PdfDecoder(String pdfFilePath) throws IOException {
        this.pdfFilePath = pdfFilePath;
        System.out.println(this.pdfFilePath);

        input = new File(pdfFilePath);
        pdf = PDDocument.load(input);
        sb = new StringBuilder();
        pts = new PDFTextStripper();
    }

    public String decodePdf() throws IOException {
        sb.append(pts.getText(pdf));
        return sb.toString();
    }



}
