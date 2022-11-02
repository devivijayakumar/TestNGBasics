package testngbasic;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SwitchToWindowExample {
	WebDriver driver;
	//SoftAssert softassert;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		//softassert= new SoftAssert();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	@Test
	public void testcase1()
	{
		WebElement clickme=driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickme.click();
		clickme.click();
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		Set<String>windows= driver.getWindowHandles();
		System.out.println(windows.size());
		Iterator<String>iterate= windows.iterator();
		while (iterate.hasNext())
		{
			String childWindow= iterate.next();
			if (!parentWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
			}
		}
		WebElement text= driver.findElement(By.xpath("//h3[text()='New Window']"));
		System.out.println(text.getText());
		driver.switchTo().window(parentWindow);
	}
	@Test
	public void testcase2()
	{
		WebElement clickme=driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickme.click();
		clickme.click();
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		Set<String>windows= driver.getWindowHandles();
		System.out.println(windows.size());
		for(String S:windows)
		{
			if(parentWindow.equals(S))
			{
				System.out.println("no need to switch");
				System.out.println(S+" "+parentWindow);
			}
			else
			{
				driver.switchTo().window(S);
			}
		}
		WebElement text= driver.findElement(By.xpath("//h3[text()='New Window']"));
		System.out.println(text.getText());
		driver.switchTo().window(parentWindow);
	}
	@AfterMethod
	public void closing_brwoser()
	{
		driver.close();
	}
}
