package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class AddProductToWishlist {
    WebDriver driver = Hooks.driver;

    @When("User navigates to the product page for {string}")
    public void user_navigates_to_the_product_page_for(String productName) {
        WebElement searchBar = driver.findElement(By.id("small-searchterms"));
        searchBar.clear();
        searchBar.sendKeys(productName);
        driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
        driver.findElement(By.linkText(productName)).click();
    }

    @When("User clicks on \"Add to wishlist\"")
    public void user_clicks_on_add_to_wishlist() {
        driver.findElement(By.id("add-to-wishlist-button-4")).click();
    }

    @Then("the product should be added to the wishlist")
    public void the_product_should_be_added_to_the_wishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));
        assertTrue("Product was not added to the wishlist", notification.getText().contains("The product has been added"));
    }
}
