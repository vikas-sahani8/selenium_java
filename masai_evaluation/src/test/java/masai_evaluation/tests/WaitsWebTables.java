package masai_evaluation.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import masai_evaluation.base.Base;

public class WaitsWebTables extends Base{
	@BeforeMethod
	public void setups() {
		setup();
	}
	
	@AfterMethod
	public void treaDowns() {
		tearDown();
	}
	
	@Test
	public void test1() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		WebElement table = driver.findElement(By.id("product"));
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", table);
		 
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product']//tr"));
		
		for(WebElement row : rows) {
			System.out.println(row.getText());
		}
	}
}
