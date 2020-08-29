package framework.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {
	public static WebDriver driver;
	public String browser;
	public String url;
	public  WebDriverWait wait;
	public static Properties prop;
	private static Logger log=LogManager.getLogger(SeleniumBase.class.getName());

	

	
	public WebDriver initializeDriver() throws IOException
	{
		prop =new Properties();
		FileInputStream fis=new FileInputStream("./properties/data.properties");
		prop.load(fis);
		browser=prop.getProperty("browser");
		System.out.println("the requested browser is : " + browser);
		url=prop.getProperty("url");
		
		
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("browser launched successfully");

			
			
		}catch(Exception ae)
		{
			System.out.println("error in launching browser");
		}
		
		return driver;
	}
	
	
	public void closeDriver() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
		System.out.println("driver closed");
		
	}
	
	public void mouseHover(WebElement ele)
	{
		//wait = new WebDriverWait(driver, 10);
		Actions a =new Actions(driver);
		a.moveToElement(ele).build().perform();
	}
	
	public void click(WebElement ele)
	{
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
		} catch (StaleElementReferenceException e) {
			System.out.println("the element could not be clicked");
			
		} 
	}
	
	public String get_text(WebElement ele) {

		String text = ele.getText();
		System.out.println("the element " + ele + "is clicked and the text is : " + text);
		return text;
	}
	public void dropdown_select(WebElement ele,String value)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(value);
		
	}
	
//	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
//	{
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		String destination=System.getProperty("user.dir")+"\\reports\\screenshots\\"+testCaseName+".png";
//		FileUtils.copyFile(source, new File(destination));
//		return destination;
//		
//		
//	}
	public void takeScreenshot() 
	{
		String screenName= System.currentTimeMillis()+ ".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(src, new File(System.getProperty("user.dir")+"/target/Screenshots/"+screenName+""));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
