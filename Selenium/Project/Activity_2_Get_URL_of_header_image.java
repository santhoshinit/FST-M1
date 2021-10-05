package OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_2_Get_URL_of_header_image {
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    
    @Test
    public void GetPageTitle() {
        // Get the url of the header image.
        String getUrl = driver.getCurrentUrl();
            
        //Print the url to the console.
        System.out.println("Page URL is: " + getUrl);
       
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
