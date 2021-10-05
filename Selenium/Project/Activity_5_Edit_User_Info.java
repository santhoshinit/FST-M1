package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_5_Edit_User_Info {
	
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
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(5);
        
        
        //On the new page, click the Edit button
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(2);
        
        //Fill in the Name, Gender, Nationality, and the DOB fields
        
        WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
        firstName.sendKeys("San");
        WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
        lastName.sendKeys("Kumar");
        
        WebElement radioMale = driver.findElement(By.id("personal_optGender_1"));
        WebElement radioFeMale = driver.findElement(By.id("personal_optGender_2"));
        
        radioMale.click();
        radioFeMale.click();
        
        Select Nationality = new Select(driver.findElement(By.name("personal[cmbNation]")));
        Nationality.selectByVisibleText("Greek");
        Thread.sleep(3);
        
        //click save
        driver.findElement(By.id("btnSave")).click();
        
        
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
