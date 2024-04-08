package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProceedToBuy {
    public static WebElement element = null;

    public ProceedToBuy(WebDriver driver) {

    }

    public static WebElement proceedToBuy(WebDriver driver) {
        element = driver.findElement(By.id("buy-now-button"));
        return element;
    }
}