package clasur.falabella.pageobject;

import clasur.falabella.UtilHelper;
import org.openqa.selenium.WebDriver;

public class CarFalabellaPage extends BasePage{

    private int amountProduct = 0;

    private String continuEXPath = "//button[contains(text(),\'Continuar compra\')]";

    public CarFalabellaPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void increaseProductCount(){
        amountProduct++;
    }
    public void goDelivery(){
        UtilHelper.exploreByXPathAndWaitClickJavaScript(webDriver,continuEXPath);
    }
}
