package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_8_Applying_Leave {
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
           
        //Navigate to the Dashboard page and click on the Apply Leave option
        WebElement applyLeave = driver.findElement(By.cssSelector("div.box:nth-child(3) div.inner div.outerbox.no-border:nth-child(1) div.maincontent.group-wrapper div.panel_wrapper div.panel_draggable.panel-preview fieldset.panel_resizable.panel-preview table.quickLaungeContainer tr:nth-child(1) td:nth-child(4) div.quickLaunge a:nth-child(1) > span.quickLinkText:nth-child(2)"));
        applyLeave.click();
        Thread.sleep(3);
        
        
        //Select leave type and duration of the leave.
        Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByVisibleText("privilege leaves");
        Thread.sleep(3);
        
        WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
        fromDate.sendKeys("2021-10-01");
        
        WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
        toDate.sendKeys("2021-10-31");
        
        driver.findElement(By.id("applyBtn")).click();
        
        Thread.sleep(3);
        
        //Navigate to My Leave page to check the status of the leave application
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        Thread.sleep(3);
        
        
        
        // get count of all status values in Status Column
        int column = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/form[1]/div[3]/table[1]/thead[1]/tr[1]/th[6]")).size();
        System.out.println("columnCount is " + column);
        
        // print all status values from Status column
        for(WebElement tableData:driver.findElements(By.className("Status")))
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
