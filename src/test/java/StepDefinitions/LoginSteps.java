package StepDefinitions;

import org.openqa.selenium.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginSteps {
	static WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @When("user enter username and password")
    public void user_enter_username_and_password() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user clicks on login CTA")
    public void user_clicks_on_login_cta() {
        driver.findElement(By.id("login-button")).click();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() throws InterruptedException {
        driver.findElement(By.id("menu_button_container")).isDisplayed();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        driver.quit();
    }
    }
