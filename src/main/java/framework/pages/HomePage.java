package framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import framework.baseClass.SeleniumBase;

public class HomePage extends SeleniumBase{
	
	public WebDriver driver;
	public String expected_text="Hello, kaushik";
	public String actual_text;
	private static Logger log=LogManager.getLogger(HomePage.class.getName());

	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="nav-link-accountList") 
	public WebElement sign_in_button;
	@FindBy(how=How.XPATH,using="//div[@id='nav-flyout-ya-signin']//span[text()='Sign in']") 
	public WebElement sign_in;
	@FindBy(how=How.ID, using="ap_email") 
	public WebElement e_mail;
	@FindBy(how=How.ID, using="continue") 
	public WebElement continue_button;
	@FindBy(how=How.ID, using="ap_password") 
	public WebElement pwd;
	@FindBy(how=How.XPATH,using="//input[@id='signInSubmit']") 
	public WebElement submit;
	@FindBy(how=How.CSS,using="select[id='searchDropdownBox']") 
	public WebElement select_product;
	
	@FindBy(xpath="//a[@id='nav-link-accountList']/div/span")
	public WebElement SignIn;		

	
	

	
	public HomePage hover_to_signin() throws InterruptedException
	{
		mouseHover(sign_in_button);
		click(sign_in);
		return this;
	}
	
	
	public HomePage login(String email, String password) throws InterruptedException
	{
		e_mail.sendKeys(email);
		click(continue_button);
		pwd.sendKeys(password);
		click(submit);
		String actual_text=get_text(SignIn);
		System.out.println("the actual text obtained is : " + actual_text);
		Assert.assertEquals(actual_text, expected_text);
		log.info("signed in successfully");

		return this ;
		
	}
	
	public AmazonProductPage select_product()
	{
		dropdown_select(select_product,"Amazon Devices");
		log.info("dropdown selected successfully");
		return new AmazonProductPage(driver);
	}
	
	
	

}
