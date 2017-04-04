import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pdf.PdfDecoder;
import selenium.redeexpressos.RedeExpressosSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by MiguelFreitas(114127 on 4/1/2017.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        File chromeDriver = new File("chromedriver.exe");

        if (!chromeDriver.exists()){
            throw new FileNotFoundException("Web driver não encontrada.");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());

        WebDriver wd = new ChromeDriver();

        new RedeExpressosSearch(wd, "Lamego", "Porto");

    }


}
