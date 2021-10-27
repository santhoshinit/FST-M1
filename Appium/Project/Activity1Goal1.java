package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Activity1Goal1 {
	WebDriverWait wait;
	   AppiumDriver<MobileElement> driver = null;
	   //AndroidDriver driver1 = new AndroidDriver();
	 
	    @BeforeTest
	    public void setup() throws MalformedURLException {
	 
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        
	        caps.setCapability("deviceName", "PixelEmulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity", ".ui.TaskListsActivity");
	        caps.setCapability("noReset", true);
	        
	        
	 
	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 10);
	        
	        
	    }
	 
	    @Test
	    public void AddnewTask1() throws InterruptedException {
	        
	    	
	    	Thread.sleep(5000);
	    	driver.findElementByAccessibilityId("Create new task").click();
	    	
	    	MobileElement AddnewTask1 = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
	        Thread.sleep(8000);
	        AddnewTask1.sendKeys("Complete Activity with Google Tasks");
	        driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
	        Thread.sleep(8000);
	        String getTaskname1 = "resourceId(\"com.google.android.apps.tasks:id/task_name\")";
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(getTaskname1)));
	        String getAddNewTask1 = driver.findElement(MobileBy.AndroidUIAutomator(getTaskname1)).getText();
	        Assert.assertEquals(getAddNewTask1, "Complete Activity with Google Tasks");
	        
	        
	    }
	    
	    @Test
	    public void AddnewTask2() throws InterruptedException{
	    	driver.findElementByAccessibilityId("Create new task").click();
	    		    	
	    		    	MobileElement AddnewTask2 = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
	    		        Thread.sleep(8000);
	    		        AddnewTask2.sendKeys("Complete Activity with Google Keep");
	    		        driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
	    		        Thread.sleep(8000);
	    		        String getTaskname2 = "resourceId(\"com.google.android.apps.tasks:id/task_name\")";
	    		        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(getTaskname2)));
	    		        String getAddNewTask2 = driver.findElement(MobileBy.AndroidUIAutomator(getTaskname2)).getText();
	    		        Assert.assertEquals(getAddNewTask2, "Complete Activity with Google Keep");
	    		    } 
	    
	    
	    @Test
	    public void AddnewTask3() throws InterruptedException {
	    	driver.findElementByAccessibilityId("Create new task").click();
	    	
	    	MobileElement AddnewTask3 = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
	        Thread.sleep(8000);
	        AddnewTask3.sendKeys("Complete the second Activity Google Keep");
	        driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
	        Thread.sleep(8000);
	        String getTaskname3 = "resourceId(\"com.google.android.apps.tasks:id/task_name\")";
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(getTaskname3)));
	        String getAddNewTask3 = driver.findElement(MobileBy.AndroidUIAutomator(getTaskname3)).getText();
	        Assert.assertEquals(getAddNewTask3, "Complete the second Activity Google Keep");
	    }
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
}
