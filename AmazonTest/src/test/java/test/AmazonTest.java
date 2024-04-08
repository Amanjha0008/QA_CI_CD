package test;

import pages.ProceedToBuy;
import helper.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchBox;
import pages.ProductCart;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import static helper.BrowserFactory.driver;

public class AmazonTest {
    public static WebDriver driver;
    public static ChromeOptions options;
    public static WebDriverWait wait;
    private static final
    Logger logger = Logger.getLogger(BrowserFactory.class.getName());

    @BeforeTest
    public void setup() {
        options = new ChromeOptions();
        //   options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        // System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }
//        driver = BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");
//        String page_title = driver.getTitle();
//        // Set the path to ChromeDriver executable
//        logger.info("Page Title:" + page_title);


    @Test(priority = 0)
    public void SearchAndClickFirstProduct() {

        SearchBox.textbox_search(driver).sendKeys("apple phones", Keys.ENTER);
        SearchBox.button_search(driver).click();
        Assert.assertTrue(driver.getTitle().contains("apple phones"), "Search results page did not load successfully");

        // Click on the first product
        SearchBox.clickonFirstItem(driver).click();
        Assert.assertTrue(SearchBox.clickonFirstItem(driver).isEnabled(), "First product is not clickable");

        Set<String> handle = driver.getWindowHandles();
        Iterator<String> it = handle.iterator();
        String parentwindowid = it.next();
        System.out.println("your parent window is : " + parentwindowid);

        String childwindowid = it.next();
        System.out.println("your child window is : " + childwindowid);

        driver.switchTo().window(childwindowid);
        String title1 = driver.getTitle();
        System.out.println(title1);

    }

    @Test(priority = 1)
    public void addToCart() {
//        ProductCart.addToCart(driver).click();
        ProductCart.addToCart(driver);
        Assert.assertTrue(ProductCart.isItemAddedToCart(driver));
    }

    @Test(priority = 1)
    public void proceedBuy() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        ProceedToBuy.proceedToBuy(driver).click();


    }
}
