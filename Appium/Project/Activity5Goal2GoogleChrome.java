package Project;

import java.net.MalformedURLException;
import java.net.URL;

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

public class Activity5Goal2GoogleChrome {

	
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
	    	
	    	Assert.assertEquals(testcredentials("admin","password"), "Welcome Back, admin");
			 
			 Assert.assertEquals(testcredentials("admin1","passwrod1"), "Invalid Credentials");	
	    }
	    
	    public String testcredentials(String uname,String password) {
			
	    	
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(2)"));


			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Login Form\")"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"username\")"))).sendKeys(uname);
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"password\")"))).sendKeys(password);
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("textContains(\"Log in\")"))).click();
			
			String msg = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")"))).getText();
			System.out.println("Message: "+ msg);
			return msg;
			
			
	    }
	    
	   
	    
	    
	  
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
}
