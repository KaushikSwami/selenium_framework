package framework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import framework.browserStartAndQuit.BrowserStartAndQuit;
import framework.pages.AmazonProductPage;
import framework.pages.HomePage;

public class TC002_Search_Product extends BrowserStartAndQuit{
	

	
	@Test(priority=1)
	public void search_product()
	{
		HomePage home=new HomePage(driver);	
		home.select_product();
		AmazonProductPage product=new AmazonProductPage(driver);
		product.search_product();
	}

}
