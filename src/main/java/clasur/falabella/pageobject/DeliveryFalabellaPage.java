package clasur.falabella.pageobject;

import clasur.falabella.UtilHelper;
import org.openqa.selenium.WebDriver;

public class DeliveryFalabellaPage extends BasePage{

    private String clientEmail = "sisi@hotmail.com";
    private String emailId= "testId-Input-email";

    private String continueWordXPath= "//button[contains(text(),\"Continuar\")]";
    private String addressSend = "Pedro Lira 112, La Serena, Coquimbo, Chile" ;

    private String addressIdInput= "testId-Input-street";

    private String addressIdMenu= "testId-Dropdown-Pedro Lira 112, La Serena, Coquimbo, Chile";
    private String continueAndSaveTitle = "//button[contains(text(),\"Confirmar y Guardar\")]";

    private String goPayXPath= "//button[contains(text(),\"Ir a pagar\")]";
    public DeliveryFalabellaPage  (WebDriver webDriver) {
        super(webDriver);
    }
    public void goPay(){
        UtilHelper.exploreByIdAndWaitIntroWord(webDriver,emailId,clientEmail);
        UtilHelper.exploreByXPathAndWaitClickJavaScript(webDriver,continueWordXPath);
        UtilHelper.exploreByIdAndWaitIntroWord(webDriver, addressIdInput, addressSend);
        UtilHelper.exploreByIdAndWaitClick (webDriver,addressIdMenu);
        UtilHelper.exploreByXPathAndWaitClickJavaScript(webDriver,continueAndSaveTitle);
        UtilHelper.exploreByXPathAndWaitClickJavaScript(webDriver,goPayXPath);
    }
}
