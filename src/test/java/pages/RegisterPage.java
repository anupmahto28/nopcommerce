package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By genderMale = By.id("gender-male");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By successMessage = By.className("result");

    // Actions
    public void navigateToRegisterPage() {
        driver.get("https://demo.nopcommerce.com/register");
    }

    public void fillRegistrationForm(String fName, String lName, String emailAddr, String pwd, String confirmPwd) {
        driver.findElement(genderMale).click();
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(emailAddr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccessful() {
        WebElement message = driver.findElement(successMessage);
        return message.isDisplayed();
    }
}
