package clasur.falabella.main;

import clasur.falabella.helper.ScreenShotHelper;
import clasur.falabella.pageobject.*;
import clasur.falabella.report.ReportManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class TestMain {
    private WebDriver webDriverChrome;
    private WebDriver webDriverFirefox;
    @BeforeMethod
    public void preloadTest(ITestResult iTestResult) throws Exception {
        ReportManager.init("Reports", "LoginSite");
        ReportManager.getInstance().startTest(iTestResult.getMethod().getMethodName());
        System.setProperty("webdriver.chrome.driver","resourses/chromedriver.exe");
        webDriverChrome = new ChromeDriver();
        webDriverChrome.manage().window().maximize();
        System.setProperty("webdriver.gecko.driver","resourses/geckodriver.exe");
        webDriverFirefox = new FirefoxDriver();
        //Mazimize current window
        webDriverFirefox.manage().window().maximize();

    }
    private void bussinesLogic(WebDriver webDriver){
        GooglePage googlePage = new GooglePage(webDriver);
        googlePage.gofalabella();

        SearchFalabellaPage searchFalabellaPage = new SearchFalabellaPage(webDriver);
        searchFalabellaPage.viewDetailsItem();

        DetailProductFalabellaPage detailProductFalabellaPage= new DetailProductFalabellaPage(webDriver);
        detailProductFalabellaPage.addProduct();

        AmountWarrantyPage amountWarrantyPage = new AmountWarrantyPage(webDriver);
        amountWarrantyPage.goCarro();

        CarFalabellaPage carFalabellaPage = new CarFalabellaPage(webDriver);
        Float[] prices = carFalabellaPage.validityValueProduct();
        Assert.assertEquals(prices[0],prices[1]);
        carFalabellaPage.goDelivery();

        DeliveryFalabellaPage deliveryFalabellaPage= new DeliveryFalabellaPage(webDriver);
        deliveryFalabellaPage.goPay();

        PayFalabellaPage payFalabellaPage= new PayFalabellaPage(webDriver);
        payFalabellaPage.finish();

    }

    @Test
    public void testMain() {
        bussinesLogic(webDriverChrome);
        bussinesLogic(webDriverFirefox);
    }
    @AfterMethod
    public void detroyTest(ITestResult iTestResult){
        try {
            switch (iTestResult.getStatus()){
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if(iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null){
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriverChrome, Status.FAIL, "Failure Image");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(webDriverChrome != null)
                webDriverChrome.quit();
        }
        ReportManager.getInstance().flush();
    }
}
