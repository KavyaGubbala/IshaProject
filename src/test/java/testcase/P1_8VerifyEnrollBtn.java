package testcase;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.IE_Home_PageElements;
import util.ExcelUtility;

public class P1_8VerifyEnrollBtn extends BaseClass {

	@Test
	public void testPriotity1() throws InterruptedException, IOException {
		System.out.println("####### TC7 ########");
		System.out.println("Verify the Continue with button functionality");
		usrdir = System.getProperty("user.dir");
		testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
		// driver.manage().window().maximize();
		// driver.get(link);
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		// Get form data from FormDataSheet
		String[][] formData = ExcelUtility.getFormData(testdatapath, "FormData1"); // Call getFormData method

		// Print form data for debugging (optional)
		// System.out.println("Form Data: ");

		for (int i = 0; i < formData.length; i++) {
			// Print form data for debugging (optional)
//        System.out.println("Form Data for row " + (i + 1) + ": ");
//        for (String data : formData[i]) {
//            System.out.println(data);
//        }
			Thread.sleep(2000);
			hp.clickRegister();
			System.out.println("Reached to enroll form");
			// Use form data to fill the form
			Thread.sleep(3000);
			hp.enterFirstName(formData[i][0]); // First Name (from Excel)
			hp.enterLastName(formData[i][1]); // Last Name (from Excel)
			// hp.enterEmail(formData[i][2]); // Email (from Excel)
			hp.enterRandomEmail(); // Random mail
			hp.enterPhoneNumber(formData[i][3]); // Phone Number (from Excel)
			hp.clickEnrollButton();
			hp.enterZipCode(formData[i][4]);
			Assert.assertTrue(hp.zipInput.isDisplayed());
			System.out.println("Enroll button is clikced and Zipcode field is identified in form 2");

		}

	}
}