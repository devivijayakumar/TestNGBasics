package testngbasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	WebDriver driver;
	SoftAssert softassert;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void testcase1()
	{
		driver.get("https://selenium.obsqurazone.com/bootstrap-alert.php");
		softassert= new SoftAssert();
		WebElement autoclosable= driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']"));
		String expectedcolour="rgba(40, 167, 69, 1)";
		String actualcolour= autoclosable.getCssValue("background-color");
		softassert.assertEquals(actualcolour, expectedcolour);
		System.out.println("backgroundcolour "+actualcolour);
		
		WebElement normalsucess= driver.findElement(By.xpath("//button[@id=\"normal-btn-success\"]"));
		String expectedtext="Normal success";
		String actualtext= normalsucess.getText();
		softassert.assertEquals(actualtext, expectedtext);
		System.out.println("text is "+actualtext);
		
		softassert.assertAll();
	}
}
