package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class multipletestdata 
{
	public static WebDriver driver;
	SoftAssert as=new SoftAssert();
	@Given("^Login with multiple testdata$")
	public void login_with_multiple_testdata() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/"); 
	}

	@When("^valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void valid_and(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		   driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
	}

	@When("^click login button$")
	public void click_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//button[@name='login']")).click();
	}

	@Then("^logged into application$")
	public void logged_into_application() {
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
