package testcase;

import java.util.Set;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.IE_Home_PageElements;
//reusable if popup is handled in overseas region
public class P1_9VerifyAttendInPersLink extends BaseClass {

	@Test
	public void AttendINpersonTestCase() throws InterruptedException {
		System.out.println("####### TC9 ########");
		System.out.println("Verify the 'Attend In Person' link  functionality");
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		hp.clickAttendInPerson();
		String parent = driver.getWindowHandle();
		// System.out.println("Parent Window Handle: " + parent);
		// Wait for child window (temporary sleep for debugging, replace with Explicit
		// Wait)
		Thread.sleep(3000);
		Set<String> allWindows = driver.getWindowHandles();
		// System.out.println("Total Windows Opened: " + allWindows.size());
		if (allWindows.size() > 1) { // Ensure a child window exists
			for (String windowHandle : allWindows) {
				if (!windowHandle.equals(parent)) {
					driver.switchTo().window(windowHandle);
					Thread.sleep(5000);
					String currentUrl = hp.getCurrentUrl();
					System.out.println("Switched to Child Window");
					//Assert.assertTrue("URL does not contain expected region: " + region,
					//		currentUrl.toLowerCase().contains(region.toLowerCase()));
					//System.out.println("Child Page URL:- " + hp.getCurrentUrl() +"\n"+ "contains " + region + 
					//		" parameter in the link");
					//Assert.assertEquals("Program Finder – Sadhguru & Isha Foundation", hp.getTitle_URL());

					System.out.println("Child Page title:- " + hp.getTitle_URL());
					break;
				}
			}
		} else {
			System.out.println("No child window detected!");
		}
		driver.switchTo().window(parent);
		Assert.assertEquals("Inner Engineering | Shambhavi Mahamudra Kriya | Offered by Sadhguru", driver.getTitle());
		//System.out.println("Test Passed!");
	}
}