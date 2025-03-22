package testcase;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.IE_Home_PageElements;


//reusable testcase if we handle popup For overseas and UK has cookies banner on the footer section. 
public class P1_10VerifyIshaSupportLink extends BaseClass {

	@Test
	public void IshaSupportLinkTestcase() throws InterruptedException {
		System.out.println("####### TC10 ########");
		System.out.println("Verify the 'support.ishafoundation.org' link functionality");
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		Thread.sleep(3000);
		hp.clickSupportLink();
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		// System.out.println("Parent Window Handle: " + parent);
		// Wait for child window (temporary sleep for debugging, replace with Explicit
		// Wait)
		
		Set<String> allWindows = driver.getWindowHandles();
		// System.out.println("Total Windows Opened: " + allWindows.size());
		if (allWindows.size() > 1) { // Ensure a child window exists
			for (String windowHandle : allWindows) {
				if (!windowHandle.equals(parent)) {
					driver.switchTo().window(windowHandle);
					Thread.sleep(5000);
					System.out.println("Switched to Child Window");
					String currentUrl = hp.getCurrentUrl();
					if (region.equalsIgnoreCase("US") || region.equalsIgnoreCase("CA")) {
						String expectedURL = "https://support.ishafoundation.org/en/support/home"; // Replace with actual expected URL
						Assert.assertEquals("URL does not match expected value!", currentUrl.contains(expectedURL));
						Assert.assertEquals("Support : Support", hp.getTitle_URL());

					}
					else if(region.equalsIgnoreCase("UK")) {
						String expectedURL = "https://kb.ishayoga.eu/ie-support/?m=backup"; // Replace with actual expected URL
						Assert.assertEquals("URL does not match expected value!", currentUrl.contains(expectedURL));
						Assert.assertEquals("Inner Engineering 7 Steps Support Europe", hp.getTitle_URL());
					}
					else {
						String expectedURL = "https://support.innerengineering.com/en/support/tickets/new"; // Replace with actual expected URL
						Assert.assertEquals("URL does not match expected value!", currentUrl.contains(expectedURL));
						Assert.assertEquals("Submit a ticket : Inner Engineering", hp.getTitle_URL());
					}

					
					break;
				}
			}
		} else {
			System.out.println("No child window detected!");
		}

		// Switch back to the parent window
		driver.switchTo().window(parent);
		Assert.assertEquals("Inner Engineering | Shambhavi Mahamudra Kriya | Offered by Sadhguru", driver.getTitle());
		//System.out.println("Test Passed!");
	}
}
