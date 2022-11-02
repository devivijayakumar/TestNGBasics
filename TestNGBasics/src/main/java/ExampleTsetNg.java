import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleTsetNg {
	@BeforeMethod
	public void before_Method()
	{
		System.out.println("inside before method");
	}
	@Test
	public void testcas2()
	{
		System.out.println("inside testcase2");
	}
}
