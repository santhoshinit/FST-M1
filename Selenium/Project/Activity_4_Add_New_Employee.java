package OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_4_Add_New_Employee  {
	
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
           
        
        //Find the PIM option in the menu and click it.
        WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
        PIM.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        
        //Click the Add button to add a new Employee.     
        WebElement Add = driver.findElement(By.id("btnAdd"));
        Add.click();
        Thread.sleep(5);
            
        //Enter name details step 
        WebElement firstname = driver.findElement(By.id("firstName"));
        firstname.sendKeys("Santhoshkumar");
        
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Sundaram");
        
        //Fill in the required fields and click Save
        WebElement Save = driver.findElement(By.id("id=\"btnSave\""));
        Save.click();
        Thread.sleep(3);
        
        
        //Check 
        
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        Thread.sleep(3);
        
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Santhoshkumar Sundaram");
        
        
        // Navigate back to the PIM page (Employee List tab) and verify the creation of your  employee.
        PIM.click();
        Thread.sleep(3);
        driver.findElement(By.id("searchBtn")).click();
        String checkFirstName = driver.findElement(By.id("personal_txtEmpFirstName")).getText();
        String checkLastName = driver.findElement(By.id("personal_txtEmpLastName")).getText();
        String concatFullName = checkFirstName + checkLastName;
        String linkTextFirstname = driver.findElement(By.xpath("//a[contains(text(),'Santhoshkumar')]")).getText();
        String linkTextLastname = driver.findElement(By.xpath("//a[contains(text(),'Sundaram')]")).getText();
        String linkTextFullName = linkTextFirstname + linkTextLastname;
        if(concatFullName == linkTextFullName) {
        	System.out.println("Created Employee is found");
        }
        else {
        	System.out.println("Created Employee is not found");
        }
    
    }
 
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
	
}
