package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class Add_Product_non_exist {

    private WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(Add_Product_non_exist.class.getName());

    public Add_Product_non_exist() {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    }

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        Hooks.driver.get("https://demo.nopcommerce.com/");
        logger.info("Navigated to homepage.");
    }

    @When("user searches for a non-existing product")
    public void user_searches_for_a_non_existing_product() {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
        searchBox.sendKeys("abcxyz");

        Hooks.driver.findElement(By.cssSelector("form[action='/search'] button[type='submit']")).click();
        logger.info("Performed search for 'abcxyz'.");
    }

    @Then("a message should be displayed indicating no products were found")
    public void a_message_should_be_displayed_indicating_no_products_were_found() {
        WebElement noResultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("no-result")));
        assert noResultMessage.isDisplayed();
        logger.info("No products found message displayed: " + noResultMessage.getText());
    }
}
