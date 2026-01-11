package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class LoginSteps {

    private AppiumDriver driver;

    @Given("user opens application")
    public void user_opens_application() {
        driver = DriverFactory.initDriver();
    }

    @When("user login with valid username and password")
    public void user_login_with_valid_username_and_password() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.saucelabs.mydemoapp.android:id/menuIV"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.saucelabs.mydemoapp.android:id/menuRV")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"Log In\")")))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET")))
                .sendKeys("bod@example.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET")))
                .sendKeys("10203040");

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginBtn")))
                .click();
    }

    @Then("user should see product page")
    public void user_should_see_product_page() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.ViewGroup\").instance(2)")
        ));
    }
}
