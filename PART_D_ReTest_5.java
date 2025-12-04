package runner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Base;
import utils.EventHandler;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;

public class TestRunner extends Base {

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		openBrowser();
		Reporter.generateExtentReport("sample");

	}

	@Test
	public void test() throws IOException {
		// Write your scripts hear
		Screenshot.getScreenShot(driver, "mano");
		LoggerHandler.logInfo("hi hello ");
		driver.findElement(By.xpath("(//input)[1]")).sendKeys("FirstName");
		driver.findElement(By.xpath("(//input)[2]")).sendKeys("LastName");
		driver.findElement(By.xpath("(//input)[3]")).sendKeys("Work001@email.com");
		Select sel = new Select(driver.findElement(By.xpath("(//select)[1]")));
		sel.selectByValue("India");

	}

	@AfterMethod
	public void tearDown() {
		// Quitting the browser
		if (driver != null) {
			driver.quit();
		}
	}

}
