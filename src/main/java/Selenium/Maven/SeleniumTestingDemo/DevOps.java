package Selenium.Maven.SeleniumTestingDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevOps {
	 public static void main(String[] args) {
	        // Set the path to the WebDriver
	        System.setProperty("webdriver.chrome.driver",
	        "C:\\Users\\I528623\\Downloads\\selenium\\chromedriver-win64\\chromedriver.exe");

	        // Initialize the WebDriver
	        WebDriver driver = new ChromeDriver();

	        // Initialize the WebDriverWait
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        

	        // Navigate to the local host
	        driver.get("http://3.231.129.5:8501/");

	     // Test Case 
	        try {
	            // Locate and click the dropdown
	            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='st-ak st-al st-as st-ck st-bf st-cl st-bk']")));
	            dropdown.click();
	            Thread.sleep(2000);

	            // Select login option
	            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Login')]")));
	            login.click();
	            Thread.sleep(2000);

	            // Enter login name
	            WebElement loginname = driver.findElement(By.xpath("//input[@aria-label='User Name']"));
	            loginname.sendKeys("aviral");
	            Thread.sleep(2000);
	            
	            //Enter login password
	            WebElement loginpassword = driver.findElement(By.xpath("//input[@aria-label='Password']"));
	            loginpassword.sendKeys("Lokal");
	            Thread.sleep(2000);
	            
	            //Click login button 
	            WebElement loginbutton = driver.findElement(By.xpath("//label[@data-baseweb='checkbox']//span"));
	            loginbutton.click();
	            Thread.sleep(5000);
	            
	            
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	       	 
	 	       //It will help you to get the height of the page and helps to scroll to the bottom of the page
	 	       js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

	            //Click on Recommend 
	            WebElement recomendbutton = driver.findElement(By.xpath("//button[@kind='secondary']"));
	            recomendbutton.click();
	            Thread.sleep(10000);
	            
	            
	        }
	        catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	     // Close the driver
	        driver.quit();
	 }

}
