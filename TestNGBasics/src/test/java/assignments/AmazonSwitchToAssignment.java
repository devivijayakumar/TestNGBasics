package assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonSwitchToAssignment {
	WebDriver driver;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	@Test
	public void testcase()
	{
		WebElement searchfeild= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchfeild.sendKeys("mobile");
		WebElement searchbutton= driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbutton.click();
		WebElement mobile= driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		mobile.click();
		
		String parentWindow= driver.getWindowHandle();
		System.out.println(parentWindow);
		Set<String>windows= driver.getWindowHandles();
		System.out.println(windows.size());
		Iterator<String>iterate= windows.iterator();
		while (iterate.hasNext())
		{
			String childWindow= iterate.next();
			if(!parentWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
			}
		}
		
		WebElement price= driver.findElement(By.xpath(" //*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[2]/span[2]/span[2]"));
		System.out.println(price.getText());
		driver.switchTo().window(parentWindow);
		
	}
}
