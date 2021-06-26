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

public class Activity1 {
	
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
  public void f() {
	  Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	Driver.findElementById("digit_7").click();		
    Driver.findElementById("op_mul").click();
    Driver.findElementById("digit_4").click();
    Driver.findElementById("eq").click();
  }


  @AfterTest
  public void afterTest() {
	   Driver.quit();
  }

}