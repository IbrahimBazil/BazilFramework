package listeners;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;
import base.BaseTest;
import utilities.ExtentReporter;
import utilities.Screenshots;

public class Listeners extends BaseTest implements ITestListener {
	
	public ExtentTest test;
	ExtentReports extent = ExtentReporter.extentReporterObj();
	public String testMethodName;
	//protected screenshotpath="./"
	//protected static final Logger log = Logger.getLogger(BasePage.class);

	//BaseTest bt=new BaseTest();
	
	ThreadLocal<ExtentTest> extentsTest= new ThreadLocal<ExtentTest>();
	public Date getTime(long millis) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
		
	}
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		testMethodName =result.getMethod().getMethodName();
		test = extent.createTest(testMethodName);
		extentsTest.set(test);
		extentsTest.get().getModel().setStartTime(getTime(result.getStartMillis()));
		log.info(testMethodName+"_Testing has been started");
	}
	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		testMethodName =result.getMethod().getMethodName();
		/*
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		try {
			extentsTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName), testMethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//extentsTest.get().addScreenCaptureFromPath(valuesss, testMethodName);
		extentsTest.get().log(Status.PASS, "Testing Passed");
		extentsTest.get().getModel().setEndTime(getTime(result.getStartMillis()));
		log.info(testMethodName+"_Testing has been completed");
	}
	
	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		testMethodName =result.getMethod().getMethodName();
		/*
		WebDriver driver = null;
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//getScreenshot(testMethodName, driver)
		*/
		try {
			extentsTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName), testMethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		extentsTest.get().log(Status.FAIL, "Test Failed");
		extentsTest.get().log(Status.FAIL, result.getThrowable());
		log.info(testMethodName+"_Test hasbeen Completed_Failed");
		
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
		extent.flush();
	}

}
