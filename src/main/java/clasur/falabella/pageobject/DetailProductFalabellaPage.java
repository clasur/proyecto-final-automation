package clasur.falabella.pageobject;

import clasur.falabella.UtilHelper;
import org.openqa.selenium.WebDriver;

public class DetailProductFalabellaPage extends BasePage {

   // private String inputName = "q";
   // private String wordFalabella = "falabella";
    private String xPathAddCar = "//button[contains(text(),\"Agregar al Carro\")]";


    public DetailProductFalabellaPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void addProduct(){
        //UtilHelper.exploreByNameAndWaitIntro(this.webDriver, this.inputName, this.wordFalabella);
        UtilHelper.exploreByXPathAndWaitClickJavaScript(this.webDriver, this.xPathAddCar);
    }


}
