package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_3_LoggingintoSite {
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
 
    @Test
    public void GetPageTitle() throws InterruptedException {
        // Find and select the username and password fields
    	
       WebElement id = driver.findElement(By.id("txtUsername"));
       id.sendKeys("orange");
       
       WebElement password = driver.findElement(By.id("txtPassword"));
       password.sendKeys("orangepassword123");
            
        //Click on Login
        WebElement Login = driver.findElement(By.id("btnLogin"));
        Login.click();
        Thread.sleep(3);    
           
        String title = driver.getTitle();
        
        //Print the title of the page
        System.out.println("Page title is: " + title);
            
            //Verify that the homepage has opened.
        Assert.assertEquals("OrangeHRM", title);            
        
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
