package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Login {

    WebDriverWait wait;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        Hooks.driver.get("https://demo.nopcommerce.com/login");
    }

    @When("user enter valid login credentials")
    public void user_enter_valid_login_credentials() {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password")));

        email.clear();
        email.sendKeys("ajaygaikwad@gmail.com");
        password.clear();
        password.sendKeys("Bookmyshow@123");
    }

    @When("user submit the login form")
    public void user_submit_the_login_form() {
        WebElement loginButton = Hooks.driver.findElement(By.className("login-button"));
        loginButton.click();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout")));
        assertTrue("Logout link not displayed. Login might have failed.", logoutLink.isDisplayed());
        System.out.println("✅ Login successful!");
    }
}
