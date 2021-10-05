package OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_1_Verify_Website_Title {
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
 
    // Read the title of the website and verify the text
    @Test
    public void GetPageTitle() {
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Page title is: " + title);
            
            //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);
                    
        
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
