package recaptcha;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class ListView extends BaseTest{

	private String listviewurl = "listviewurl";
	
	@Parameters({"brand"})
	@BeforeMethod
	public void launchsite(@Optional String brandName) {
		
		String brand=prop.getProperty("brand");
		if(brandName != null) {
			brand=brandName;
		}
		launchingUrl(brand,listviewurl);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void saveSearchListView(){
		lvp.clickSaveSearch();
		reg.doRegistrationListView();
		if(reg.captchaDisplayed()) {
			log.info("Captcha is Displayed");
		} else {
			saveSearchListView();
		}
	}
	
	@Test(priority=2)
	public void HeartIconinListView() {
		lvp.clickHeartIconInListView();
		reg.doRegistrationListView();
		if(reg.captchaDisplayed()) {
			log.info("Captcha is Displayed");
		} else {
			HeartIconinListView();
		}
	}
	
	
	
	
	
}
