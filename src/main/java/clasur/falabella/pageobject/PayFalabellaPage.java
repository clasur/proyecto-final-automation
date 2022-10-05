package clasur.falabella.pageobject;

import clasur.falabella.helper.UtilHelper;
import org.openqa.selenium.WebDriver;

public class PayFalabellaPage extends BasePage{

    private String giftCardXPath= "//div[@data-testid=\"testId-paymentOption-GIFT_CARD\"]";
    private String choosePayXPath = "//button[contains(text(),\"Si, cambiar medio de pago\")]";
    private String inputCardId = "testId-Input-cardNumber";
    private String numberCard = "1234567890";
    private String codeSecurityId = "testId-Input-securityCode";
    private String numberCodeSecurity= "1234567";
    private String addDateGitfCard = "//button[contains(text(),\"Agregar\")]";

    //private String acceptFinish = "//button[contains(text(),\"Aceptar\")]";

    public PayFalabellaPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void finish(){
        UtilHelper.exploreByXPathAndWaitClickJavaScript(webDriver,giftCardXPath);
        UtilHelper.exploreByXPathAndWaitClickJavaScript(webDriver,choosePayXPath);
        UtilHelper.exploreByIdAndWaitIntroWord(webDriver,inputCardId, numberCard);
        UtilHelper.exploreByIdAndWaitIntroWord(webDriver,codeSecurityId, numberCodeSecurity);
        UtilHelper.exploreByXPathAndWaitClickJavaScript(webDriver,addDateGitfCard);
    }
}
