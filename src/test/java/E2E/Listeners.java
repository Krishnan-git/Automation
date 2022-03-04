package E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Resources.ExtentReportsNG;

public class Listeners extends Base implements ITestListener {
	
	ExtentReports er = ExtentReportsNG.testReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String TestcaseName = result.getMethod().getMethodName();
		 test = er.createTest(TestcaseName);
		 tl.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		tl.get().log(Status.PASS, "Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		tl.get().fail(result.getThrowable());
		WebDriver driver = null;
		String TestcaseName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tl.get().addScreenCaptureFromPath(captureScreenshot(TestcaseName,driver), TestcaseName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		er.flush();
	}

}
