package testcase;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.IE_Home_PageElements;
// passes if we handle popup
public class P1_1VerifyBannerLoginBtn extends BaseClass {
	// WebDriver driver;
	@Test
	public void testPriority1() throws InterruptedException {
		System.out.println("####### TC1 ########");
		System.out.println("Verifying Banner Login button functionality");
		//driver.manage().window().maximize();
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		hp.clickLogin();

		String parent = driver.getWindowHandle();
		//System.out.println("Parent Window Handle: " + parent);
		// Wait for child window (temporary sleep for debugging, replace with Explicit Wait)
		Thread.sleep(3000); 
		Set<String> allWindows = driver.getWindowHandles();
		//System.out.println("Total Windows Opened: " + allWindows.size());
		if (allWindows.size() > 1) { // Ensure a child window exists
		    for (String windowHandle : allWindows) {
		        if (!windowHandle.equals(parent)) {
		            driver.switchTo().window(windowHandle);
		            Thread.sleep(5000);
		            System.out.println("Switched to Child Window");
		            Assert.assertEquals("Login to your Isha Profile",hp.getTitle_URL());
		            break;
		        }
		    }
		} else {
		    System.out.println("No child window detected!");
		}

		// Switch back to the parent window
		driver.switchTo().window(parent);
		Assert.assertEquals("Inner Engineering | Shambhavi Mahamudra Kriya | Offered by Sadhguru" , driver.getTitle());
		System.out.println("Test Passed!");
	}

}
