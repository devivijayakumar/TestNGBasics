package testngbasic;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
	{
	@DataProvider (name= "Products" )
	public Object[][] amazon_products()
	{
		return new Object [][] {{"laptop"},{"smart watch"},{"apple iphone 14"},{"sneakers"}};
	}
	@DataProvider (name= "2D" )
	public Object[][] amazon_product()
	{
		return new Object [][] {{"laptop","AIRPODS"},{"smart watch","FRIDGE"},{"apple iphone 14","BAGS"},{"sneakers","DRESS"}};
	}
	@DataProvider (name= "login" )
	public Object[][] facebook()
	{
		return new Object [][] {{"devivijayakumar1996@gmail.com","123456789"},{"durgavijayakumar123","durga890"},{"mithun26@gmail.com","987456123"}};
	}
	@DataProvider(name= "details")
	public Object[][] obsqura() 
	{
		return new Object [][] {{"Devi","Vijayakumar","devikumar1996","trivandrum","kerala","695009"},{"durga","vijayakumar","durga123vijayakumar","kollam","kerala","698521"},{"veena","padmakumar","veenakumar345","cochin","kerala","695147"},{"vamika","mithun","vamika2121","trivandrum","kerala","695007"}};
	}
	


}
