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

       /* System.setProperty("webdriver.gecko.driver","resourses/geckodriver.exe");
        webDriver = new FirefoxDriver();
        bussinesLogic();*/
    }

    public void bussinesLogic(){
        webDriver.get("https://www.google.com");

        WebElement inputSearch = webDriver.findElement(By.name("q"));
        inputSearch.sendKeys("falabella");
        inputSearch.sendKeys(Keys.ENTER);

        WebElement linkFalabella = webDriver.findElement(By.xpath("//h3[contains(text(),'falabella.com | Todo lo que necesitas en un solo l')]"));
        linkFalabella.click();

        WebElement inputSearchFalabella = webDriver.findElement(By.xpath("//input[@id='testId-SearchBar-Input']"));
        inputSearchFalabella.sendKeys("ps4");
        inputSearchFalabella.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));

        WebElement findItem = webDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        findItem.click();

        WebElement putBasquet = webDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/section[2]/div[2]/div[1]/div[2]/div[2]/div[3]/button[1]"));
        putBasquet.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/button[1]")));

        WebElement keepBuy = webDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/button[1]"));
        keepBuy.click();

        findByXPathAndIntro(webDriver, "/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]","xbox" );
       /* WebElement inputSearchFalabella2 = findByXPath(webDriver,);
        inputSearchFalabella2.sendKeys("xbox");
        inputSearchFalabella2.sendKeys(Keys.ENTER);*/

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

}
