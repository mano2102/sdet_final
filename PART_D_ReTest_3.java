package runner;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Base;
import utils.EventHandler;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class TestRunner extends Base {

    WebDriverHelper helper;

    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {
        // Launch your browser
        openBrowser();
    }

    @Test
    public void testOne() throws IOException {

        // Initialize helper
        helper = new WebDriverHelper(driver);

        // Fill form fields
        helper.sendKeys(By.name("form_fields[firstName]"), "username");
        helper.sendKeys(By.name("form_fields[lastName]"), "lastname");
        helper.sendKeys(By.name("form_fields[email]"), "abc@gmail.com");

        // Dropdown select
        Select subjectDropdown = new Select(driver.findElement(By.name("form_fields[subjectOption]")));
        subjectDropdown.selectByVisibleText("Support for Geeks");

        // Submit form
        helper.clickOnElement(By.xpath("//button[text()='Send']"));

        Reporter.generateExtentReport("Sample");
        // helper.waitForPageLoad();
        Screenshot.getScreenShot(driver, "resultPage");
        // ExtentManager.logPass("Form submitted and screenshot captured.");
        LoggerHandler.logInfo("hi hey hello");

    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver
        driver.quit();
    }
}
