package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();		
		driver.get("https://www.training-support.net");		
		System.out.println(driver.getTitle());	
		Thread.sleep(3000);
		WebElement Text  = driver.findElement(By.id("about-link"));
		System.out.println("Text in Element:" + Text.getText() );		
		Thread.sleep(1000);		
		driver.close();
				
		
	}

}
