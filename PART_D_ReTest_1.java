package runner;
 
import java.io.IOException;
import java.net.MalformedURLException;
 
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import utils.EventHandler;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Base;
import utils.Screenshot;
import utils.WebDriverHelper;
 
public class TestSample extends Base {
    WebDriverHelper helper;
 
    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {
        // launch your browser
        openBrowser();
        LoggerHandler.logInfo("hi hey hello hello");
        Reporter.generateExtentReport("Sample");
    }
 
    @Test
    public void testOne() throws IOException {
        // write or call your pages here
        helper = new WebDriverHelper(driver);
 
        helper.clickOnElement(By.xpath("//button[@id='moe-dontallow_button']"));
        helper.javascriptScroll(By.linkText("Contact Us"));
        helper.clickOnElement(By.linkText("Contact Us"));
 
        helper.clickOnElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/a[2]/div"));
 
        Screenshot.getScreenShot(driver, "screenshot");
    }
 
    @AfterMethod
    public void tearDown() {
        // quit the driver here
        driver.quit();
    }
 
}
 
