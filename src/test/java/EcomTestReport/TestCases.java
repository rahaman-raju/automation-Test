package EcomTestReport;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import baseDriver.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class TestCases extends DriverSetup {

	String baseUrl = "https://demo.nopcommerce.com/";

	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1, description = "Verify Logo presence on Home Page")
	@Description("Verify Logo presence on Home Page........")
	@Epic("EP002")
	@Feature("Feature1: Logo")
	@Story("Story:Logo Presence")
	@Step("Verify logo Presence")
	public void logoPresence() throws InterruptedException {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		boolean dispStatus = driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
		Assert.assertEquals(dispStatus, true);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2, description = "Register for new user")
	@Description("Signup with Valid Credentials........")
	@Epic("EP002")
	@Feature("Feature2: Signup")
	@Story("Story:Valid Signup")
	@Step("Go to Register")
	public void SignUp() throws InterruptedException {

		driver.findElement(By.linkText("Register")).click();

		// Find the element with the desired text
		String searchText = "Your Personal Details";
		WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + searchText + "')]"));
		// Use JavaScript to scroll to the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Abdur Rahaman");
		driver.findElement(By.id("LastName")).sendKeys("Raju");
		WebElement dropdownElement = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		// Create a Select object
		Select dropdown = new Select(dropdownElement);

		// Select by value attribute
		dropdown.selectByValue("10");

		WebElement dropdownElement1 = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
		// Create a Select object
		Select dropdown1 = new Select(dropdownElement1);

		// Select by value attribute
		dropdown1.selectByVisibleText("May");
		
		WebElement dropdownElement2 = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
		// Create a Select object
		Select dropdown2 = new Select(dropdownElement2);

		// Select by value attribute
		dropdown2.selectByValue("2000");

		driver.findElement(By.id("Email")).sendKeys("email@gmial.com");

		driver.findElement(By.id("Company")).sendKeys("Demo Company");
		
		
		

		// Find the element with the desired text
		String searchPass = "Your Password";
		WebElement element1 = driver.findElement(By.xpath("//*[contains(text(), '" + searchPass + "')]"));
		// Use JavaScript to scroll to the element
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", element1);

		driver.findElement(By.id("Password")).sendKeys("DemoCompany2");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("DemoCompany2");
		
		//Registration complete...
		driver.findElement(By.id("register-button")).click();

		Thread.sleep(3000);

	}
	/*
	 * // Function to scroll down to the bottom of the page private static void
	 * scrollDownToBottom(WebDriver driver) { JavascriptExecutor jsExecutor =
	 * (JavascriptExecutor) driver;
	 * jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)"); }
	 */

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, description = "Verify user Login")
	@Description("Verify user Login........")
	@Epic("EP003")
	@Feature("Feature3: Login")
	@Story("Story:User Login")

	public void Userlogin ()throws InterruptedException  {
		
		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("Email")).sendKeys("email@gmial.com");
		driver.findElement(By.id("Password")).sendKeys("DemoCompany2");
		
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		Thread.sleep(3000);
		
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4, description = "Browse for product")
	@Epic("EP004")
	@Feature("Feature3: Product Browsing")
	@Story("Story:Product Browsing...")

	public void BrwoseProduct ()throws InterruptedException  {
		
		driver.findElement(By.linkText("Computers")).click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.linkText("Electronics")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Apparel")).click();
		Thread.sleep(1000);
		
		//driver.findElement(By.xpath("//ul[@class='top-menu mobile']//a[normalize-space()='Digital downloads']")).click();
		//Thread.sleep(3000);
		
		driver.findElement(By.linkText("Books")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Jewelry")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Gift Cards")).click();
		Thread.sleep(1000);
		
		
		
	}
	
	
	@Severity(SeverityLevel.BLOCKER)	
	@Test(priority=5, description="Add to cart")
	@Description("Purchase a product........")
	@Epic("EP005")
	@Feature("Feature2: Purchase a product")
	@Story("Story:Purchase a product")
	@Step("Go to electronics> Add a computer to cart")
	public void AddToCart() throws InterruptedException{
		driver.findElement(By.linkText("Computers")).click();
		driver.findElement(By.xpath("//img[@title='Show products in category Desktops']")).click();
		Thread.sleep(2000);
		
		String searchText = "Build your own computer";

        // Find the element with the desired text
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + searchText + "')]"));

        // Use JavaScript to scroll to the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
       

	
		driver.findElement(By.linkText("Build your own computer")).click();
		 WebElement dropdownElement = driver.findElement(By.id("product_attribute_2"));

	        // Create a Select object from the dropdown element
	        Select dropdown = new Select(dropdownElement);

	        // Select an option by visible text
	        dropdown.selectByIndex(1);
	        
	        
	   driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();

	   driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
	   Thread.sleep(7000);
	   //driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();
	 
	   driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
	   Thread.sleep(2000);
	   
	   
	 
	   driver.findElement(By.id("termsofservice")).click();
	   driver.findElement(By.id("checkout")).click();
	   Thread.sleep(2000);
	   
	   /*
	  // driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("red@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("red@gmail.com");
		//driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	
	        // Locate the Sign button and click it
	        WebElement signInButton = driver.findElement(By.xpath("xpath(\"//button[contains(text(),'Log in')]"));
	        signInButton.click();

	        // Check if the condition for navigating to the next page is true
	        boolean condition = driver.getCurrentUrl().equals("expected_next_page_url");

	        // Assert the condition
	        Assert.assertTrue(condition, "Sign-in button did not navigate to the expected page");
	        
	        */
	    }
	
	
	@Severity(SeverityLevel.BLOCKER)	
	@Test(priority=6, description="Check the Title")
	@Epic("EP006")
	@Feature("Feature: Title Check")
	public void TitleCheck() throws InterruptedException{
		driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).click();
		
		Assert.assertEquals("NopCommerce", "NoCommerce");
		Thread.sleep(2000);
	

}
	
	@Severity(SeverityLevel.BLOCKER)	
	@Test(priority=7, description="Skip Test")
	@Epic("EP007")
	@Feature("Feature: Skip Test")
	public void SkipTheTest(){
		driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).click();
		
		throw new SkipException("Skip the test");
}

}