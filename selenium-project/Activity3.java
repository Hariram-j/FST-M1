package HRMPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver;
	@BeforeMethod
	public void beforemethod()
	{
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
		
	@Test
	public void loginTest() throws InterruptedException 
	{
		String title=driver.getTitle();
		System.out.println("The page title is " + title);
		
		WebElement uname=driver.findElement(By.id("txtUsername"));
		WebElement pwd=driver.findElement(By.id("txtPassword"));
		WebElement login=driver.findElement(By.id("btnLogin"));
		
		uname.sendKeys("orange");
		pwd.sendKeys("orangepassword123");
		login.click();
		Thread.sleep(3000);
		
		String homePageTitle=driver.getTitle();
		System.out.println("The page title is " + homePageTitle);
		
		String actUrl=driver.getCurrentUrl();
		String expUrl="http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard";
		Assert.assertEquals(expUrl,actUrl);
						
	}
  
	@AfterMethod
	public void aftermethod()
	{
		driver.close();
	 
	}
	}
