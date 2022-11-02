package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertAssignment1 {
	WebDriver driver;
	SoftAssert softassert;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		softassert= new SoftAssert();
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void verify_checkbox_text()
	{
		WebElement checksingle= driver.findElement(By.xpath("//label[contains( text(),'Click on this check box')]"));
		String expectedtext1= "Click on this check box";
		String actualtext1=checksingle.getText(); 
		softassert.assertEquals(actualtext1, expectedtext1);
		WebElement multicheck1= driver.findElement(By.xpath("//label[contains( text(),'Check Box One')]"));
		String expectedtext2= "Check Box One";
		String actualtext2=multicheck1.getText(); 
		softassert.assertEquals(actualtext2, expectedtext2);
		WebElement multicheck2= driver.findElement(By.xpath("//label[contains( text(),'Check Box Two')]"));
		String expectedtext3= "Check Box Two";
		String actualtext3=multicheck2.getText(); 
		softassert.assertEquals(actualtext3, expectedtext3);
		WebElement multicheck3= driver.findElement(By.xpath("//label[contains( text(),'Check Box Three')]"));
		String expectedtext4= "Check Box One";
		String actualtext4=multicheck3.getText(); 
		softassert.assertEquals(actualtext4, expectedtext4);
		WebElement multicheck4= driver.findElement(By.xpath("//label[contains( text(),'Check Box Four')]"));
		String expectedtext5= "Check Box One";
		String actualtext5=multicheck4.getText(); 
		softassert.assertEquals(actualtext5, expectedtext5);
	}
	@Test
	public void verify_checkbox_selected()
	{
		WebElement singlebox1=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		singlebox1.click();
		softassert.assertTrue(singlebox1.isSelected());
		WebElement multibox1=driver.findElement(By.xpath("//input[@id='check-box-one']"));
		multibox1.click();
		softassert.assertTrue(multibox1.isSelected());
		WebElement multibox2=driver.findElement(By.xpath("//input[@id='check-box-two']"));
		multibox2.click();
		softassert.assertTrue(multibox2.isSelected());
		WebElement multibox3=driver.findElement(By.xpath("//input[@id='check-box-three']"));
		multibox3.click();
		softassert.assertTrue(multibox3.isSelected());
		WebElement multibox4=driver.findElement(By.xpath("//input[@id='check-box-four']"));
		multibox4.click();
		softassert.assertTrue(multibox4.isSelected());
	}
	@AfterMethod
	public void closing_browser()
	{
		driver.quit();
	}

}
