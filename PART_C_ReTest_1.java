package runner;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Base;
import utils.EventHandler;
import utils.Screenshot;

public class TestRunner extends Base {

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		openBrowser();

	}

	@Test
	public void test() {
		// Write your scripts hear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Click Samsung Galaxy S23 Ultra
		WebElement samsung = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//h3[contains(text(),'Samsung Galaxy S23 Ultra')]")));
		samsung.click();

		// Click Add to Cart
		WebElement addToCart = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//button[contains(text(),'Add to Cart')]")));
		addToCart.click();

		// Click Proceed to Payment
		WebElement proceedPayment = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//a[contains(text(),'Proceed to Payment')]")));
		proceedPayment.click();

		// Capture screenshot
		try {
			Screenshot.getScreenShot(driver, "PaymentPage");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		// Quitting the browser
	}

}
