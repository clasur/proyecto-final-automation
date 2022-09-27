package clasur.falabella.main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestMain {
    private WebDriver webDriver;

    @Test
    public void testMain() {
        System.setProperty("webdriver.chrome.driver","resourses/chromedriver.exe");
        webDriver = new ChromeDriver();

        //Mazimize current window
        webDriver.manage().window().maximize();
        bussinesLogic();


    }

    public void bussinesLogic(){
        webDriver.get("https://www.google.com");

        WebElement inputSearch = webDriver.findElement(By.name("q"));
        inputSearch.sendKeys("falabella");
        inputSearch.sendKeys(Keys.ENTER);

        WebElement linkFalabella = webDriver.findElement(By.xpath("//h3[contains(text(),'falabella.com | Todo lo que necesitas en un solo l')]"));
        linkFalabella.click();

        findByXPathAndIntro(webDriver, "//input[@id='testId-SearchBar-Input']","ps4" );

        findByXPathAndWaitClick(webDriver,"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]" );

        findByXPathAndClick(webDriver,"/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/section[2]/div[2]/div[1]/div[2]/div[2]/div[3]/button[1]");

        findByXPathAndWaitClick(webDriver,"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/button[1]");

        findByXPathAndIntro(webDriver, "/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]","xbox" );


    }

    WebElement findByXPath(WebDriver webDriver, String xPath){
        WebElement element = webDriver.findElement(By.xpath(xPath));
        return element;
    }

    void findByXPathAndIntro(WebDriver webDriver, String xPath, String word){
        WebElement element = findByXPath(webDriver, xPath);
        element.sendKeys(word);
        element.sendKeys(Keys.ENTER);
    }
    void findByXPathAndClick(WebDriver webDriver, String xPath){
        WebElement element = findByXPath(webDriver, xPath);
        element.click();
    }
    void findByXPathAndWaitClick(WebDriver webDriver, String xPath){
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        findByXPathAndClick(webDriver, xPath);

    }

}
