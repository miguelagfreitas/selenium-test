package selenium.redeexpressos;

import org.omg.PortableInterceptor.ORBIdHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiguelFreitas(114127 on 4/4/2017.
 */
public class RedeExpressosSearch extends Thread{

    private ChromeDriver driver;

    private final String searchUrl = "http://www.rede-expressos.pt/horarios.aspx";
    private final String origemDDMenuXpath = "/html/body/form/div/table/tbody/tr/td/table[3]/tbody/tr[4]/td[2]/select";
    private final String destinoDDMenuXpath = "//*[@id=\"divDestCombo\"]/select";
    private final String searchButtonCSS = "body > form > div > table > tbody > tr > td > table:nth-child(6) > tbody > tr > td:nth-child(3) > a";

    private String origem;
    private String destino;

    public RedeExpressosSearch(WebDriver driver, String origem, String destino) throws InterruptedException {
        this.driver = (ChromeDriver) driver;
        driver.get(searchUrl);
        this.origem = origem;
        this.destino = destino;

        this.search();
    }

    public void search() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var origem = document.getElementsByName('CodRNEOrigin')[0];" +
                            "origem.setAttribute('value',100);" +
                            "var destino = document.getElementsByName('CodRNEDest')[0];" +
                            "destino.setAttribute('value', 170);");
        sleep(1000);

        js.executeScript("var formactionpage = 'HorariosList.aspx';" +
                            "var fObj = document.frmDados;" +
                            "fObj.action = formactionpage;" +
                            "fObj.target = '_parent';" +
                            "fObj.submit();");
    }


}
