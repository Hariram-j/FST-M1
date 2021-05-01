package HRMPkg;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	
	WebDriver driver;
	String actEmpID;
	@BeforeMethod
	public void beforemethod()
	{
		driver=new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
		
	@Test
	public void retEmergencyContactTest() throws InterruptedException 
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
		
		WebElement emgContacts=driver.findElement(By.xpath("//li/a[text()=\"Emergency Contacts\"]"));
		emgContacts.click();
		Thread.sleep(1000);
		
			
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id=\"emgcontact_list\"]/tbody/tr"));
		int rowsize=rows.size();
		System.out.println("No.of rows " +rowsize);
		
		List<WebElement> cols=driver.findElements(By.xpath("//table[@id=\"emgcontact_list\"]/tbody/tr[1]/td"));
		int colsize=cols.size();
		System.out.println("No.of cols " +colsize);
		
		List<WebElement> header=driver.findElements(By.xpath("//table[@id=\"emgcontact_list\"]/thead/tr/th"));
		
		for (WebElement h : header)
		{
			System.out.print(h.getText() + "\t"  );
		}
		System.out.println(" ");
						
		for (WebElement row : rows) {
		    List<WebElement> cells = row.findElements(By.tagName("td"));
		    for (WebElement cell : cells) {
		        
		    	System.out.print(cell.getText() + "\t" );
		    }
		    System.out.println(" ");
		}
	
//		
		//header details : //table[@id="emgcontact_list"]/thead/tr/th
		//data details : //table[@id="emgcontact_list"]/tbody/tr/td
		
	
		
		
		
		
	}
		
		 
	@AfterMethod
	public void aftermethod()
	{
		driver.close();
	 
	}
	}