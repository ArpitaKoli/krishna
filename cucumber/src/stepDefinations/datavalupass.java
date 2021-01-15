package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class datavalupass 
{
	public static WebDriver driver;
	SoftAssert as=new SoftAssert();
	@Given("^pass the username and password through feature file$")
	public void pass_the_username_and_password_through_feature_file() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/"); 
	}

	@When("^pass the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void pass_the_and(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		   driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
	}

	@When("^click on login$")
	public void click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//button[@name='login']")).click();
	}

	@Then("^logged into$")
	public void logged_into() {
	    // Write code here that turns the phrase above into concrete actions
		  try
		    {
		    boolean ele=driver.findElement(By.xpath("(//span[contains(.,'Arpita')])[2]")).isDisplayed();
		    as.assertTrue(ele);
		    //as.assertTrue(driver.getTitle().contains("Facebook"));
		    System.out.println("successfully logged in");  
		    driver.quit();
		    }
		    catch (Exception e) 
		    {
				e.printStackTrace();
				System.out.println("Test is failed");
				driver.quit();
			}
	}
	

}
