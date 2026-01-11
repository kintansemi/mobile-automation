package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class ProductSteps {

        private AppiumDriver driver;
        private WebDriverWait wait;

        private void init() {
                driver = DriverFactory.getDriver();
                wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }

        @Given("user is on product page")
        public void user_is_on_product_page() {
                init();

                WebElement productPage = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                AppiumBy.androidUIAutomator(
                                                                "new UiSelector().className(\"android.view.ViewGroup\").instance(2)")));

                Assert.assertTrue(productPage.isDisplayed());
        }

        @When("user selects a product")
        public void user_selects_a_product() {
                init();

                driver.findElement(
                                AppiumBy.androidUIAutomator(
                                                "new UiSelector().description(\"Sauce Lab Back Packs\")"))
                                .click();

        }

        @When("user adds product to cart")
        public void user_adds_product_to_cart() {
                init();
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt")));
        }

        @Then("product should be added to cart")
        public void product_should_be_added_to_cart() {
                init();

                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV")))
                                .click();

                WebElement productInCart = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/titleTV")
                                ));
                Assert.assertTrue(productInCart.isDisplayed());
        }
}
