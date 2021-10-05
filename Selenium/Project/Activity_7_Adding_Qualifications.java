package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_7_Adding_Qualifications {
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
           
        //Find the “My Info” menu item and click it.
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(3);
        //On the new page, find the Qualification option on the left side menu and click it.
        
        WebElement qualification = driver.findElement(By.cssSelector("div.box.pimPane:nth-child(1) div:nth-child(1) ul:nth-child(2) li:nth-child(9) > a:nth-child(1)"));
    
        qualification.click();
        
        Thread.sleep(3);
        
        driver.findElement(By.id("addWorkExperience")).click();
        
        Thread.sleep(3);
        //Add Work Experience and click Save.
        
        WebElement company = driver.findElement(By.id("experience_employer"));
        company.sendKeys("IBM");
        
        WebElement jobTitle = driver.findElement(By.id("experience_jobtitle"));
        jobTitle.sendKeys("Tester");
        driver.findElement(By.id("btnWorkExpSave")).click();
        
        Thread.sleep(3);
        
        
        
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
	
}
