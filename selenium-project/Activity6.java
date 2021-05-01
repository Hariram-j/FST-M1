package HRMPkg;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	
	WebDriver driver;
	String actEmpID;
	@BeforeMethod
	public void beforemethod()
	{
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
		
	@Test
	public void directoryMenuTest() throws InterruptedException 
	{
		//start..
		
		//Login
		String title=driver.getTitle();
		System.out.println("The page title is " + title);
		WebElement loginName=driver.findElement(By.id("txtUsername"));
		WebElement loginPwd=driver.findElement(By.id("txtPassword"));
		WebElement login=driver.findElement(By.id("btnLogin"));
		loginName.sendKeys("orange");
		loginPwd.sendKeys("orangepassword123");
		login.click();
		Thread.sleep(3000);
		String homePageTitle=driver.getTitle();
		System.out.println("The page title is " + homePageTitle);
		Thread.sleep(1000);
				
		//
		WebElement directoryMenu=driver.findElement(By.xpath("//li/a[@id='menu_directory_viewDirectory']"));
		boolean displayed=directoryMenu.isDisplayed();
		System.out.println("Is the directory menu displayed ? " + displayed);
		Thread.sleep(1000);
		boolean clickable=directoryMenu.isEnabled();
		if (clickable)
		{
			directoryMenu.click();
			Thread.sleep(3000);
			WebElement pageHeading=driver.findElement(By.xpath("//h1[text()='Search Directory']"));
			
			String pHeadmsg=pageHeading.getText();
			System.out.println("The current page heading is " + pHeadmsg);
			
			Assert.assertEquals("Search Directory",pHeadmsg);
		
			
		}
		
		
	}
		
		
			
			

  
	@AfterMethod
	public void aftermethod()
	{
		driver.close();
	 
	}
	}