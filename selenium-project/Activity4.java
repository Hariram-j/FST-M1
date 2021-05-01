package HRMPkg;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
	
	WebDriver driver;
	String actEmpID;
	@BeforeMethod
	public void beforemethod()
	{
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
		
	@Test
	public void addNewEmpTest() throws InterruptedException 
	{
		
		
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
		WebElement pim=driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
		pim.click();
		Thread.sleep(1000);
		WebElement addEmp=driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
		addEmp.click();
		Thread.sleep(1000);
		WebElement fullName=driver.findElement(By.xpath("//input[@name='firstName']"));
		WebElement mName=driver.findElement(By.xpath("//input[@name='middleName']"));
		WebElement lName=driver.findElement(By.xpath("//input[@name='lastName']"));
		fullName.sendKeys("Pooja");
		mName.sendKeys("R");
		lName.sendKeys("Chandran");
		Thread.sleep(1000);
		WebElement empID=driver.findElement(By.xpath("//input[@id='employeeId']"));
		String expEmpID=empID.getAttribute("value");
		
		System.out.println("created emp iD is " + expEmpID);
	
	
		WebElement createLoginChkbx=driver.findElement(By.xpath("//input[@id='chkLogin']"));
		createLoginChkbx.click();
		Thread.sleep(1000);
		
		WebElement userName=driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement pwd=driver.findElement(By.xpath("//input[@id='user_password']"));
		WebElement cnfrmPwd=driver.findElement(By.xpath("//input[@id='re_password']"));
		WebElement saveBtn=driver.findElement(By.xpath("//input[@id='btnSave']"));
		
		Random rand=new Random();
		int randomNum = rand.nextInt(1000);
		
		String email="poojachandran"+randomNum;
				
		userName.sendKeys(email);
		pwd.sendKeys("poojachandran123");
		cnfrmPwd.sendKeys("poojachandran123");
		saveBtn.click();
		Thread.sleep(3000);
		
		WebElement empList=driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']"));
		empList.click();
		Thread.sleep(3000);
		
		WebElement srchEmpName=driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']"));
		WebElement srchempID=driver.findElement(By.xpath("//input[@id='empsearch_id']"));
		WebElement srchBtn=driver.findElement(By.xpath("//input[@id='searchBtn']"));
		
			
		srchEmpName.sendKeys("Pooja");
		srchempID.sendKeys(expEmpID);
		Thread.sleep(5000);
		srchBtn.click();
		Thread.sleep(3000);
		
//		WebElement fnameresult=driver.findElement(By.xpath("//tr/td[3]/a[contains(text(),'Pooja')]"));
		WebElement fnameresult=driver.findElement(By.xpath("//tr/td[3]/a"));
		String actName=fnameresult.getText();
		System.out.println("Actual name is " + actName);
		Assert.assertEquals("Pooja R",actName);
		WebElement idResult=driver.findElement(By.xpath("//tr/td[2]/a"));
		String actEmpID=idResult.getText();
		System.out.println("Actual Emp Id is " + actEmpID);
		Assert.assertEquals(expEmpID,actEmpID);

						
	}
  
	@AfterMethod
	public void aftermethod()
	{
		driver.close();
	 
	}
	}
