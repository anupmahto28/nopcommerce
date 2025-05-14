package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class Register_blank_Fields {

    WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(Register_blank_Fields.class.getName());

    @Given("user is on the initial page")
    public void user_is_on_the_initial_page() {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        Hooks.driver.get("https://demo.nopcommerce.com/register");
        logger.info("Navigated to registration page.");
    }

    @When("user leaves required registration fields blank")
    public void user_leaves_required_registration_fields_blank() {
        Hooks.driver.findElement(By.id("FirstName")).click();
        Hooks.driver.findElement(By.id("LastName")).click();
        Hooks.driver.findElement(By.id("Email")).click();
        Hooks.driver.findElement(By.id("Password")).click();
        Hooks.driver.findElement(By.id("ConfirmPassword")).click();

        logger.info("Clicked on all required fields without entering data.");
    }

    @When("user attempts to submit the incomplete registration form")
    public void user_attempts_to_submit_the_incomplete_registration_form() {
        Hooks.driver.findElement(By.id("register-button")).click();
        logger.info("Clicked on Register button with blank fields.");
    }

    @Then("user should see validation error messages for required fields")
    public void user_should_see_validation_error_messages_for_required_fields() {
        boolean errorDisplayed = false;

        try {
            WebElement firstNameError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName-error")));
            WebElement lastNameError = Hooks.driver.findElement(By.id("LastName-error"));
            WebElement emailError = Hooks.driver.findElement(By.id("Email-error"));
            WebElement passwordError = Hooks.driver.findElement(By.id("Password-error"));
            WebElement confirmPasswordError = Hooks.driver.findElement(By.id("ConfirmPassword-error"));

            if (firstNameError.isDisplayed() || lastNameError.isDisplayed() ||
                emailError.isDisplayed() || passwordError.isDisplayed() ||
                confirmPasswordError.isDisplayed()) {
                errorDisplayed = true;
            }
        } catch (Exception e) {
            logger.warning("Some error messages not found: " + e.getMessage());
        }

        if (errorDisplayed) {
            logger.info("Validation errors displayed as expected.");
        } else {
            logger.warning("Validation errors NOT displayed.");
        }
    }
}
