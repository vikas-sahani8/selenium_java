package masai_evaluation.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import masai_evaluation.base.ExcelUtills;

public class DataDrivenTest {

    WebDriver driver;  
    WebDriverWait wait;

    @BeforeMethod
    public void setups() {
        driver = new ChromeDriver();  
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
 
    @Test(dataProvider = "loginData")
    public void test1(String username, String password) {  
        // Locate and enter login credentials
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        try {
            // Wait for Dashboard to appear (successful login)
            WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
            
            // Assertion: Dashboard should be displayed
            Assert.assertTrue(dashboard.isDisplayed(), "Login failed: Dashboard not found.");
            System.out.println("✅ Login successful for: " + username);
        } catch (Exception e) {
            // If login fails, check for an error message
            try {
                WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'oxd-alert-content-text')]")));

                // Assertion: Error message should be displayed for failed login
                Assert.assertTrue(errorMsg.isDisplayed(), "❌ Login failed but no error message was found.");
                System.out.println("❌ Login failed for: " + username + " - Error: " + errorMsg.getText());
            } catch (Exception ex) {
                Assert.fail("❌ Login failed but no error message or dashboard found.");
            }
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        return ExcelUtills.readExcelData("src/test/resources/data.xlsx");
    }
}
