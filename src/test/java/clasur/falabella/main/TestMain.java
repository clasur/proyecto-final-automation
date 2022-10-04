package clasur.falabella.main;

import clasur.falabella.pageobject.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestMain {
    private WebDriver webDriver;

    @BeforeTest
    public void preloadTest(){

        System.setProperty("webdriver.chrome.driver","resourses/chromedriver.exe");
        webDriver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver","resourses/geckodriver.exe");
        //webDriver = new FirefoxDriver();
        //Mazimize current window
        webDriver.manage().window().maximize();

    }


    @Test
    public void testMain() {
        GooglePage googlePage = new GooglePage(webDriver);
        googlePage.gofalabella();

        SearchFalabellaPage searchFalabellaPage = new SearchFalabellaPage(webDriver);
        searchFalabellaPage.viewDetailsItem();

        DetailProductFalabellaPage detailProductFalabellaPage= new DetailProductFalabellaPage(webDriver);
        detailProductFalabellaPage.addProduct();

        AmountWarrantyPage amountWarrantyPage = new AmountWarrantyPage(webDriver);
        amountWarrantyPage.goCarro();

        CarFalabellaPage carFalabellaPage = new CarFalabellaPage(webDriver);
        carFalabellaPage.goDelivery();
        //carFalabellaPage.increaseProductCount();

        DeliveryFalabellaPage deliveryFalabellaPage= new DeliveryFalabellaPage(webDriver);
        deliveryFalabellaPage.goPay();

        PayFalabellaPage payFalabellaPage= new PayFalabellaPage(webDriver);
        payFalabellaPage.finish();

    }

    public void bussinesLogic(){
      //  webDriver.get("https://www.google.com");

        // 1. Buscar Falabella  en google
        //findByNameAndWaitIntro(webDriver, "q", "falabella");

        //WebElement inputSearch = webDriver.findElement(By.name("q"));
        //inputSearch.sendKeys("falabella");
        //inputSearch.sendKeys(Keys.ENTER);

        // 2. Entrar a la pagina de Falabella.com(Chile)
        //findByXPathAndWaitClick(webDriver,"//h3[contains(text(),'falabella.com | Todo lo que necesitas en un solo l')]" );

        //WebElement linkFalabella = webDriver.findElement(By.xpath("//h3[contains(text(),'falabella.com | Todo lo que necesitas en un solo l')]"));
        //linkFalabella.click();

        //findByXPathAndIntro(webDriver, "//input[@id='testId-SearchBar-Input']","ps4" );

        //String product = "Ps4";
        //findByXPathAndWaitClick(webDriver,"(//b[contains(text(),\"Control Gamepad Ps4 Camuflado Azul\")]/ancestor::a)[1]" );
        //findByXPathAndWaitClick(webDriver,"(//b[contains(text(),'"+product+"')]/ancestor::a)[1]" );
        //findByXPathAndWaitClick(webDriver,"//b[contains(text(),'"+product+"')]" );

        //findByXPathAndWaitClick(webDriver,"//button[contains(text(),'Agregar al Carro')]");

        //findByXPathAndWaitClick(webDriver,"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/button[1]");

        //findByXPathAndIntro(webDriver, "/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]","xbox" );

        //findByXPathAndWaitClick(webDriver,"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]" );

        //findByXPathAndWaitClick(webDriver,"/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/section[2]/div[2]/div[1]/div[2]/div[2]/div[3]/button[1]");

        //findByXPathAndWaitClick(webDriver,"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/button[1]");

        //findByXPathAndIntro(webDriver, "/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]","sega" );

        //findByXPathAndWaitClick(webDriver,"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/section[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]" );

        //findByXPathAndClick(webDriver,"/html[1]/body[1]");

        //findByXPathAndWaitClick(webDriver,"//a[@id='linkButton']");
    }

    @AfterTest
    public void detroyTest(){

    }
}
