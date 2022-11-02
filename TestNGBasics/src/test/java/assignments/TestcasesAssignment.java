package assignments;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestcasesAssignment {
	WebDriver driver;
	@BeforeMethod
	public void before_method()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void verify_background_colour()
	{
		driver.get("https://selenium.obsqurazone.com/bootstrap-alert.php");
		WebElement autoclosable= driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']"));
		String expectedcolour="rgba(40, 167, 69, 1)";
		String actualcolour= autoclosable.getCssValue("background-color");
		Assert.assertEquals(actualcolour, expectedcolour);
	System.out.println("background verified and passed");
	}
	@Test
	public void verify_tooltip()
	{
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
		WebElement tooltips= driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		String expectedtooltip= "Follow @obsqurazone on Facebook";
		String actualtooltip= tooltips.getAttribute("title");
		Assert.assertEquals(actualtooltip, expectedtooltip);
	}
	@Test
	public void verify_text()
	{
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
		WebElement followall= driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		String expectedtext= "Follow All";
		String actualtext= followall.getText();
		Assert.assertEquals(actualtext, expectedtext);
		
	}
	@AfterMethod
	public void closing_browser()
	{
		driver.quit();
	}
}
