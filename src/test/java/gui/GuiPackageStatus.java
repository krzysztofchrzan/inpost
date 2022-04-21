package gui;

import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;


public class GuiPackageStatus {
    WebDriver driver = null;
    Properties properties = new Properties();
    String url = "";

    @Before(value = "@selenium")
    public WebDriver setupDriver() {
        properties = ConfigReader.getConfig();
        var driverPath = properties.getProperty("DRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", driverPath);
        url = properties.getProperty("PROD_INPOST_URL");
        driver = new ChromeDriver();
        return driver;
    }

    @After(value = "@selenium")
    public void quitDriver() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Couldn't close driver.");
        }
    }

    @Given("użytkownik wejdzie na strone inpost")
    public void openBrowser() {
        driver.navigate().to(url);

        try {  // zamkniecie popupu
            var cookieButton = By.id("onetrust-accept-btn-handler");
            getWait()
                .until(presenceOf(cookieButton))
                .click();
        } catch (Exception e) {
            System.out.println("Popup not occurs.");
        }
    }

    @When("wprowadzi numer paczki {string} w pole wyszukiwania")
    public void setPackageNumber(String packageCode) {
        var inputCode =  By.xpath("//form[@action='/sledzenie-przesylek']//input");
        getWait()
                .until(presenceOf(inputCode))
                .sendKeys(packageCode);
    }

    @And("kliknie przycisk 'ZNAJDZ'")
    public void buttonSubmit() {
        var form =   By.xpath("//form[@action='/sledzenie-przesylek']");
        getWait()
            .until(presenceOf(form))
            .submit();
    }

    @Then("status paczki powinen miec wartosc {string}")
    public void checkPackageStatus(String expectedStatus) throws Exception {
        var statusLocator = By.xpath("//p[@class='paragraph--component -big -secondary']");
        var statusElement = getWait()
            .until(presenceOf(statusLocator));
        var status = statusElement.getText();
        Assert.assertEquals(status, expectedStatus);

        makeScreenshot();
    }

    private void makeScreenshot(){
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            String simpleDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            ImageIO.write(image, "jpg", new File("./target/screenshot_" + simpleDate + ".jpg"));
        } catch (Exception e) {   // if not executed show error
            e.printStackTrace();
            try {
                throw new Exception("Can't create snapshot:" + e.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    // Wait for loading element on page
    private WebDriverWait getWait() {
        var waitSec = Long.parseLong(properties.getProperty("DEFAULT_WEBDRIVER_WAIT_SEC"));
        return new WebDriverWait(driver, waitSec);
    }

    // Check whether element exists in the DOM
    private ExpectedCondition<WebElement> presenceOf (By locator) {
        return ExpectedConditions.presenceOfElementLocated(locator);
    }
}
