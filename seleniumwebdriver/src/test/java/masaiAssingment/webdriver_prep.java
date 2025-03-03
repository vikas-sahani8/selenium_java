package masaiAssingment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriver_prep {
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

	 
		WebElement editBox = driver.findElement(By.id("name")); 
		if (editBox.isEnabled()) { 
			editBox.sendKeys("Test User"); 
			System.out.println("Entered text: " + editBox.getAttribute("value"));  
			editBox.clear(); // Clear text
		}

		 
		WebElement button = driver.findElement(By.id("openwindow")); 
		if (button.isEnabled()) {  
			System.out.println("Button text: " + button.getText());  
			button.click(); 
		}
 
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				checkbox.click();  
			}
			System.out.println("Checkbox selected: " + checkbox.isSelected()); 
		}

		 
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement radio : radioButtons) {
			if (radio.getAttribute("value").equals("radio2")) {  
				radio.click();
			}
			System.out.println("Radio button value: " + radio.getAttribute("value") + " Selected: " + radio.isSelected());
		}

		// Close driver
		driver.quit();
	}

}
