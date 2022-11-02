package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftassertAssignment2 {
	WebDriver driver;
	SoftAssert softassert;
	@BeforeMethod
	public void intialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		softassert= new SoftAssert();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	@Test
	public void verify_textfeild()
	{
		WebElement entermessagetf=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		softassert.assertTrue(entermessagetf.isDisplayed());
		WebElement valueatf=driver.findElement(By.xpath("//input[@id='value-a']"));
		softassert.assertTrue(valueatf.isDisplayed());
		WebElement valuebtf=driver.findElement(By.xpath("//input[@id='value-b']"));
		softassert.assertTrue(valuebtf.isDisplayed());
	}
	@Test
	public void verify_text()
	{
		WebElement enetrmessage= driver.findElement(By.xpath("//label[contains(text(),'Enter Message')]"));
		String expectedtext="Enter Message";
		String actualtext=enetrmessage.getText();
		softassert.assertEquals(actualtext, expectedtext);
		WebElement enetrvaluea= driver.findElement(By.xpath("//label[contains(text(),'Enter value A')]"));
		String expectedtexts="Enter value A";
		String actualtexts=enetrvaluea.getText();
		softassert.assertEquals(actualtexts, expectedtexts);
	}
}
