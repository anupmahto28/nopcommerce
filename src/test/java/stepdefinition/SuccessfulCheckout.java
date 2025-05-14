package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class SuccessfulCheckout {
    WebDriver driver = Hooks.driver; // Ensure Hooks class is correctly implemented

    @Given("User is logged in and the cart has products")
    public void user_is_logged_in_and_the_cart_has_products() {
        assertTrue("User is not logged in", driver.findElement(By.className("account")).isDisplayed());
        driver.findElement(By.className("cart-label")).click();
        assertTrue("Cart is not displayed", driver.findElement(By.className("cart")).isDisplayed());
    }

    @When("User go to the cart")
    public void user_go_to_the_cart() {
        driver.findElement(By.className("cart-label")).click();
    }

    @When("User click on \"Checkout\"")
    public void user_click_on_checkout() {
        driver.findElement(By.id("termsofservice")).click(); // Accept terms
        driver.findElement(By.id("checkout")).click();
    }

    @When("User fill in the billing, shipping, and payment details")
    public void user_fill_in_the_billing_shipping_and_payment_details() {
        driver.findElement(By.xpath("//button[contains(@onclick,'Billing.save')]")).click();
        driver.findElement(By.xpath("//button[contains(@onclick,'Shipping.save')]")).click();
        driver.findElement(By.xpath("//button[contains(@onclick,'ShippingMethod.save')]")).click();
        driver.findElement(By.xpath("//button[contains(@onclick,'PaymentMethod.save')]")).click();
        driver.findElement(By.xpath("//button[contains(@onclick,'PaymentInfo.save')]")).click();
    }

    @When("User confirm the order")
    public void user_confirm_the_order() {
        driver.findElement(By.xpath("//button[contains(@onclick,'ConfirmOrder.save')]")).click();
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        WebElement confirmation = driver.findElement(By.className("title"));
        assertTrue("Order confirmation message not found",
                confirmation.getText().contains("Your order has been successfully processed!"));
    }
}
