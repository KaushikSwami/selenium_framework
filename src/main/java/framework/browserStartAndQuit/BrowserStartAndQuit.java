package framework.browserStartAndQuit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import framework.baseClass.SeleniumBase;
import framework.utils.SheetData;

public class BrowserStartAndQuit extends SeleniumBase {
	
    
	@BeforeTest
	public void startBrowser() throws IOException
	{
		initializeDriver();
	}
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException 
	{
		Thread.sleep(3000);
	    closeDriver(); 
	}
	 
}
