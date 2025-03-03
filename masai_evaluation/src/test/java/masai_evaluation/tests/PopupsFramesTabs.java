package masai_evaluation.tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import masai_evaluation.base.Base;

public class PopupsFramesTabs extends Base {
	

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
	
	   WebElement alt =	driver.findElement(By.xpath("//input[@id='alertbtn']"));
	   alt.click();
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println("Alert Message: " + alertMessage);
		
		 
		
	}
	
	@Test
	public void test2() {
        WebElement confirmBtn = driver.findElement(By.id("confirmbtn"));
        confirmBtn.click();
        Alert confalt = driver.switchTo().alert();
        String alertMessage2 = confalt.getText();
        System.out.println("Alert Message: " + alertMessage2);
        confalt.dismiss();
        
	}
	
	@Test
	public void test3() {
		driver.switchTo().frame("courses-iframe");
		WebElement ifremsElement = driver.findElement(By.xpath("//div[@class='nav-outer clearfix']//a[normalize-space()='Courses']"));
		System.out.println(ifremsElement.getText());
		driver.switchTo().defaultContent();
		

	}
	
	@Test
	public void test4() {
		WebElement newTab = driver.findElement(By.id("opentab"));
		newTab.click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String presentWindow = it.next();
		String changewindow = it.next();
		driver.switchTo().window(changewindow);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(presentWindow);
	}
	
	
	
}
