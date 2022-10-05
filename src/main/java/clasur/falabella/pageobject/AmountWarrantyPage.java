package clasur.falabella.pageobject;

import clasur.falabella.helper.UtilHelper;
import org.openqa.selenium.WebDriver;

public class AmountWarrantyPage extends BasePage{

    private String buttonaddXPath = "//span[contains(text(),\"+\")]/ancestor::button";
    private String warrantyXPath= "//*[@id=\"testId-InCart-inPDP-WarrantyOption-btn-1\"]";

    private String carXPath= "//a[contains(text(),\"Ir al Carro\")]";
    public AmountWarrantyPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void goCarro(){
        UtilHelper.exploreByXPathAndWaitClick(webDriver,buttonaddXPath);
        UtilHelper.exploreByXPathAndWaitClick(webDriver,buttonaddXPath);
        UtilHelper.exploreByXPathAndWaitClickJavaScript(webDriver,buttonaddXPath);
        UtilHelper.exploreByXPathAndWaitClick(webDriver,warrantyXPath);
        UtilHelper.exploreByXPathAndWaitClick(webDriver,carXPath);
    }
}
