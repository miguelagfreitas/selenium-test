import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

/**
 * Created by MiguelFreitas(114127 on 4/1/2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello");

        File file = new File("chromedriver.exe");
        if (!file.exists()){
            System.out.println("WebDriver not found.");
            System.exit(1);
        }

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.santosviagensturismo.pt/pt/");

        String test = "Lamego";

        WebElement search = driver.findElement(By.cssSelector("#s2id_bilheteira-origem"));
        search.click();

        Thread.sleep(7000);
        search = driver.findElement(By.cssSelector("#s2id_autogen5_search"));
        search.sendKeys("Lamego");
        Thread.sleep(5000);
    }


}
