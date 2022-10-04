package clasur.falabella;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilHelper {
    static long waitSeconds = 100;

    public static void exploreByXPathAndWaitClick(WebDriver webDriver, String xPath){
        waitByXPath(webDriver, xPath);
        findByXPath(webDriver, xPath).click();
    }

    public static void exploreByXPathAndWaitClickJavaScript(WebDriver webDriver, String xPath){
        waitByXPath(webDriver, xPath);
        WebElement element = findByXPath(webDriver, xPath);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)webDriver;
        javascriptExecutor.executeScript("arguments[0].click()",element);
    }
    public static void exploreByNameAndWaitIntro(WebDriver webDriver, String name, String word){
        waitByName(webDriver, name);
        WebElement element = findByName(webDriver, name);
        element.sendKeys(word);
        element.sendKeys(Keys.ENTER);
    }
    public static void exploreByIdAndWaitIntro(WebDriver webDriver, String id, String word){
        waitById(webDriver, id);
        WebElement element = findById(webDriver, id);
        element.sendKeys(word);
        element.sendKeys(Keys.ENTER);
    }
    public static void exploreByIdAndWaitIntroWord(WebDriver webDriver, String id, String word){
        waitById(webDriver, id);
        WebElement element = findById(webDriver, id);
        element.sendKeys(word);
        //element.sendKeys(Keys.ENTER);
    }
    public static void exploreByIdAndWaitClick(WebDriver webDriver, String id){
        waitById(webDriver, id);
        findById(webDriver, id).click();
    }
    private static void waitByName(WebDriver webDriver , String name){
        WebDriverWait waitByName = new WebDriverWait(webDriver, Duration.ofSeconds(waitSeconds));
        waitByName.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
    }

    private static void waitById(WebDriver webDriver , String id){
        WebDriverWait waitById = new WebDriverWait(webDriver, Duration.ofSeconds(waitSeconds));
        waitById.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    private static void waitByXPath(WebDriver webDriver , String xpath) {
        WebDriverWait waitByXPath = new WebDriverWait(webDriver, Duration.ofSeconds(waitSeconds));
        waitByXPath.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    private static WebElement findByXPath(WebDriver webDriver, String xPath){
        WebElement element = webDriver.findElement(By.xpath(xPath));
        return element;
    }


    private static WebElement findByName(WebDriver webDriver, String name){
        WebElement element = webDriver.findElement(By.name(name));
        return element;
    }

    private static WebElement findById(WebDriver webDriver, String id){
        WebElement element = webDriver.findElement(By.id(id));
        return element;
    }
}
