package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class DiscountCoupon {
    private WebDriver driver;

    public DiscountCoupon() {
        this.driver = Hooks.driver;
    }

    @Given("User is at the checkout with a valid coupon")
    public void user_is_at_the_checkout_with_a_valid_coupon() {
        user_is_logged_in_and_the_cart_has_products();
        user_go_to_the_cart();
        user_click_on_checkout();
    }

    @When("User enter {string} in the coupon field")
    public void user_enter_in_the_coupon_field(String couponCode) {
        WebElement couponBox = driver.findElement(By.id("discountcouponcode"));
        couponBox.clear();
        couponBox.sendKeys(couponCode);
    }

    @When("User click on \"Apply coupon\"")
    public void user_click_on_apply_coupon() {
        driver.findElement(By.name("applydiscountcouponcode")).click();
    }

    @Then("the discount should be applied to the total")
    public void the_discount_should_be_applied_to_the_total() {
        WebElement message = driver.findElement(By.className("message"));
        assertTrue("Discount message not found", message.getText().contains("The coupon code was applied"));
    }

    private void user_is_logged_in_and_the_cart_has_products() {
        assertTrue("User is not logged in", driver.findElement(By.className("account")).isDisplayed());
        driver.findElement(By.className("cart-label")).click();
        assertTrue("Cart is not displayed", driver.findElement(By.className("cart")).isDisplayed());
    }

    private void user_go_to_the_cart() {
        driver.findElement(By.className("cart-label")).click();
    }

    private void user_click_on_checkout() {
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
    }
}
