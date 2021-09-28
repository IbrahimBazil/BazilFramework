package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;
import utilities.JavaScriptExe;

public class ListView_PageObjects {

	public WebDriver driver;
	public JavaScriptExe js = new JavaScriptExe(driver);
	public ElementUtils elu = new ElementUtils(driver);
	public ListView_PageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.ID, using="saveSearchLink")
	WebElement saveSearch;
	
	@FindBy(how=How.ID, using="saveLink0")
	WebElement HeartIconInListView;
	
	
	public void clickSaveSearch() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		elu.doClick(saveSearch);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void clickHeartIconInListView() {
		js.clickElementByJS(HeartIconInListView);
	}
	
	
	
}
