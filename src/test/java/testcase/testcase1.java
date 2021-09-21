package testcase;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class testcase1 extends BaseTest {
//public WebDriver driver=super.driver;

	@Test(priority = 1)
	public void search_fields() {
		hmpg.searchbar_txt().isDisplayed();
		WebElement search_txt = hmpg.searchbar_txt();
		elu.highlightElement(search_txt);
		// elu.isElementDisplayed(search_txt);
		elu.doSendKeys(search_txt, "IPhone13");
		// driver.findElement(By.xpath("//input[@type='text']")).isDisplayed();
		Assert.assertTrue(search_txt.isDisplayed(), "Pass");
	}

	@Test(priority = 2)
	public void search() {

		elu.doClick(hmpg.search_btn());
		elu.waitForTitleToBePresent(10);

	}

	@Test(priority = 3)
	public void search2() {
		elu.waitForTitleToBePresent(10);
	}
}
