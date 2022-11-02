package testngbasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FramedExample {
	WebDriver driver;
	
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
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame(0);
		WebElement text= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
		System.out.println(text.getText());
	}

}
