package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public WebDriver driver;
	public static String path = System.getProperty("user.dir");
	private static String OUTPUT_FOLDER ="./reports/Screenshots/";
	private static String FILE_NAME;
	
	
	public String getScreenshot(String TestCaseName, WebDriver driver) throws IOException {
		//driver=this.driver;
		String date = new SimpleDateFormat("ddMMyyyhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		FILE_NAME = "Screenshot_" + TestCaseName + "_" + date + ".png";
		String destinationFile = OUTPUT_FOLDER + FILE_NAME;
		//String path2 = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(destinationFile);
		FileUtils.copyFile(src, destination);
		return destinationFile;

	}
}
