package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
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

        @And("user adds product to cart")
        public void user_adds_product_to_cart() {
                init();
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt")))
                                .click();
        }

        @And("product should be added to cart")
        public void product_should_be_added_to_cart() {
                init();

                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartTV")))
                                .click();

                WebElement productInCart = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/infoCL")));
                Assert.assertTrue(productInCart.isDisplayed());
        }

        @When("user proceeds to checkout")
        public void user_proceeds_to_checkout() {
                init();

                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt")))
                                .click();

                WebElement loginPage = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                AppiumBy.androidUIAutomator(
                                                                "new UiSelector().className(\"android.view.ViewGroup\").instance(2)")));

                Assert.assertTrue(loginPage.isDisplayed());

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

        @And("user filled the checkout information")
        public void user_filled_the_checkout_information() {       
                init();

                WebElement CheckOutPage = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                AppiumBy.androidUIAutomator(
                                                                "new UiSelector().className(\"android.widget.LinearLayout\").instance(2)")));

                Assert.assertTrue(CheckOutPage.isDisplayed()); 

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/fullNameET")))
                                .sendKeys("Kintan Test");

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/address1ET")))
                                .sendKeys("Jakarta");

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/cityET")))
                                .sendKeys("Jakarta");

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/zipET")))
                                .sendKeys("23841");

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/countryET")))
                                .sendKeys("Indonesia");
                                
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn")))
                                .click(); 
        }

        @And("user filled the payment information")
        public void user_filled_the_payment_information() {      
                init();

                WebElement paymentPage = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                AppiumBy.androidUIAutomator(
                                                                "new UiSelector().className(\"android.view.ViewGroup\").instance(3)")));

                Assert.assertTrue(paymentPage.isDisplayed()); 

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET")))
                                .sendKeys("Kintan");

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/cardNumberET")))
                                .sendKeys("4111111111111111");

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/expirationDateET")))
                                .sendKeys("12/26");

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/securityCodeET")))
                                .sendKeys("347");

                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn")))
                                .click();

        }

        @And("user reviews the order")
        public void user_reviews_the_order() {        
                init();

                WebElement reviewPage = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                AppiumBy.androidUIAutomator(
                                                                "new UiSelector().className(\"android.view.ViewGroup\").instance(3)")));

                Assert.assertTrue(reviewPage.isDisplayed());
        }

        @And("user places the order")
        public void user_places_the_order() {        
                init();

                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn")))
                                .click();
        }

        @Then("order should be placed successfully")
        public void user_should_see_checkout_page() {           
                init();

                WebElement checkoutPage = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                AppiumBy.id("com.saucelabs.mydemoapp.android:id/completeTV")));

                Assert.assertTrue(checkoutPage.isDisplayed());
        }

}
