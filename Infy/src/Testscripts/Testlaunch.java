package Testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Testlaunch {
	@Test
	public void launch() throws Exception
	{
			System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		}
}
