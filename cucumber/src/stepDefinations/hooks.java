package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class hooks 
{
	@Before
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/"); 
	}
	public static WebDriver driver;
	SoftAssert as=new SoftAssert();
	@Given("^pass username and password$")
	public void pass_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("arpita.koli7@gmail.com");
		   driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Radhe786@");
	    	}

	@And("^click login btn$")
	public void click_login_btn() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}

	@Then("^sucessfully logged in$")
	public void sucessfully_logged_in() {
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
		}
	}

	@After
	public void teardown()
	{
		driver.quit();
	}
}
