package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homePageObjects {

	public WebDriver driver;
	public homePageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//input[@type='text']")
	WebElement searchbar;
	
	
	@FindBy(how=How.XPATH, using="//input[@value='Google Search']")
	WebElement searchbtn;
	
	public WebElement searchbar_txt() {
		return searchbar;
		
	}
	
	public WebElement search_btn() {
		return searchbtn;
	}
	
}
