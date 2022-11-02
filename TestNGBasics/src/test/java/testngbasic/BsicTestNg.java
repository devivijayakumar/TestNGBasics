package testngbasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BsicTestNg {
	WebDriver driver;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(enabled = false,priority = 2)
	public void verifyCurrentUrl()
	{
		String expectedurl= ("https://selenium.obsqurazone.com/simple-form-demo.");
		String actualurl= driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl);
	}
	@Test(priority = 1,invocationCount = 3)
	public void verifyTitle()
	{
		String expectedtitle= ("Obsqura Testing") ;
		String actualtitle= driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		
	}
	@Test(priority = -3)
	public void verify_logo()
	{
		WebElement logo= driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/div/a/img"));
		Assert.assertTrue(logo.isDisplayed());
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
