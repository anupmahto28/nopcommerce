package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Register {

    WebDriverWait wait;

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        Hooks.driver.get("https://demo.nopcommerce.com/register");
    }

    @When("user enter valid registration details")
    public void user_enter_valid_registration_details() {
        String gender = "Male";
        String firstName = "Ajay";
        String lastName = "Gaikwad";
        String email = "ajaygaikwad" + System.currentTimeMillis() + "@gmail.com"; // Unique email
        String password = "Bookmyshow@123";
        String confirmPassword = "Bookmyshow@123";

        WebElement genderMale = Hooks.driver.findElement(By.id("gender-male"));
        WebElement firstNameField = Hooks.driver.findElement(By.id("FirstName"));
        WebElement lastNameField = Hooks.driver.findElement(By.id("LastName"));
        WebElement emailField = Hooks.driver.findElement(By.id("Email"));
        WebElement passwordField = Hooks.driver.findElement(By.id("Password"));
        WebElement confirmPasswordField = Hooks.driver.findElement(By.id("ConfirmPassword"));

        if (gender.equalsIgnoreCase("Male")) {
            genderMale.click();
        }
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
    }

    @When("user submit the registration form")
    public void user_submit_the_registration_form() {
        WebElement registerButton = Hooks.driver.findElement(By.id("register-button"));
        registerButton.click();
    }

    @Then("user should see a registration success message")
    public void user_should_see_a_registration_success_message() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));
        assert successMessage.isDisplayed();
        System.out.println("Registration successful!");
    }
}
