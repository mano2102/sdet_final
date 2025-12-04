package runner;

import java.io.IOException;
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
	public void beforeMethod() throws IOException {
		openBrowser();
		LoggerHandler.logError("Sample");
		Reporter.generateExtentReport("Sample");
		Screenshot.getScreenShot(driver,"mano");

	}

	@Test
	public void test() {
		// Write your scripts hear
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("user001@email.com");
		driver.findElement(By.xpath("//input[@id=\"old-password\"]")).sendKeys("password321");
		driver.findElement(By.xpath(
				"//*[@id=\"​\"]/body/div[1]/div[1]/div/div[1]/div[3]/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div[3]/form/div/div/div/div[5]/div/div/div/div/div/div[1]/button/div/div[2]"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"​\"]/body/div[1]/div[1]/div/div[1]/div[3]/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div[3]/form/div/div/div/div[3]/div/div/div[1]/div/div[1]/label/span/div/div/div[2]/a/div/div[2]/span/span")).click();

	}

	@AfterMethod
	public void tearDown() {
		// Quitting the browser

		if (driver != null) {
			driver.quit();
		}
	}

}
