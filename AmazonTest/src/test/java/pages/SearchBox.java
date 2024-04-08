package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchBox {
    public static WebElement element = null;

    public SearchBox(WebDriver driver) {
    }

    public static WebElement textbox_search(WebDriver driver){
        element = driver.findElement(By.id("twotabsearchtextbox"));
        return element;
    }
    public static WebElement button_search(WebDriver driver){
        element = driver.findElement(By.id("nav-search-submit-button"));
        return element;
    }
    public static WebElement clickonFirstItem(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']//img[@data-image-index='1']"));
        return element;
    }
}
