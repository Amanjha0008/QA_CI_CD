package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductCart {
    public static WebElement element = null;

    public ProductCart(WebDriver driver) {
    }
    public static void addToCart(WebDriver driver) {
        List<WebElement> element = driver.findElements(By.cssSelector("#add-to-cart-button"));
        System.out.println("----------------" + element.size());
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", element.get(1));
    }
    public static boolean isItemAddedToCart(WebDriver driver) {
        boolean isConditionFulfilled = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h4[class='a-alert-heading']")));
            // If execution reaches here, it means the condition is fulfilled
            isConditionFulfilled = true;
        } catch (TimeoutException e) {
            System.out.println(isConditionFulfilled);
        }
        return isConditionFulfilled;
    }

}