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

public class Activity3Goal3 {
	
	WebDriverWait wait;
	   AppiumDriver<MobileElement> driver = null;
	   //AndroidDriver driver1 = new AndroidDriver();
	 
	    @BeforeTest
	    public void setup() throws MalformedURLException {
	 
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        
	        caps.setCapability("deviceName", "PixelEmulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.keep");
	        caps.setCapability("appActivity", ".activities.BrowseActivity");
	        caps.setCapability("noReset", true);
	        
	        
	 
	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 10);
	        
	        
	    }
	 
	    @Test
	    public void AddNote() throws InterruptedException {
	        
	    	
	    	Thread.sleep(5000);
			driver.findElementByAccessibilityId("New text note").click();
			
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			MobileElement enterNotevalue = driver.findElementByXPath("//android.widget.EditText[@text='Title']");
	        Thread.sleep(5000);
	        enterNotevalue.sendKeys("Entering some text");
	        MobileElement desc = driver.findElementByXPath("//android.widget.EditText[@text='Note']");
	        Thread.sleep(5000);
	        desc.sendKeys("Entering some text");
	        Thread.sleep(5000);
			
						
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId("Reminder").click();
			
			driver.findElementByXPath("//android.widget.TextView[@text='Pick a date & time']").click();
			driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
			
			
			
			Thread.sleep(5000);
			String rmdr = "resourceId(\"com.google.android.keep:id/browse_reminder_chip\")";
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(rmdr)));
	        MobileElement addrmdr = driver.findElement(MobileBy.AndroidUIAutomator(rmdr));
	        Assert.assertTrue(addrmdr.isDisplayed());
	        
	        
	        Thread.sleep(5000);
			driver.findElementByAccessibilityId("Open navigation drawer").click();
			
			
			Thread.sleep(5000);
			String locateNote = "resourceId(\"com.google.android.keep:id/index_note_title\")";
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(locateNote)));
	        String EnteredNote = driver.findElement(MobileBy.AndroidUIAutomator(locateNote)).getText();
	        Assert.assertEquals(EnteredNote, "Welcome to training");
	    	
	        
	        
	    }
	    
	   
	    
	    
	  
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }

}
