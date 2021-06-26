package activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Activity2 {
	AndroidDriver<MobileElement> Driver = null;
	WebDriverWait wait;
	
	
	  @BeforeTest
	  public void beforeTest() throws MalformedURLException {
		  DesiredCapabilities caps = new DesiredCapabilities();
		    //DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    caps.setCapability("deviceName", "Pixel_4_Emulator");
		    caps.setCapability("platformName", "android");
		    caps.setCapability("automationName", "UiAutomator2");
		    caps.setCapability("appPackage", "com.android.chrome");
		    caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		    caps.setCapability("noReset", true);

		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		    Driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
		    
		    wait = new WebDriverWait(Driver, 10);
	  }
	
  @Test
  public void f() {
	  Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  Driver.get("https://www.training-support.net/");
	  System.out.println(Driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]").getText());
	  
	  MobileElement AboutButton = Driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]");
	  AboutButton.click();
	  
	  String NewTitle = Driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
	  System.out.println("The new title is " + NewTitle);	  
  }
  

  @AfterTest
  public void afterTest() {
	  Driver.quit();
  }

}