package testngbasic;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestNgDemo {
	
	@BeforeSuite
	public void before_suit()
	{
		System.out.println("inside before siut");
	}
	@BeforeTest
	public void  before_test()
	{
		System.out.println("inside before test");
	}
	@BeforeClass
	public void test1()
	{
		System.out.println("inside befor class");
	}
	
	@BeforeMethod
	public void before_Method()
	{
		System.out.println("inside before method");
	}
	@BeforeMethod
	public void before_method1()
	{
		System.out.println("inside before method1");
	}
	
	@Test
	public void testcase1()
	{
		System.out.println("inside testcase1");
	}
	@Test
	public void testcas2()
	{
		System.out.println("inside testcase2");
	}
	@Test
	public void testcase3()
	{
		System.out.println("inside testcase3");
	}
	@AfterMethod
	public void after_method()
	{
		System.out.println("inside after method");
	}
	@AfterClass
	public void after_class()
	{
		System.out.println("inside after class");
	}
	@AfterTest
	public void after_test()
	{
		System.out.println("inside after test");
	}
	@AfterSuite
	public void after_suit()
	{
		System.out.println("inside after suit");
	}
	
}
