package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftassertAssignment3 {
	WebDriver driver;
	SoftAssert softassert;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		softassert= new SoftAssert();
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void verify_alerttext_and_button()
	{
		WebElement clickme= driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickme.click();
		String expectedclicktext="I am a Javascript alert box!";
		String actualclicktext= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		softassert.assertEquals(actualclicktext, expectedclicktext);
		
		WebElement clickme1= driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		clickme1.click();
		String expectedclicktext1= "Press a button!";
		String actualclicktext1= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		softassert.assertEquals(actualclicktext1, expectedclicktext1);
		
		WebElement clickforprompt= driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		clickforprompt.click();
		String expectedprompttext= "Please enter your name";
		String actualprompttext= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		softassert.assertEquals(actualprompttext, expectedprompttext);
		
		WebElement clickmet= driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		String expectedclickmet1="Click me!";
		String actualclickmet1=clickmet.getText();
		softassert.assertEquals(actualclickmet1, expectedclickmet1);
		
		WebElement clickme2t= driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		String expectedclickmet2="Click me!";
		String actualclickmet2=clickme2t.getText();
		softassert.assertEquals(actualclickmet2, expectedclickmet2);
		
		WebElement clickforprompt2= driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		String expectedclickmet3="Click for Prompt Box";
		String actualclickmet3=clickforprompt2.getText();
		softassert.assertEquals(actualclickmet3, expectedclickmet3);
		
	}
}