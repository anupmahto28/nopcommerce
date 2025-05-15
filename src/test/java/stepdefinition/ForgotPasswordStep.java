package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ForgotPasswordStep {

    WebDriverWait wait;

    @When("I Click on forget Password button")
    public void i_click_on_forget_password_button() {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        Hooks.driver.get("https://demo.nopcommerce.com/login");

        WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Forgot password?")));
        forgotPasswordLink.click();
    }

    @Then("it should redirect to password Recovery page")
    public void it_should_redirect_to_password_recovery_page() {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement recoveryHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.page-title h1")));

        String pageTitle = recoveryHeader.getText();
        assertTrue("Not redirected to password recovery page", pageTitle.contains("Password recovery"));
    }
}
