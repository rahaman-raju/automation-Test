package baseDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;


public class DriverSetup {

	public static WebDriver driver;

  
		@BeforeSuite
		public static void setDriver() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\360\\Desktop\\chromedriver-win64\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

	}
	

  
	@AfterMethod
	public void afterMethod1(ITestResult result1) {
	    if (result1.getStatus() == ITestResult.SUCCESS) {
	        captureScreenshot1();
	    }
	}

	@Attachment(value = "Success Screenshot", type = "image/png")
    public byte[] captureScreenshot1() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
	

	
	@AfterMethod
	public void afterMethod(ITestResult result) {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        captureScreenshot();
	    }
	}

	@Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
	
	


	@AfterSuite
	public void tearDown() {
		//driver.close();

		driver.quit();
	}
	
	
       

	
}



