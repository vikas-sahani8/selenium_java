package masai;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class evaluationDemoShop {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/"); 
		driver.manage().window().maximize();
		
		 String tital = driver.getTitle();
		 System.out.println(tital);
		 
		 WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		 searchBox.sendKeys("14.1-inch Laptop");
		 WebElement searchBtn = driver.findElement(By.xpath("//input[@type='submit'][@value ='Search']"));
		 searchBtn.click();
		 
		 WebElement invalidSrc = driver.findElement(By.xpath("//div[@class='page-title']//h1[normalize-space()='Search']"));
	 
		 if(invalidSrc.isDisplayed()) {
			 System.out.println("product not found");
		 }else {
			 System.out.println("Product found");
			 return;
			 
		 }
		 WebElement product = driver.findElement(By.xpath("//div[@class='item-box']/div[@class='product-item'][1]"));
		 product.click();
		 
		 WebElement addToCart = driver.findElement(By.xpath("//input[@type='button'][@value='Add to cart'][@class='button-1 add-to-cart-button']"));
		 addToCart.click();
		 
		 WebElement succes =  driver.findElement(By.xpath("//div[@id='bar-notification']")) ;
		 if(succes.isEnabled()) {
			 System.out.println("Product added");
		 }else {
			 System.out.println("Product not added");
		 }
		 
		 WebElement shoppingCart = driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']"));
		 shoppingCart.click();
		 
		 WebElement cartQuantity = driver.findElement(By.className("qty-input"));
		 if(!cartQuantity.getText().equals("(0)")) {
			 System.out.println("Product added succesfully");
		 }else {
			 System.out.println("product not added");
		 }
		 
		 Thread.sleep(2000);
		 
		
		 driver.quit();
		 
	}
}
