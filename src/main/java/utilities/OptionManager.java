package utilities;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;

	public OptionManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if (prop.getProperty("headless").trim().equalsIgnoreCase("true"))
			co.addArguments("--headless");
		if (prop.getProperty("incognito").trim().equalsIgnoreCase("true"))
			co.addArguments("--incognito");
		if (prop.getProperty("cookies").trim().equalsIgnoreCase("true"))
			co.addArguments("enable-cookies");
		return co;

	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if (prop.getProperty("headless").trim().equals("true"))
			fo.addArguments("--headless");
		if (prop.getProperty("incognito").trim().equals("true"))
			fo.addArguments("--incognito");
		if (prop.getProperty("cookies").trim().equalsIgnoreCase("true"))
			fo.addArguments("enable-cookies");
		return fo;
	}

}
