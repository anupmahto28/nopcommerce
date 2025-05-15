package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class UnsuccessfullLogin {

    WebDriverWait wait;

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_credentials(String username, String password) {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        Hooks.driver.get("https://demo.nopcommerce.com/login");

        WebElement emailField = Hooks.driver.findElement(By.id("Email"));
        WebElement passwordField = Hooks.driver.findElement(By.id("Password"));

        emailField.clear();
        passwordField.clear();

        emailField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        WebElement loginButton = Hooks.driver.findElement(By.xpath("//button[contains(@class,'login-button')]"));
        loginButton.click();
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String expectedErrorMessage) {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".message-error.validation-summary-errors")));

        String actualMessage = errorMessage.getText();
        assertTrue("Expected error message not found!", actualMessage.contains(expectedErrorMessage));
    }
}
