package framework.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import framework.baseClass.SeleniumBase;

public class Listeners extends SeleniumBase implements ITestListener{
 

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
	}


	public void onTestFailure(ITestResult result) {
//		
//		WebDriver driver=null;
//		// TODO Auto-generated method stub
//		//ITestListener.super.onTestFailure(result);
//		String testCaseName=result.getMethod().getMethodName();
//		try{
//			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("fieldname").get(result.getInstance());
//		}catch(Exception ae)
//		{
//			
//		}
//		try {
//			getScreenShotPath(testCaseName,driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		WebDriver driver=null;
//		String testMethodName = result.getMethod().getMethodName();
//		try {
//			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstanceName());
//		}catch(Exception e)
//		{
//			
//		}
		try {
			takeScreenshot();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

}
