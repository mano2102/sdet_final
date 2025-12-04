package runner;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;

public class TestRunner extends Base {

    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {
        // launch your browser
        openBrowser();
        Reporter.generateExtentReport("Sample");
    }

    @Test
    public void testOne() throws IOException {
        // write or call ur pages here
        // String projectRoot = System.getProperty("user.dir");
        // // Folder path inside root
        // String folderPath = projectRoot + File.separator + "logs";

        // // Create folder
        // File folder = new File(folderPath);

        // if (!folder.exists()) {
        //     boolean created = folder.mkdir();
        //     if (created) {
        //         System.out.println("Folder created at: " + folderPath);
        //     } else {
        //         System.out.println("Failed to create folder");
        //     }
        // } else {
        //     System.out.println("Folder already exists");
        // }

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Email009@email.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password@009");
        driver.findElement(By.xpath("//*[@id=\"rememberUn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]")).click();
        Screenshot.getScreenShot(driver, "Screenshots");
        LoggerHandler.logInfo("Message");
    }

    @AfterMethod
    public void tearDown() {
        // quit the driver here
        if (driver != null) {
            driver.quit();
        }
    }
}
