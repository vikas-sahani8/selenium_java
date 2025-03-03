package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
    public WebDriver driver;
    public Properties prop;

    public Base() {
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
        try (FileInputStream fis = new FileInputStream(propFile)) {
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void browserSetup() {
        String browsername = prop.getProperty("browsername");

        switch (browsername.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browsername);
        }

        driver.get(prop.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    public void configAfterMethod() {
        if (driver != null) {
            driver.manage().window().minimize();
            driver.quit();
        }
    }
}
