package HRMPkg;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
	
	WebDriver driver;
	String actEmpID;
	@BeforeMethod
	public void beforemethod()
	{
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
		
	@Test
	public void applyLeaveTest() throws InterruptedException 
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
		
		String fdate="2021-08-08";
		String tdate="2021-08-08";
		WebElement dashboard=driver.findElement(By.id("menu_dashboard_index"));
		dashboard.click();
		Thread.sleep(1000);
		
		WebElement leaveMenu=driver.findElement(By.xpath("//span[text()=\"Apply Leave\"]"));
		leaveMenu.click();
		Thread.sleep(1000);
		
		WebElement leaveType=driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']"));
		Select sel=new Select(leaveType);
		sel.selectByVisibleText("Paid Leave");
		Thread.sleep(1000);
		
		WebElement fromDate=driver.findElement(By.id("applyleave_txtFromDate"));
		fromDate.clear();
		fromDate.sendKeys(fdate);
		
		WebElement toDate=driver.findElement(By.id("applyleave_txtToDate"));
		toDate.clear();
		toDate.sendKeys(tdate);
		
		WebElement comment=driver.findElement(By.id("applyleave_txtComment"));
		comment.sendKeys("Planned paid off leave");
		Thread.sleep(1000);
		

		WebElement apply=driver.findElement(By.id("applyBtn"));
		apply.click();
		Thread.sleep(3000);
		
		WebElement myLeavePage=driver.findElement(By.id("menu_leave_viewMyLeaveList"));
		myLeavePage.click();
		Thread.sleep(3000);
		
		WebElement fromDate1=driver.findElement(By.id("calFromDate"));
		fromDate1.clear();
		fromDate1.sendKeys(fdate);
		Thread.sleep(3000);
		

		WebElement toDate1=driver.findElement(By.id("calToDate"));
		toDate1.clear();
		toDate1.sendKeys(tdate);
		Thread.sleep(3000);
		

		WebElement srchBtn=driver.findElement(By.id("btnSearch"));
		srchBtn.click();
		Thread.sleep(3000);
		
		WebElement leaveStatus=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[6]"));
		String status=leaveStatus.getText();
		
		System.out.println("Your leave status is " + status);
		Thread.sleep(3000);
		
			
	}
		
		 
	@AfterMethod
	public void aftermethod()
	{
		driver.close();
	 
	}
	}
