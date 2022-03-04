package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	static ExtentReports er;
	
	public static ExtentReports testReport() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		esr.config().setDocumentTitle("Automation Test Report");
		esr.config().setReportName("Web");
		
		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Tester", "Krishnan");
		return er;
		
		
		
	}

}
