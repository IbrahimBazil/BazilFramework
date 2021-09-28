package recaptcha;

import org.testng.annotations.Test;

import base.BaseTest;

public class ListView extends BaseTest{

	private String listviewurl = "listviewurl";
	
	
	@Test
	public void saveSearchListView() throws InterruptedException {
		launchingUrl(listviewurl);
		//Thread.sleep(15000);
		lvp.clickSaveSearch();
		//Thread.sleep(15000);
		//reg.switchtoiframe();
		//frames();
		reg.switchtoiframe();
		reg.doRegistrationListView();
		if(reg.captchaDisplayed()) {
			log.info("Captcha is Displayed");
		} else {
			saveSearchListView();
		}
	}
	
	
	
}
