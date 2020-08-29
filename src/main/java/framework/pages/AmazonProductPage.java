package framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.baseClass.SeleniumBase;

public class AmazonProductPage extends SeleniumBase {
	
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(AmazonProductPage.class.getName());

	
	public AmazonProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(how=How.ID, using="twotabsearchtextbox") 
	public WebElement search_element;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit']") 
	public WebElement search_button;


	
	
	public void search_product()
	{
		search_element.sendKeys(prop.getProperty("search_value"));
		//search_element.sendKeys("fire tv stick");
		click(search_button);
		log.info("search results obtained successfully");

		
	}

}
