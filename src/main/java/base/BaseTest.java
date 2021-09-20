package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import base.BasePage;
import listeners.Listeners;
import pageobjects.homePageObjects;
import utilities.ElementUtils;
import utilities.JavaScriptExe;

public class BaseTest extends BasePage {

	public static WebDriver driver;
	public Properties prop;
	public homePageObjects hmpg;
	public JavaScriptExe js;
	public ElementUtils elu;
	public static String path1 = System.getProperty("user.dir");
	public static String OUTPUT_FOLDER =path1+"//reports//Screenshots//";
	public String FILE_NAME;
	
	
	
	@Parameters({"browser", "version"})
	@BeforeClass(alwaysRun = true)
	public void launchsite(@Optional String browserName, @Optional String browserVersion) {
		System.out.println("Before Test Started");
		prop=loadproperties();
		String browser=prop.getProperty("browser");
		
		log.info(browserName);
		log.info(browserVersion);
		
		if(browserName !=null) {
			browser = browserName;
		}
		
		System.out.println(browser);
		driver=initializeDriver(browser,browserVersion);
		String url=prop.getProperty("url");
		driver.get(url);
		
		hmpg=new homePageObjects(driver);
		elu=new ElementUtils(driver);
		js= new JavaScriptExe(driver);
		
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		/*try {
			getScreenshot("Test", driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		driver.quit();
	}
	
	public String getScreenshot(String TestCaseName) throws IOException {
		//driver=this.driver;
		String date = new SimpleDateFormat("ddMMyyyhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		FILE_NAME = "Screenshot_" + TestCaseName + "_" + date + ".png";
		String destinationFile = OUTPUT_FOLDER + FILE_NAME;
		//valuesss=destinationFile;
		//String path2 = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(destinationFile);
		FileUtils.copyFile(src, destination);
		return destinationFile;

	}
	
	
}

