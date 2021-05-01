package HRMPkg;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;
	String actEmpID;
	@BeforeMethod
	public void beforemethod()
	{
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
		
	@Test
	public void addEmpQualTest() throws InterruptedException 
	{
		//start..
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
		WebElement myInfo=driver.findElement(By.xpath("//li/a[@id='menu_pim_viewMyDetails']"));
		myInfo.click();
		Thread.sleep(1000);
		
		WebElement qualMenu=driver.findElement(By.xpath("//ul[@id='sidenav']/li/a[text()='Qualifications']"));
		qualMenu.click();
		Thread.sleep(1000);
		
		WebElement addBtn=driver.findElement(By.xpath("//input[@id='addWorkExperience']"));
		addBtn.click();
		Thread.sleep(1000);
		
		WebElement comp=driver.findElement(By.id("experience_employer"));
		WebElement jTitle=driver.findElement(By.id("experience_jobtitle"));
		WebElement from=driver.findElement(By.id("experience_from_date"));
		WebElement to=driver.findElement(By.id("experience_to_date"));
		WebElement cmnt=driver.findElement(By.id("experience_comments"));
		WebElement saveButton=driver.findElement(By.id("btnWorkExpSave"));
		
		comp.sendKeys("IBM India");
		jTitle.sendKeys("Quality Analyst");
		from.clear();
		from.sendKeys("2009-12-01");
		to.clear();
		to.sendKeys("2021-04-08");
		cmnt.sendKeys("Work experience added ");
		saveButton.click();
		
			
	}
		
		
			
			

  
	@AfterMethod
	public void aftermethod()
	{
		driver.close();
	 
	}
	}