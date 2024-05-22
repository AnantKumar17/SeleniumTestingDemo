package Selenium.Maven.SeleniumTestingDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App {
    public static void main(String[] args) {
        // Set the path to the WebDriver
        System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\I528623\\Downloads\\selenium\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Initialize the WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        

        // Navigate to the Agoda website
        driver.get("https://www.agoda.com/en-in/");

     // Test Case 1: Valid future date with 1 adult
        try {
            // Locate and click the Flights tab
            WebElement flightsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='tab-flight-tab']")));
            flightsTab.click();
            Thread.sleep(8000);
            
            // Close the pop up window
            WebElement popupmessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close Message']")));
            popupmessage.click();
            Thread.sleep(2000);

            // Wait for the departure date field to be visible and enter a valid future date
            WebElement departureDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='DateSelector FlightDateSelector']")));
            departureDateField.click();
            Thread.sleep(2000);
            
            // Select a future date from the date picker
            WebElement futureDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sun May 26 2024']")));
            futureDate.click();
            Thread.sleep(2000);

            // Enter 1 in the number of passengers field (by default it is set to 1 for adults)
            WebElement numPassengersField = driver.findElement(By.xpath("//div[@id='flight-occupancy']"));
            numPassengersField.click();
            Thread.sleep(2000);
            
            WebElement departureDateValue = driver.findElement(By.xpath("//div[contains(text(),'Sun, 26 May 2024')]"));
            WebElement passengerCountValue = driver.findElement(By.xpath("//div[contains(text(),'1 Passenger')]"));

            // Display result
            if (departureDateValue.isDisplayed() && passengerCountValue.isDisplayed()) {
                System.out.println("TC001 Pass: Valid future date Sun May 26 2024 with 1 adult as passenger");
            } else {
                throw new Exception("Departure date or passenger count not displayed correctly");
            }
        }
        catch (Exception e) {
            System.out.println("TC001 Fail: " + e.getMessage());
        }
        // Test Case 2: Valid future date with 2 adults
        try {
            // Wait for the departure date field to be visible and enter a valid future date
            WebElement departureDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='DateSelector FlightDateSelector']")));
            departureDateField.click();
            Thread.sleep(2000);
            
            // Select a future date from the date picker
            WebElement futureDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Mon May 27 2024']")));
            futureDate.click();
            Thread.sleep(2000);

            // Enter 2 in the number of passengers field (2 adults)
            WebElement numPassengersField = driver.findElement(By.xpath("//div[@id='flight-occupancy']"));
            Thread.sleep(2000);
            
            WebElement plusButton = driver.findElement(By.xpath("//button[@aria-label='Plus Adults (12yrs and above)']"));
            plusButton.click();
            Thread.sleep(2000);
            numPassengersField.click();

            WebElement departureDateValue = driver.findElement(By.xpath("//div[contains(text(),'Mon, 27 May 2024')]"));
            WebElement passengerCountValue = driver.findElement(By.xpath("//div[contains(text(),'2 Passengers')]"));

            // Display result
            if (departureDateValue.isDisplayed() && passengerCountValue.isDisplayed()) {
                System.out.println("TC002 Pass: Valid future date Mon May 27 2024 with 2 adults as passengers");
            } else {
                throw new Exception("Departure date or passenger count not displayed correctly");
            }
        }
        catch (Exception e) {
            System.out.println("TC002 Fail: " + e.getMessage());
        }
        // Test Case 3: Valid future date with 1 adult and 2 children
        try {
            // Wait for the departure date field to be visible and enter a valid future date
            WebElement departureDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='DateSelector FlightDateSelector']")));
            departureDateField.click();
            Thread.sleep(2000);
            
            // Select a future date from the date picker (Update selectors as necessary)
            WebElement futureDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Tue May 28 2024']")));
            futureDate.click();
            Thread.sleep(2000);

            // Enter 3 in the number of passengers field (1 adult + 2 children)
            WebElement numPassengersField = driver.findElement(By.xpath("//div[@id='flight-occupancy']"));
            Thread.sleep(2000);
            
            WebElement minusButton = driver.findElement(By.xpath("//button[@aria-label='Minus Adults (12yrs and above)']"));
            minusButton.click();
            Thread.sleep(2000);
            
            WebElement plusButton2 = driver.findElement(By.xpath("//button[@aria-label='Plus Children (2-11yrs)']"));
            plusButton2.click();
            Thread.sleep(2000);
            plusButton2.click();
            Thread.sleep(2000);
            
            numPassengersField.click();

            WebElement departureDateValue = driver.findElement(By.xpath("//div[contains(text(),'Tue, 28 May 2024')]"));
            WebElement passengerCountValue = driver.findElement(By.xpath("//div[contains(text(),'3 Passengers')]"));

            // Display result
            if (departureDateValue.isDisplayed() && passengerCountValue.isDisplayed()) {
                System.out.println("TC003 Pass: Valid future date Tue May 28 2024 with 1 adult and 2 children as passengers");
            } else {
                throw new Exception("Departure date or passenger count not displayed correctly");
            }
        }
        catch (Exception e) {
            System.out.println("TC003 Fail: " + e.getMessage());
        }
        // Test Case 4: Valid future date with 2 adults and 1 infant
        try {
            // Wait for the departure date field to be visible and enter a valid future date
            WebElement departureDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='DateSelector FlightDateSelector']")));
            departureDateField.click();
            Thread.sleep(2000);
            
            // Select a future date from the date picker (Update selectors as necessary)
            WebElement futureDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Wed May 29 2024']")));
            futureDate.click();
            Thread.sleep(2000);

            // Enter 3 in the number of passengers field (2 adults + 1 infant)
            WebElement numPassengersField = driver.findElement(By.xpath("//div[@id='flight-occupancy']"));
            Thread.sleep(2000);
            
            WebElement plusButton = driver.findElement(By.xpath("//button[@aria-label='Plus Adults (12yrs and above)']"));
            plusButton.click();
            Thread.sleep(2000);
            
            WebElement minusButton2 = driver.findElement(By.xpath("//button[@aria-label='Minus Children (2-11yrs)']"));
            minusButton2.click();
            Thread.sleep(2000);
            minusButton2.click();
            Thread.sleep(2000);
            
            WebElement plusButton3 = driver.findElement(By.xpath("//button[@aria-label='Plus Infants (below 2yrs)']"));
            plusButton3.click();
            Thread.sleep(2000);
            
            numPassengersField.click();

            WebElement departureDateValue = driver.findElement(By.xpath("//div[contains(text(),'Wed, 29 May 2024')]"));
            WebElement passengerCountValue = driver.findElement(By.xpath("//div[contains(text(),'3 Passengers')]"));

            // Display result
            if (departureDateValue.isDisplayed() && passengerCountValue.isDisplayed()) {
                System.out.println("TC004 Pass: Valid future date wed May 29 2024 with 2 adults and 1 infant as passengers");
            } else {
                throw new Exception("Departure date or passenger count not displayed correctly");
            }
        }
        catch (Exception e) {
            System.out.println("TC004 Fail: " + e.getMessage());
        }
        // Test Case 5: Past date with 1 adult
        try {
            // Wait for the departure date field to be visible and enter a valid future date
            WebElement departureDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='DateSelector FlightDateSelector']")));
            departureDateField.click();
            Thread.sleep(2000);
            
            // Select a past date from the date picker
            WebElement pastDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Wed May 15 2024']")));
            pastDate.click();
            Thread.sleep(2000);
            
            departureDateField.click();
            
            // Enter 1 in the number of passengers field (1 adult)
            WebElement numPassengersField = driver.findElement(By.xpath("//div[@id='flight-occupancy']"));
            numPassengersField.click();
            Thread.sleep(2000);
            
            WebElement minusButton = driver.findElement(By.xpath("//button[@aria-label='Minus Adults (12yrs and above)']"));
            minusButton.click();
            Thread.sleep(2000);
            
            WebElement minusButton2 = driver.findElement(By.xpath("//button[@aria-label='Minus Children (2-11yrs)']"));
            minusButton2.click();
            Thread.sleep(2000);
            minusButton2.click();
            Thread.sleep(2000);
            
            WebElement minusButton3 = driver.findElement(By.xpath("//button[@aria-label='Minus Infants (below 2yrs)']"));
            minusButton3.click();
            Thread.sleep(2000);
            
            numPassengersField.click();
            
            boolean isDepartureDateValueVisible;
            boolean isPassengerCountValueVisible;
            String msg = "";

            try {
                WebElement departureDateValue = driver.findElement(By.xpath("//div[contains(text(),'Wed, 15 May 2024')]"));
                isDepartureDateValueVisible = departureDateValue.isDisplayed();
            } catch (Exception e) {
                isDepartureDateValueVisible = false;
                msg = e.getMessage();
            }

            try {
                WebElement passengerCountValue = driver.findElement(By.xpath("//div[contains(text(),'1 Passenger')]"));
                isPassengerCountValueVisible = passengerCountValue.isDisplayed();
            } catch (Exception e) {
                isPassengerCountValueVisible = false;
            }
            // Display result
            if(isDepartureDateValueVisible && isPassengerCountValueVisible)
            {
            	System.out.println("TC005 Pass");
            }
            else
            {
            	throw new Exception("Not able to select past date Wed, 15 May 2024" +  "\nReceived error message: " + msg);
            }
        } 
        catch (Exception e) {
            System.out.println("TC005 Fail: " + e.getMessage());
        }
        // Test Case 6: Valid future date with 0 passengers
        try {
            // Wait for the departure date field to be visible and enter a valid future date
            WebElement departureDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='DateSelector FlightDateSelector']")));
            departureDateField.click();
            Thread.sleep(2000);
            
            // Select a past date from the date picker (Update selectors as necessary)
            WebElement pastDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Thu May 30 2024']")));
            pastDate.click();
            Thread.sleep(2000);
            
            // Enter 0 in the number of passengers field
            WebElement numPassengersField = driver.findElement(By.xpath("//div[@id='flight-occupancy']"));
            Thread.sleep(2000);
            
            WebElement minusButton = driver.findElement(By.xpath("//button[@aria-label='Minus Adults (12yrs and above)']"));
            minusButton.click();
            Thread.sleep(2000);
            
            numPassengersField.click();
            
            boolean isDepartureDateValueVisible;
            boolean isPassengerCountValueVisible;
            String msg = "";

            try {
                WebElement departureDateValue = driver.findElement(By.xpath("//div[contains(text(),'Thu May 30 2024')]"));
                isDepartureDateValueVisible = departureDateValue.isDisplayed();
            } catch (Exception e) {
                isDepartureDateValueVisible = false;
            }

            try {
                WebElement passengerCountValue = driver.findElement(By.xpath("//div[contains(text(),'0 Passenger')]"));
                isPassengerCountValueVisible = passengerCountValue.isDisplayed();
            } catch (Exception e) {
                isPassengerCountValueVisible = false;
                msg = e.getMessage();
            }
            // Display result
            if(isDepartureDateValueVisible && isPassengerCountValueVisible)
            {
            	System.out.println("TC006 Pass");
            }
            else
            {
            	throw new Exception("Not able to reduce the number of passengers to 0" +  "\nReceived error message: " + msg);
            }
        } 
        catch (Exception e) {
            System.out.println("TC006 Fail: " + e.getMessage());
        }
        // Test Case 7: Valid future date with 9 passengers
        try {
            // Wait for the departure date field to be visible and enter a valid future date
            WebElement departureDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='DateSelector FlightDateSelector']")));
            departureDateField.click();
            Thread.sleep(2000);
            
            // Select a past date from the date picker (Update selectors as necessary)
            WebElement pastDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Fri May 31 2024']")));
            pastDate.click();
            Thread.sleep(2000);
            
            // Enter 9 in the number of passengers field
            WebElement numPassengersField = driver.findElement(By.xpath("//div[@id='flight-occupancy']"));
            Thread.sleep(2000);
            
            WebElement plusButton = driver.findElement(By.xpath("//button[@aria-label='Plus Adults (12yrs and above)']"));
            for(int i=1;i<=8;i++)
            {
            	plusButton.click();
            }
            Thread.sleep(2000);
            
            numPassengersField.click();
            
            boolean isDepartureDateValueVisible;
            boolean isPassengerCountValueVisible;
            String msg = "";

            try {
                WebElement departureDateValue = driver.findElement(By.xpath("//div[contains(text(),'Fri May 31 2024')]"));
                isDepartureDateValueVisible = departureDateValue.isDisplayed();
            } catch (Exception e) {
                isDepartureDateValueVisible = false;
            }

            try {
                WebElement passengerCountValue = driver.findElement(By.xpath("//div[contains(text(),'9 Passengers')]"));
                isPassengerCountValueVisible = passengerCountValue.isDisplayed();
            } catch (Exception e) {
                isPassengerCountValueVisible = false;
                msg = e.getMessage();
            }
            // Display result
            if(isDepartureDateValueVisible && isPassengerCountValueVisible)
            {
            	System.out.println("TC007 Pass");
            }
            else
            {
            	throw new Exception("Can not set number of passengers more than 8 in Agoda" +  "\nReceived error message: " + msg);
            }
        } 
        catch (Exception e) {
            System.out.println("TC007 Fail: " + e.getMessage());
        }
        // Test Case 8: Invalid date format with 1 passenger
        try {
            // Wait for the departure date field to be visible and enter a valid future date
            WebElement departureDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='DateSelector FlightDateSelector']")));
            departureDateField.click();
            Thread.sleep(2000);
            String msg = "";
            
            try {
                WebElement invalidDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='May 30 Thu 2024']")));
                invalidDate.click();
                Thread.sleep(2000);
            } catch (Exception e) {
            	 msg = e.getMessage();
            	 departureDateField.click();
            }
            // Enter 1 in the number of passengers field
            WebElement numPassengersField = driver.findElement(By.xpath("//div[@id='flight-occupancy']"));
            
            numPassengersField.click();
            
            Thread.sleep(2000);
            
            WebElement minusButton = driver.findElement(By.xpath("//button[@aria-label='Minus Adults (12yrs and above)']"));
            for (int i = 1; i <= 7; i++) {
                minusButton.click();
            }
            Thread.sleep(2000);
            
            numPassengersField.click();
            
            boolean isDepartureDateValueVisible;
            boolean isPassengerCountValueVisible;

            try {
                WebElement departureDateValue = driver.findElement(By.xpath("//div[contains(text(),'Thu May 30 2024')]"));
                isDepartureDateValueVisible = departureDateValue.isDisplayed();
            } catch (Exception e) {
            	isDepartureDateValueVisible = false;
            }

            try {
                WebElement passengerCountValue = driver.findElement(By.xpath("//div[contains(text(),'1 Passenger')]"));
                isPassengerCountValueVisible = passengerCountValue.isDisplayed();
            } catch (Exception e) {
            	isPassengerCountValueVisible = false;
            }
            // Display result
            if(isDepartureDateValueVisible && isPassengerCountValueVisible)
            {
            	System.out.println("TC008 Pass");
            }
            else
            {
            	throw new Exception("TC008 Fail: Invalid date format May 30 Thu 2024" +  "\nReceived error message: " + msg);
            }
        } 
        catch (Exception e) {
            System.out.println("TC008 Fail: " + e.getMessage());
        }
        // Close the driver
        driver.quit();
    }
}