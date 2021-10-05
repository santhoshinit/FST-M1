package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_9_Retrieve_Emergency_Contacts {
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
        Thread.sleep(10);    
           
        //Find the “My Info” menu item and click it
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(15);
        
        
        //d. Click on the “Emergency Contacts” menu item.
        WebElement lnkemergencycontacts = driver.findElement(By.linkText("Emergency Contacts"));
        lnkemergencycontacts.click();
        Thread.sleep(15);
        
        int row = driver.findElements(By.tagName("tr")).size();
        int column = driver.findElements(By.xpath("//table/thead//th")).size();
        
        System.out.println("rowCount is " + row);
        System.out.println("columnCount is " + column);
        
        
        for(WebElement tableData:driver.findElements(By.id("emgcontact_list")))
        {
        	System.out.println(tableData.getText());
        }
        
        
        
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
