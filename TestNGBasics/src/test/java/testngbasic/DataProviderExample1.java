package testngbasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProviderExample1 {
	WebDriver driver;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(dataProvider = "Products",dataProviderClass = DataProviderClass.class)
	public void testcase(String data)
	{
		driver.get("https://www.amazon.in/");
		WebElement searchfeild= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchfeild.sendKeys(data);
		WebElement searchbutton= driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbutton.click();
	}
	@Test(dataProvider = "2D",dataProviderClass = DataProviderClass.class)
	public void testcase1(String data1, String data2)
	{
		
		driver.get("https://www.amazon.in/");WebElement searchfeild= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchfeild.sendKeys(data1+data2);
		System.out.println(data1+" "+data2);
		WebElement searchbutton= driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbutton.click();
	}
	@Test(dataProvider = "login",dataProviderClass = DataProviderClass.class)
	
	public void testcase2(String user,String passw)
		{
			driver.get("https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjY1MTExMjA5LCJjYWxsc2l0ZV9pZCI6MjY5NTQ4NDUzMDcyMDk1MX0%3D");
			WebElement username= driver.findElement(By.xpath("//input[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt']"));
			username.sendKeys(user);
			WebElement password= driver.findElement(By.xpath("//input[@id='pass']"));
			password.sendKeys(passw);
		}
	@AfterMethod
	public void closing_browser()
	{
		driver.quit();
	}
	
}



