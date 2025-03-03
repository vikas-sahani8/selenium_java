package BooksToScrape;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class bookstoscrapetest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Creating Actions class instance
        Actions actions = new Actions(driver);

        try {
            
            driver.get("https://books.toscrape.com/");
            String title = driver.getTitle();
            if (title.equals("My Store")) {
                System.out.println("Test Case 1 Passed: Page title is correct");
            } else {
                System.out.println("Test Case 1 Failed: Page title is incorrect");
            }

            
            driver.get("https://books.toscrape.com/");
            WebElement nonFictionLink = driver.findElement(By.linkText("Nonfiction"));
            actions.moveToElement(nonFictionLink).click().perform();  
            if (driver.getPageSource().contains("Nonfiction")) {
                System.out.println("Test Case 2 Passed: Nonfiction page is displayed");
            } else {
                System.out.println("Test Case 2 Failed: Nonfiction page is not displayed");
            }

 
            driver.get("https://books.toscrape.com/");
            WebElement book = driver.findElement(By.cssSelector(".product_pod h3 a"));  
            actions.moveToElement(book).click().perform();  

            WebElement getProduct = driver.findElement(By.xpath("(//div[@class='image_container'])[1]"));
            actions.moveToElement(getProduct).click().perform();  

            
        } catch (Exception e) {
            System.out.println("Test execution encountered an error: " + e.getMessage());
        } finally {
             
            driver.quit();
        }

	}

}
