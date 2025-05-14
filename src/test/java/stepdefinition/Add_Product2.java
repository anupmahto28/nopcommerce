package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class Add_Product2 {

    private WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(Add_Product2.class.getName());

    public Add_Product2() {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    }

    @Given("user logs in and selects a product")
    public void user_logs_in_and_selects_a_product() {
        Hooks.driver.get("https://demo.nopcommerce.com/login");
        logger.info("Navigated to login page.");

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        WebElement password = Hooks.driver.findElement(By.id("Password"));
        email.clear();
        email.sendKeys("ajaygaikwad@gmail.com");
        password.sendKeys("Bookmyshow@123");

        Hooks.driver.findElement(By.className("login-button")).click();
        logger.info("Logged in successfully.");

        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Build your own computer")));
        productLink.click();
        logger.info("Navigated to product page.");
    }

    @When("user customizes and adds the product to the cart")
    public void user_customizes_and_adds_the_product_to_the_cart() {
        new Select(Hooks.driver.findElement(By.id("product_attribute_1")))
                .selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
        new Select(Hooks.driver.findElement(By.id("product_attribute_2")))
                .selectByVisibleText("2 GB");

        Hooks.driver.findElement(By.id("product_attribute_3_6")).click(); // HDD
        Hooks.driver.findElement(By.id("product_attribute_4_8")).click(); // OS
        Hooks.driver.findElement(By.id("product_attribute_5_10")).click(); // Software

        Hooks.driver.findElement(By.id("add-to-cart-button-1")).click();
        logger.info("Clicked Add to Cart.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar-notification.success")));
    }

    @Then("user verifies the product in the cart")
    public void user_verifies_the_product_in_the_cart() {
        Hooks.driver.get("https://demo.nopcommerce.com/cart");
        logger.info("Navigated to cart page.");

        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-item-row")));
        assert cartItem.isDisplayed();
        logger.info("Product successfully added to cart.");
    }
}
