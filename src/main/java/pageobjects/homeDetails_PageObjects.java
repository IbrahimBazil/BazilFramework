package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;
import utilities.JavaScriptExe;

public class homeDetails_PageObjects {

	public WebDriver driver;
	public JavaScriptExe js;
	public ElementUtils elu;

	public homeDetails_PageObjects(WebDriver driver) {
		this.driver = driver;
		elu = new ElementUtils(this.driver);
		js = new JavaScriptExe(this.driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@id='btnSave']")
	WebElement SaveBtn;

	@FindBy(how = How.XPATH, using = "//div[@id='propInfoWrapper']//a[@data-title='Tour Home']")
	WebElement reqshowing_btn;

	@FindBy(how = How.XPATH, using = "//div[@class='actionBoxStripOld']//a[@data-title='Get More Details']")
	WebElement requestMoreinfo_btn;

	@FindBy(how = How.XPATH, using = "//div[@class='actionBoxStripOld']//a[@data-title='Tour Home']")
	WebElement goseethishome_btn;

	public void ClickSaveBtn() {
		//elu.isElementDisplayed(SaveBtn);
		elu.highlightElement(SaveBtn);
		elu.doClick(SaveBtn);
	}
	
	public void ClickRequestShowingbtn() {
		elu.highlightElement(reqshowing_btn);
		elu.doClick(reqshowing_btn);
	}
	
	public void ClickRequestMoreInfobtn() {
		elu.highlightElement(requestMoreinfo_btn);
		elu.doClick(requestMoreinfo_btn);
	}
	
	public void Clickgoseethishomebtn() {
		elu.highlightElement(goseethishome_btn);
		elu.doClick(goseethishome_btn);
	}
	
	
}
