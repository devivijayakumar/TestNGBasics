package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestcaseAssignment1 {
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
	public void verify_text()
	{
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement showmessage= driver.findElement(By.xpath("//button[@id='button-one']"));
		showmessage.click();
		String expectedtext= "Show Message";
		String actualtext= showmessage.getText();
		Assert.assertEquals(actualtext, expectedtext);
	}
	@Test
	public void verify_checkbox()
	{
		driver.get(" https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement checkbox= driver.findElement(By.xpath("//input[@id='gridCheck']"));
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());
	}
	@Test
	public void verify_state()
	{
		driver.get("https://selenium.obsqurazone.com/jquery-select.php");
		String State="New York";
		WebElement States= driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']"));
		States.click();
		WebElement StateSearchfeild= driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		StateSearchfeild.sendKeys(State);
		driver.findElement(By.xpath("//ul[@class='select2-results__options']//li[text()='"+State+"']")).click();
	}
	@Test
	public void verify_alert_text()
	{
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clicks=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clicks.click();
		String actualtext= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expectedtext="Click me!";
		Assert.assertEquals(actualtext, expectedtext);
			
	}
	@Test
	public void verify_text_message()
	{
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		WebElement subjectfeild= driver.findElement(By.xpath("//input[@id='subject']"));
		subjectfeild.sendKeys("Selenium");
		WebElement descpritionfeild= driver.findElement(By.xpath("//textarea[@id='description']"));
		descpritionfeild.sendKeys("Selenium is an open-source tool that automates web browsers.");
		WebElement submitbutton= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		submitbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"message-one\"]")));
		WebElement texts=driver.findElement(By.xpath("//div[@id=\"message-one\"]"));
		String expectedmessage= "Form has been submitted successfully!";
		String actualmessage= texts.getText();
		Assert.assertEquals(actualmessage, expectedmessage);
	}

}
