package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class createaccount 
{
	public static WebDriver driver;
	SoftAssert as=new SoftAssert();
	@Given("^create an user$")
	public void create_an_user() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/"); 
	}

	@When("^click on createaccount button$")
	public void click_on_createaccount_button() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("//div[.='Forgotten password?']/../div[5]/a  ")).click();
	}

	@And("^user enter firstname,lastname,mobile number,newpassword etc$")
	public void user_enter_firstname_lastname_mobile_number_newpassword_etc() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("naveen");
	    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("xxx");
	    driver.findElement(By.xpath("//input[contains(@aria-label,'Mobile number or email address')]")).sendKeys("8967456789");
	    driver.findElement(By.xpath("//input[contains(@data-type,'password')]")).sendKeys("Radhe786@");
	}

	@And("^click on signup button$")
	public void click_on_signup_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@type='submit'][contains(@id,'s')][contains(.,'Sign Up')]")).click();
	}

	@Then("^account should be created$")
	public void account_should_be_created() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
