package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class SubscribeToNewsletter {
    WebDriver driver = Hooks.driver; // Ensure Hooks class is correctly implemented

    @When("User enter my email in the newsletter box")
    public void user_enter_my_email_in_the_newsletter_box() {
        WebElement newsletterBox = driver.findElement(By.id("newsletter-email"));
        newsletterBox.sendKeys("ajaygaikwad@gmail.com");
    }

    @When("User click on \"Subscribe\"")
    public void user_click_on_subscribe() {
        driver.findElement(By.id("newsletter-subscribe-button")).click();
    }

    @Then("A subscription success message should be displayed")
    public void a_subscription_success_message_should_be_displayed() {
        WebElement result = driver.findElement(By.id("newsletter-result-block"));
        assertTrue(result.getText().contains("Thank you for signing up!"));
    }
}
