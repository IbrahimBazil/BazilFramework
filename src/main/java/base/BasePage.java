package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.OptionManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public static String path = System.getProperty("user.dir");
	public String browserName;
	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public FileInputStream fis;
	public ChromeOptions co;
	public FirefoxOptions fo;
	public static final Logger log = Logger.getLogger(BasePage.class);
	// private static String OUTPUT_FOLDER ="./reports/Screenshots/";
	protected static String FILE_NAME;
	// public String valuesss;

	public WebDriver initializeDriver(String browser, String browserVersion) {
		highlight = prop.getProperty("highlight");
		OptionManager optionManager = new OptionManager(prop);

		if (browser.equalsIgnoreCase("chrome")) {
			try {
				co = optionManager.getChromeOptions();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(co);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (browser.equalsIgnoreCase("firefox")) {
			try {
				fo = optionManager.getFirefoxOptions();
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(fo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (browser.equalsIgnoreCase("iexplore")) {
			try {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} catch (Exception e) {
				log.debug(e.getMessage());
			}
		}

		if (browser.equalsIgnoreCase("edge")) {
			try {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} catch (Exception e) {
				log.debug(e.getMessage());
			}
		}

		if (browser.equalsIgnoreCase("headless")) {
			try {
				System.setProperty("capture.video", "false");
				WebDriverManager.phantomjs().setup();
			} catch (Exception e) {
				log.debug(e.getMessage());
			}
		}

//		loadproperties();
//		String browserValue=System.getProperty("browser");
//		if(browserValue!=null) {
//			browserName= browserValue;
//		} else {
//			browserName=prop.getProperty("browser");
//		}
//		
//		if(browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\M1058748\\eclipse-workspace\\BazilFramework\\browsers\\chromedriver.exe");
//			driver= new ChromeDriver();
//		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public Properties loadproperties() {
		prop = new Properties();
		try {
			fis = new FileInputStream(path + "//config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}
	/*
	 * public String getScreenshot(String TestCaseName, WebDriver driver) throws
	 * IOException { //driver=this.driver; String date = new
	 * SimpleDateFormat("ddMMyyyhhmmss").format(new Date()); TakesScreenshot ts =
	 * (TakesScreenshot) driver; File src = ts.getScreenshotAs(OutputType.FILE);
	 * 
	 * FILE_NAME = "Screenshot_" + TestCaseName + "_" + date + ".png"; String
	 * destinationFile = OUTPUT_FOLDER + FILE_NAME; //valuesss=destinationFile;
	 * //String path2 = System.getProperty("user.dir") + "/screenshots/" +
	 * System.currentTimeMillis() + ".png"; File destination = new
	 * File(destinationFile); FileUtils.copyFile(src, destination); return
	 * destinationFile;
	 * 
	 * }
	 */

}
