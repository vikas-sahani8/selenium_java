package com.demoblaze.testCases;

 
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.base.Base;

public class Login extends Base{
	public Login() {
		super();
	}
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = initializeAndOpen(prop.getProperty("browserName"));
	}
	
	 

	@AfterMethod
	public void treaDown() {
		driver.quit();
	}
	
	@Test (priority = 1)
	public void verifyLoginWithInvalidCredentials() {
		 
		driver.get(prop.getProperty("baseUrl"));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("loginusername")).sendKeys("vikas@gm.com");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@type='button' and normalize-space() = 'Log in']")).click();
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert = driver.switchTo().alert();
         String alertMessage = alert.getText();
         System.out.println("Alert Message: " + alertMessage);
         
         // Verify alert message contains "Wrong password."
         Assert.assertTrue(alertMessage.contains(alertMessage), "Alert message verification failed!");
	}
	
	
	@Test (priority = 2)
	public void verifyLoginWithInvalidPassword() {
		 
		driver.get(prop.getProperty("baseUrl"));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("loginusername")).sendKeys("vikas@gmail.com");
		driver.findElement(By.id("loginpassword")).sendKeys("145234");
		driver.findElement(By.xpath("//button[@type='button' and normalize-space() = 'Log in']")).click();
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert = driver.switchTo().alert();
         String alertMessage = alert.getText();
         System.out.println("Alert Message: " + alertMessage);
         
         // Verify alert message contains "Wrong password."
         Assert.assertTrue(alertMessage.contains(alertMessage), "Alert message verification failed!");
	}
	
	@Test (priority = 3)
	public void verifyLoginWithInvalidEmail() {
		 
		driver.get(prop.getProperty("baseUrl"));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("loginusername")).sendKeys("vis@gm.com");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@type='button' and normalize-space() = 'Log in']")).click();
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert = driver.switchTo().alert();
         String alertMessage = alert.getText();
         System.out.println("Alert Message: " + alertMessage);
         
         // Verify alert message contains "Wrong password."
         Assert.assertTrue(alertMessage.contains(alertMessage), "Alert message verification failed!");
	}
	
	@Test (priority = 4)
	public void verifyLoginWithWithoutInput() {
		 
		driver.get(prop.getProperty("baseUrl"));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("loginusername")).sendKeys("");
		driver.findElement(By.id("loginpassword")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='button' and normalize-space() = 'Log in']")).click();
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println("Alert Message: " + alertMessage);
         
         // Verify alert message contains "Wrong password."
         Assert.assertTrue(alertMessage.contains(alertMessage), "Alert message verification failed!");
	}
	
	
	@Test (priority = 5)
	public void verifyLoginWithvalidCredentials() {
		 
		driver.get(prop.getProperty("baseUrl"));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("loginusername")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("loginpassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='button' and normalize-space() = 'Log in']")).click();
		WebElement success = driver.findElement(By.linkText("Log out"));
		if(success.isDisplayed()) {
			System.out.println("Successfully Login");
		}
		 
 
	  
		
	}
}
