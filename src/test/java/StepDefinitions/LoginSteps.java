package StepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import Locators.PageObjects;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Utils.HelperClass;

import java.time.Duration;

public class LoginSteps{
    PageObjects pg = new PageObjects();
    public WebDriver driver;

    @Before
    public void startBrowser() {
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    @Given("user is on Sogeti landing page")
    public void userIsOnSogetiLandingPage() {
        driver.get("https://www.sogeti.com/");
        driver.findElement((By) pg.acceptCookies).click();
    }

    @When("user selects services and automation")
    public void userSelectsServicesAndAutomation() throws InterruptedException {
        WebElement ele =  driver.findElement(pg.servicesTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();

        boolean automation = driver.findElement(pg.automation).isDisplayed();
        if (automation==true){
            Assert.assertTrue(true,"Automation is displayed");
        } else {
            Assert.fail("Automation is not displayed");
        }
        driver.findElement(pg.automation).click();
    }

    @Then("user verifies services and automation is selected")
    public void userVerifiesServicesAndAutomationIsSelected() {
        WebElement ele =  driver.findElement(pg.servicesTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkElement = driver.findElement(pg.selectedAutomation);
        boolean isSelected = linkElement.getAttribute("class").contains("selected  current expanded");
        if (isSelected) {
            Assert.assertTrue(true,"Automation Link is selected");
            System.out.println("Automation Link is selected");
        } else {
            Assert.fail("Automation Link is not selected");
            System.out.println("Automation Link is not selected");
        }
    }

    @And("user enters First Name, Last Name, Email, Phone, company and Message")
    public void userEntersFirstNameLastNameEmailPhoneAndMessage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)");

        driver.findElement(pg.firstNameField).sendKeys(HelperClass.generateRandomText());
        driver.findElement(pg.lastNameField).sendKeys(HelperClass.generateRandomText());
        driver.findElement(pg.emailIDField).sendKeys(HelperClass.generateRandomEmail());
        driver.findElement(pg.phoneNumField).sendKeys(HelperClass.generateRandomNum());
        driver.findElement(pg.companyName).sendKeys(HelperClass.generateRandomText());
        driver.findElement(pg.messageBox).sendKeys(HelperClass.generateRandomText());
        Thread.sleep(2000);
    }

    @And("user selects country from dropdown and taps on submit")
    public void userSelectsCountryFromDropdownAndTapsOnSubmit() {
        WebElement ele = driver.findElement(pg.countryDropDown);
        Select dropdown = new Select(ele);
        dropdown.selectByIndex(0);

        driver.findElement(pg.iAgreeCheckBox).click();
        driver.switchTo().frame("a-hi2appofyonw");
        driver.findElement(pg.iAgreeCheckBox).click();
        driver.switchTo().defaultContent();

        driver.findElement(pg.submitCTA).click();
    }

    @Then("user verifies Thank you message")
    public void userVerifiesThankYouMessage() {
    }
}
