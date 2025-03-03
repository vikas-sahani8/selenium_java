package com.demoblaze.testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.base.Base;
import com.demoblaze.utilities.utilities;
 

public class SignUp extends Base{
	public SignUp() {
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
	
	@Test
	public void verifySignupWithInvalidUserName() {
		
		driver.get(prop.getProperty("baseUrl"));
		driver.findElement(By.linkText("Sign up")).click();
		driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys(utilities.genrateInvalidUsername());
		driver.findElement(By.id("sign-password")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@type='button'and normalize-space() = 'Sign up']")).click();
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println("Alert Message: " + alertMessage);
        Assert.assertTrue(alertMessage.contains("Invalid username"));

         
        alert.accept();
	}
	
	@Test
	public void verifySignupWithMandetoryFilds() {
		
		driver.get(prop.getProperty("baseUrl"));
		driver.findElement(By.linkText("Sign up")).click();
		driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys(utilities.genrateUsername());
		driver.findElement(By.id("sign-password")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@type='button'and normalize-space() = 'Sign up']")).click();
		
		
		driver.quit();
	}
	
	
}
