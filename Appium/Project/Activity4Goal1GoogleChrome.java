package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4Goal1GoogleChrome {
	
	WebDriverWait wait;
	   AppiumDriver<MobileElement> driver = null;
	   //AndroidDriver driver1 = new AndroidDriver();
	 
	    @BeforeTest
	    public void setup() throws MalformedURLException {
	 
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        
	        caps.setCapability("deviceName", "PixelEmulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.android.chrome");
			caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
			caps.setCapability("noReset", true);
	        
	        
	 
	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 10);
	        
	        driver.get("https://www.training-support.net/selenium");
	    }
	 
	    @Test
	    public void AddNote() throws InterruptedException {
	        
	    	
	    	Thread.sleep(5000);
	    	
			
	    	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5)"));
			
			
			driver.findElementByXPath("//android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[15]/android.view.View").click();
			
			//adding new task
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")"))).sendKeys("Adding new task");
			
			//Add task 
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Add Task\")"))).click();
			//clear the list 
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Clear List\")"))).click();
	    	
	        
	        
	    }
	    
	   
	    
	    
	  
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }

}
