package HRMPkg;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver;
	String actEmpID;
	@BeforeMethod
	public void beforemethod()
	{
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
		
	@Test
	public void editUserInfoTest() throws InterruptedException 
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
		
		//
		WebElement myInfo=driver.findElement(By.xpath("//li/a[@id='menu_pim_viewMyDetails']"));
		myInfo.click();
		Thread.sleep(1000);
		
		WebElement editBtn=driver.findElement(By.xpath("//input[@id='btnSave']"));
		editBtn.click();
		Thread.sleep(1000);
		
		WebElement fname=driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
		fname.clear();
		fname.sendKeys("Thara");
		WebElement lname=driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
		lname.clear();
		lname.sendKeys("Ram");
		Thread.sleep(1000);
		WebElement gender=driver.findElement(By.xpath("//input[@id='personal_optGender_2']"));
		gender.click();
		Thread.sleep(1000);
		
		WebElement nationality=driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
		Select sel=new Select (nationality);
		sel.selectByVisibleText("Indian");
		Thread.sleep(1000);
		
		WebElement DOB=driver.findElement(By.xpath("//input[@id='personal_DOB']"));
		DOB.clear();
		DOB.sendKeys("1987-03-08");
		Thread.sleep(1000);
		

		WebElement saveBtn=driver.findElement(By.xpath("//input[@id='btnSave']"));
		saveBtn.click();
		Thread.sleep(1000);
			
			
	}
  
	@AfterMethod
	public void aftermethod()
	{
		driver.close();
	 
	}
	}
