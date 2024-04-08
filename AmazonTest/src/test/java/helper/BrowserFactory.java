package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
public class BrowserFactory {
    public static WebDriver driver;

    public static WebDriver startBrowser(String browserName, String url) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                // Firefox setup
                break;
            case "edge":
                // Edge setup
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        return  driver;
    }
}

