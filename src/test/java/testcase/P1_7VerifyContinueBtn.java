package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.IE_Home_PageElements;
//reusable testcase for the regions only if the popup is handled
public class P1_7VerifyContinueBtn extends BaseClass {
	@Test
	public void Enroll_ContinuebtnTestcase() throws InterruptedException {
		System.out.println("####### TC7 ########");
		System.out.println("Verify the Continue with button functionality");
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		hp.clickRegister();
		Thread.sleep(2000);
		hp.clickContinueWith();
		Thread.sleep(3000);
		String currentUrl = hp.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		// Validate if the URL contains the expected region
		//Assert.assertTrue(currentUrl.toLowerCase().contains(region.toLowerCase()), 
        //        "URL does not contain expected region: " + region);
		//System.out.println("Child URl contains "+ region+" in it");
		Assert.assertEquals("Login to your Isha Profile",hp.getTitle_URL());
		System.out.println("Title of the page: "+ hp.getTitle_URL() );
	}

}