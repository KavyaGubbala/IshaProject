package Phase2_Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import base.BaseClass;
import pageobjects.IE_Home_PageElements;
import pageobjects.IE_Payment_Page_Elements;
import util.ExcelUtility;

public class P2_1_VerifyFullRegistratnIndia extends BaseClass {
	@Test
	public void testPriority1() throws IOException, InterruptedException {
		usrdir = System.getProperty("user.dir");
		testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
		System.out.println("Testing P2_1_VerifyFullRegistratnIndia");
		driver.manage().window().maximize();
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
			System.out.println("Form1 details are filled and clicked on enroll button");
			hp.whatsAppSame();
			hp.enterZipCode(formData[i][4]);
			Thread.sleep(3000);

			hp.enterAddress(formData[i][5]);

			// Perform other actions (checkboxes, buttons, etc.)
			hp.clickMedicalCheckbox();
			hp.clickReceiveMessagesCheckbox();
			hp.clickAgeCheckbox();
			hp.clickTermsCheckbox();
			// Thread.sleep(2000);
			hp.clickPayButton();
			System.out.println(
					"Form 2 details filled and the checkboxes are clicked and then pay button is clicked successfully");

			IE_Payment_Page_Elements PaymentPage = new IE_Payment_Page_Elements(this.driver);
			PaymentPage.Select_payment_type();
			PaymentPage.Select_Test_Bank();
			PaymentPage.click_Proceed_button();
			PaymentPage.Enter_User_name(formData[i][6]);
			PaymentPage.Enter_Password_(formData[i][7]);
			PaymentPage.clickSubmit();
			PaymentPage.Simulate_success_Response();
			PaymentPage.Complete_Payment_Response();
			
			System.out.println("Test Passed");

		}

	}
	
	//Payment Failure
//	@Test
//	public void testPriority2() throws IOException, InterruptedException {
//		usrdir = System.getProperty("user.dir");
//		testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
//		System.out.println("Testing P2_1_VerifyFullRegistratnIndia");
//		driver.manage().window().maximize();
//		// driver.get(link);
//		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
//		// Get form data from FormDataSheet
//		String[][] formData = ExcelUtility.getFormData(testdatapath, "FormData1"); // Call getFormData method
//
//		// Print form data for debugging (optional)
//		// System.out.println("Form Data: ");
//
//		for (int i = 0; i < formData.length; i++) {
//			// Print form data for debugging (optional)
////        System.out.println("Form Data for row " + (i + 1) + ": ");
////        for (String data : formData[i]) {
////            System.out.println(data);
////        }
//			Thread.sleep(2000);
//			hp.clickRegister();
//			System.out.println("Reached to enroll form");
//			// Use form data to fill the form
//			Thread.sleep(3000);
//			hp.enterFirstName(formData[i][0]); // First Name (from Excel)
//			hp.enterLastName(formData[i][1]); // Last Name (from Excel)
//			// hp.enterEmail(formData[i][2]); // Email (from Excel)
//			hp.enterRandomEmail(); // Random mail
//			hp.enterPhoneNumber(formData[i][3]); // Phone Number (from Excel)
//			hp.clickEnrollButton();
//			System.out.println("Form1 details are filled and clicked on enroll button");
//			hp.whatsAppSame();
//			hp.enterZipCode(formData[i][4]);
//			Thread.sleep(3000);
//
//			hp.enterAddress(formData[i][5]);
//
//			// Perform other actions (checkboxes, buttons, etc.)
//			hp.clickMedicalCheckbox();
//			hp.clickReceiveMessagesCheckbox();
//			hp.clickAgeCheckbox();
//			hp.clickTermsCheckbox();
//			// Thread.sleep(2000);
//			hp.clickPayButton();
//			System.out.println(
//					"Form 2 details filled and the checkboxes are clicked and then pay button is clicked successfully");
//
//			IE_Payment_Page_Elements PaymentPage = new IE_Payment_Page_Elements(this.driver);
//			PaymentPage.Select_payment_type();
//			PaymentPage.Select_Test_Bank();
//			PaymentPage.click_Proceed_button();
//			PaymentPage.Enter_User_name(formData[i][6]);
//			PaymentPage.Enter_Password_(formData[i][7]);
//			PaymentPage.clickSubmit();
//			PaymentPage.Simulate_failure_Response();
//			PaymentPage.Failure_Payment_Response();
//			System.out.println("Test Passed");
//
//		}

//	}
}
