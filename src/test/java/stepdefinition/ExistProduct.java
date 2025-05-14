package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class ExistProduct {
    private WebDriver driver;

    @Given("User navigate to {string}")
    public void user_navigate_to(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Given("User log in with email {string} and password {string}")
    public void user_log_in_with_email_and_password(String email, String password) {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    }

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        WebElement searchBar = driver.findElement(By.id("small-searchterms"));
        assertTrue(searchBar.isDisplayed());
    }

    @When("User enter {string} in the search bar")
    public void user_enter_in_the_search_bar(String productName) {
        WebElement searchBar = driver.findElement(By.id("small-searchterms"));
        searchBar.sendKeys(productName);
    }

    // This is the additional step you asked to include
    @When("User enter {string} Usern the search bar")
    public void user_enter_usern_the_search_bar(String productName) {
        WebElement searchBar = driver.findElement(By.id("small-searchterms"));
        searchBar.sendKeys(productName);
    }

    @When("User click on the search icon")
    public void user_click_on_the_search_icon() {
        driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
    }

    @Then("relevant products should be displayed in search results")
    public void relevant_products_should_be_displayed_in_search_results() {
        WebElement searchResults = driver.findElement(By.className("product-grid"));
        assertTrue(searchResults.isDisplayed());
        driver.quit();
    }
}
