package Phase2_Testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.IE_Home_PageElements;
import pageobjects.Overseas_HomePage_Elements;
import util.ExcelUtility;

public class P2_3VerifyFullRegistratnOverseas extends BaseClass {
	@Test
	public void testPriority1() throws IOException, InterruptedException {
		usrdir = System.getProperty("user.dir");
		testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
		System.out.println("Testing P2_3_VerifyFullRegistratnOverseas");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		;
		Overseas_HomePage_Elements op = new Overseas_HomePage_Elements(this.driver);
		// Get form data from FormDataSheet
		String[][] formData = ExcelUtility.getFormData(testdatapath, "CA_FormData");
		
		for (int i = 0; i < formData.length; i++) {

			Thread.sleep(2000);
			op.click_TopBanner_Register_button();
			System.out.println("Reached to enroll form");
			// Use form data to fill the form
			// Thread.sleep(3000);
			op.enterFirstName(formData[i][0]); // First Name (from Excel)
			op.enterLastName(formData[i][1]); // Last Name (from Excel)
			// hp.enterEmail(formData[i][2]); // Email (from Excel)
			op.enterRandomEmail(); // Random mail
			op.enterPhoneNumber(formData[i][3]); // Phone Number (from Excel)
			// op.enterCountry(formData[i][4]);
			op.clickEnroll();
			System.out.println("Form1 details are filled and clicked on enroll button");

			System.out.println("Navigating to form 2");
			op.PostalCode(formData[i][5]);
			op.SelectState(formData[i][6]);
			op.enterAddress(formData[i][7]);
			op.enterCity(formData[i][8]);

			op.click_firstCheckbox();
			op.click_secondCheckbox();
			op.click_terms_Checkbox();
			op.click_privacy_Checkbox();
			op.click_PaySecurely();

		}

	}
}
