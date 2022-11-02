package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestcaseAssignment2 {
	WebDriver driver;
	@BeforeMethod
	public void intilise_browser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void verify_table()
	{
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
		WebElement table= driver.findElement(By.xpath("//div[@class='card-body']"));
		Assert.assertTrue(table.isDisplayed());
	}
}
		
	