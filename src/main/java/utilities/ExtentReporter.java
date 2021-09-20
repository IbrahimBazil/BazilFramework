package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports extent;
	//public static String path1 = System.getProperty("user.dir");
	
	private static final String OUTPUT_FOLDER="./reports/HTML Report/";
	private static String File_Name;
	public static ExtentReports extentReporterObj() {
	Path path = Paths.get(OUTPUT_FOLDER);
	String date=new SimpleDateFormat("ddMMyyyyhhmm").format(new Date());
	File_Name="TestExecutionResults_"+date+".html";
	if(!Files.exists(path)) {
		try {
			Files.createDirectories(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	String destinationFile=OUTPUT_FOLDER+File_Name;
	ExtentSparkReporter report=new ExtentSparkReporter(destinationFile);
	report.config().setReportName("Bazil's Automation");
	report.config().setDocumentTitle("Automation Test Results");
	report.config().setTheme(Theme.DARK);
	//report.config().
	extent=new ExtentReports();
	extent.attachReporter(report);
	extent.setSystemInfo("Tester", "IbrahimBazil");
	
	return extent;
	
	}

}
