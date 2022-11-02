package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testngbasic.DataProviderClass;

public class DataProviderAssignment 
{
	
	WebDriver driver;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(dataProvider = "details", dataProviderClass = DataProviderClass.class)
	public void testcase(String fname,String lname,String user,String cname,String sname,String zip)
	{
		
		WebElement firstname= driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		firstname.sendKeys(fname);
		WebElement lastname= driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		lastname.sendKeys(lname);
		WebElement username= driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		username.sendKeys(user);
		WebElement city= driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		city.sendKeys(cname);
		WebElement state= driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		state.sendKeys(sname);
		WebElement zipcode= driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		zipcode.sendKeys(zip);

	}

}
