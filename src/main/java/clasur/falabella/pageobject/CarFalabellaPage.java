package clasur.falabella.pageobject;

import clasur.falabella.helper.UtilHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarFalabellaPage extends BasePage{

    private String priceWarrantyXPath= "//span[@data-testid=\"testId-selected-warranty\"]";
    private Float priceWarranty;
    private String priceUnitXPath = "//div[@datatestid=\"price-2\"]/span";
    private Float priceUnit;
    private String amountProductXPath="//input[@data-testid=\"15981787-quantity-input\"]";
    private Float amountProduct;

    private String totalPriceXPath= "//span[@data-testid=\"total-amount\"]";
    private Float totalPrice;
    private String continuEXPath = "//button[contains(text(),\'Continuar compra\')]";

    private Float totalPriceCalculate;

    public CarFalabellaPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Float[] validityValueProduct(){

        UtilHelper.waitByXPath(webDriver,priceUnitXPath);
        WebElement webElementUnit = UtilHelper.findByXPath(webDriver, priceUnitXPath);
        String[] splitUnit = webElementUnit.getText().split(" ");
        priceUnit = Float.valueOf(splitUnit[splitUnit.length-1].replace(".",""));
        System.out.println(priceUnit);

        UtilHelper.waitByXPath(webDriver,priceWarrantyXPath);
        WebElement webElement = UtilHelper.findByXPath(webDriver, priceWarrantyXPath);
        String[] split = webElement.getText().split(" ");
        priceWarranty = Float.valueOf(split[split.length-1].replace(".",""));
        System.out.println(priceWarranty);

        UtilHelper.waitByXPath(webDriver,amountProductXPath);
        WebElement webElementAmount = UtilHelper.findByXPath(webDriver, amountProductXPath);
        //String[] splitAmount = webElementAmount.getText().split(" ");
        amountProduct = Float.valueOf(webElementAmount.getAttribute("value"));
        System.out.println(amountProduct);

        UtilHelper.waitByXPath(webDriver, totalPriceXPath);
        WebElement webElementotal = UtilHelper.findByXPath(webDriver, totalPriceXPath);
        System.out.println(webElementotal.getText());
        String[] splitotal = webElementotal.getText().split(" ");
        totalPrice = Float.valueOf(splitotal[splitotal.length-1].replace(".",""));
        System.out.println(totalPrice);

        totalPriceCalculate = (priceUnit*amountProduct)+(priceWarranty*amountProduct);
        System.out.println("Precio Calculado Total : "+totalPriceCalculate);
        return new Float[]{totalPriceCalculate,totalPrice};
    }
    public void goDelivery(){
        UtilHelper.exploreByXPathAndWaitClickJavaScript(webDriver,continuEXPath);
    }
}
