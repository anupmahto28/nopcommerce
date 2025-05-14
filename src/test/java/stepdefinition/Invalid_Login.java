package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class Invalid_Login {

    WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(Invalid_Login.class.getName());

    @Given("user is on the initial login page")
    public void user_is_on_the_initial_login_page() {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        Hooks.driver.get("https://demo.nopcommerce.com/login");
        logger.info("Navigated to the login page.");
    }

    @When("user enters invalid login credentials")
    public void user_enters_invalid_login_credentials() {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        WebElement password = Hooks.driver.findElement(By.id("Password"));

        email.clear();
        email.sendKeys("invaliduser");
        password.clear();
        password.sendKeys("WrongPassword123");
        logger.info("Entered invalid credentials.");
    }

    @When("user submits the login form")
    public void user_submits_the_login_form() {
        WebElement loginButton = Hooks.driver.findElement(By.className("login-button"));
        loginButton.click();
        logger.info("Clicked login button.");
    }

    @Then("user should see an error message for invalid login")
    public void user_should_see_an_error_message_for_invalid_login() {
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-error")));
            assertTrue("Error message not displayed for invalid login.", errorMessage.isDisplayed());
            logger.info("❌ Error message displayed: " + errorMessage.getText());
        } catch (Exception e) {
            logger.severe("Error message not found: " + e.getMessage());
            throw e;
        }
    }
}
