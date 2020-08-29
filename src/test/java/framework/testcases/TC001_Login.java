package framework.testcases;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.browserStartAndQuit.BrowserStartAndQuit;
import framework.pages.HomePage;




public class TC001_Login extends BrowserStartAndQuit{
	private static Logger log=LogManager.getLogger(TC001_Login.class.getName());
  

	
	@Parameters({"email","password"})
	@Test(priority=0)
	public void user_login(String email,String password) throws IOException, InterruptedException 
	{
		
		HomePage home=new HomePage(driver);	
		home.hover_to_signin();
		home.login(email, password);
		
	}

}
