package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_6_Directory_Menu_visible {
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
        // get the xpath of user name and password of the login page
    	
       WebElement id = driver.findElement(By.id("txtUsername"));
       id.sendKeys("orange");
       
       WebElement password = driver.findElement(By.id("txtPassword"));
       password.sendKeys("orangepassword123");
            
        //Click on Login
        WebElement Login = driver.findElement(By.id("btnLogin"));
        Login.click();
        Thread.sleep(3);    
           
        //Find the “My Info” menu item and click it
        driver.findElement(By.id("menu_directory_viewDirectory")).click();
        Thread.sleep(5);
        
        
        //Verify that the “Directory” menu item is visible and clickable  		
        		if(driver.findElement(By.linkText("Directory")).isDisplayed()) {
        			System.out.println("Directory menu item is visible");
        		}
        		else {
        			System.out.println("Directory menu item is not visible");
        		}
        //If clickable, click on the menu item
        WebElement element = driver.findElement(By.linkText("Directory"));
        if(element.isDisplayed() && element.isEnabled()) {
        	element.click();
        }
        
        //Verify that heading of the page matches "Search Directory"
        
        String pageHeading = "Search Directory";
        
        Thread.sleep(5);
      
        String actualpageHeading = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/a[1]")).getText();
      
        if(pageHeading == actualpageHeading) {
        	System.out.println("Page Heading matches");
        }
        else {
        	System.out.println("Page Heading not matches");
        }
        
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
