package assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchToAssignment 
{
	WebDriver driver;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void testcase()
	{
		WebElement likefb= driver.findElement(By.xpath("//a[contains(text(),'  Like us On Facebook ')]"));
		likefb.click();
		String parentWindow= driver.getWindowHandle();
		//System.out.println(parentWindow);
		Set<String> windows= driver.getWindowHandles();
		Iterator<String>iterates= windows.iterator();
		while (iterates.hasNext())
		{
			String childWindow=iterates.next();
			if(!parentWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
			}
		}
		WebElement nextwindow= driver.findElement(By.xpath("//span[contains(text(),'See more of Obsqura Zone on Facebook')]"));
		String expectedtext= "See more of Obsqura Zone on Facebook";
		String actualtext= nextwindow.getText();
		Assert.assertEquals(actualtext, expectedtext);
		System.out.println(actualtext);
		
	}

}
