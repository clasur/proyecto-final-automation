package clasur.falabella.pageobject;

import clasur.falabella.UtilHelper;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage {

    private String inputName = "q";
    private String wordFalabella = "falabella";
    private String xPathFalabella = "//h3[contains(text(),'Falabella.com')]";
    public GooglePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://www.google.com");
    }
    public void gofalabella(){
        UtilHelper.exploreByNameAndWaitIntro(this.webDriver, this.inputName, this.wordFalabella);
        UtilHelper.exploreByXPathAndWaitClick(this.webDriver, this.xPathFalabella);
    }
}
