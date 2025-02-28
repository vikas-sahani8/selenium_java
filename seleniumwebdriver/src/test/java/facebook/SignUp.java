package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUp {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/r.php");
		
		driver.manage().window().maximize();
		
		String act_tital = driver.getTitle();
		if(act_tital.equals("Sign up for Facebook")) {
			System.out.println("Test Pass");		
		}else {
			System.out.println("Test fail");
		}
		
		 WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		 WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		 WebElement day = driver.findElement(By.id("day"));
		 WebElement month = driver.findElement(By.id("month"));
		 WebElement year = driver.findElement(By.id("year"));
		 WebElement gender = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
		 WebElement email = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']"));
		 WebElement pass = driver.findElement(By.xpath("//input[@id='password_step_input']"));
		 WebElement button = driver.findElement(By.xpath("//button[@type='submit' and normalize-space(text())='Sign Up']"));
		 
	    firstName.sendKeys("Vikas");
	    lastName.sendKeys("Sahani");
	    day.sendKeys("31");
	    month.sendKeys("10");
	    year.sendKeys("2001");
	    gender.click();
	    email.sendKeys("alkjfh@gmail.com");
	    pass.sendKeys("12345678241");
	    button.click();
	    
	    
		driver.quit();
	}
	
	
}
