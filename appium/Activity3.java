package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class Activity3 {
	AndroidDriver<MobileElement> Driver = null;
	
	  @BeforeTest
	  public void beforeTest() throws MalformedURLException {
		  DesiredCapabilities caps = new DesiredCapabilities();
		    //DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    caps.setCapability("deviceName", "Pixel_4_Emulator");
		    caps.setCapability("platformName", "android");
		    caps.setCapability("automationName", "UiAutomator2");
		    caps.setCapability("appPackage", "com.android.calculator2");
		    caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		    caps.setCapability("noReset", true);

		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		    Driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
	  }
	  
	  
  @Test
  public void f1() {
	  Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	Driver.findElementById("digit_5").click();		
    Driver.findElementById("op_add").click();
    Driver.findElementById("digit_9").click();
    Driver.findElementById("eq").click();
    System.out.println("Result1 = " + Driver.findElementById("result").getText());
  }

  @Test
  public void f2() {
	  Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	Driver.findElementById("digit_1").click();
	Driver.findElementById("digit_0").click();	
    Driver.findElementById("op_sub").click();
    Driver.findElementById("digit_5").click();
    Driver.findElementById("eq").click();
    System.out.println("Result2 = " + Driver.findElementById("result").getText());
  }
  
  @Test
  public void f3() {
	  Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
		Driver.findElementById("digit_5").click();
	    Driver.findElementById("op_mul").click();
	    Driver.findElementById("digit_1").click();
	    Driver.findElementById("digit_0").click();
	    Driver.findElementById("digit_0").click();
    Driver.findElementById("eq").click();
    System.out.println("Result3 = " + Driver.findElementById("result").getText());
  }
  
  @Test
  public void f4() {
	  Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	Driver.findElementById("digit_5").click();
	Driver.findElementById("digit_0").click();
    Driver.findElementById("op_div").click();
    Driver.findElementById("digit_2").click(); 
    Driver.findElementById("eq").click();
    System.out.println("Result4 = " + Driver.findElementById("result").getText());
  }

  @AfterTest
  public void afterTest() {
	  Driver.quit();
  }

}