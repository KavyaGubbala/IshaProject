package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import base.BaseClass;
import pageobjects.IE_Home_PageElements;
import util.ExcelUtility;

public class P1_6VerifyLangSwitchr extends BaseClass {
	@Test
	@Parameters("region")
	public void EnrollLangSwitcher_Testcase(String region) throws InterruptedException, IOException {
		System.out.println("####### TC6 ########");
		System.out.println("Verifying Language Switcher functionality in Enroll form");
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		hp.clickRegister();
		Thread.sleep(2000);

//		String[] indianLanguages = { "Hindi", "Tamil", "Telugu", "Kannada", "Marathi", "Malayalam", "Bengali",
//				"English" };
//		String[] commonLanguages = { "English", "German", "French", "Italian", "Spanish", "Russian",
//				"Simplified Chinese", "Traditional Chinese", "Bahasa Indonesia", "Arabic" };
//
//		// String indiaEnglishPrice = "INR 4000";
//		// String indiaOtherPrice = "INR 2000";
//		String[] selectedLanguages = region.equalsIgnoreCase("India") ? indianLanguages : commonLanguages;
//		String usPrice = "USD 175";
//		String caPrice = "CAD 175";
//		String ukPrice = "GBP 125";
//
//		for (String lang : indianLanguages) {
//			hp.enroll_selectLanguage(lang);
//			System.out.println("\nSelected Language: " + lang);
//
//			// Verify price update
//			if (lang.equalsIgnoreCase("English")) {
//				Assert.assertEquals(hp.getEnrollPrice(), "INR 4000", "Price did not update for English");
//				System.out.println("Price of : " + lang + " " + hp.getEnrollPrice());
//			} else {
//				Assert.assertEquals(hp.getEnrollPrice(), "INR 2000", "Price did not update for " + lang);
//				System.out.println("Price of : " + lang + " " + hp.getEnrollPrice());
//
//				// Skip dubbed message validation for Tamil
//				if (lang.equalsIgnoreCase("Tamil")) {
//					System.out.println("Skipping dubbed message validation for Tamil.");
//					continue;
//				}
//
//				// Validate dubbed message presence for non-English languages
//				boolean isDubbedMessageDisplayed = hp.isDubbedMessageDisplayed();
//				Assert.assertTrue(isDubbedMessageDisplayed, "Dubbed message not displayed for " + lang);
//
//				if (isDubbedMessageDisplayed) {
//					System.out.println(
//							"Dubbed message is displayed for language: " + lang + " | Price: " + hp.getEnrollPrice());
//				} else {
//					System.out.println("Dubbed message is not displayed for language: " + lang + " | Price: "
//							+ hp.getEnrollPrice());
//				}
//			}
//		}
//		String[][] regions = { { "US", usPrice }, { "CA", caPrice }, { "UK", ukPrice } };
//
//		for (String[] region : regions) {
//			String regionName = region[0];
//			String expectedPrice = region[1];
//
//			System.out.println("\nTesting for region: " + regionName);
//			for (String lang : commonLanguages) {
//				hp.enroll_selectLanguage(lang);
//				Thread.sleep(2000);
//				System.out.println("\nSelected Language: " + lang);
//
//				// Verify price update
//				Assert.assertEquals(hp.getEnrollPrice(), expectedPrice, "Price mismatch for " + lang);
//				System.out.println("Price of " + lang + " in " + regionName + ": " + hp.getEnrollPrice());
//
//				// No dubbed message validation for these regions
//			}
//		}
//	}
		usrdir = System.getProperty("user.dir");
		testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
		String[] prices = ExcelUtility.getProgramFeeDetails(testdatapath, sheetName, region);

		String expectedOldPrice = prices[0];
		String expectedNewPrice = prices[1];
		String expectedOldRegionalPrice = prices[2];
		String expectedNewRegionalPrice = prices[3];

		
		if (region.equalsIgnoreCase("IN")) {
			String[] indianLanguages = { "Hindi", "Tamil", "Telugu", "Kannada", "Marathi", "Malayalam", "Bengali",
					"English" };

			for (String lang : indianLanguages) {
				hp.enroll_selectLanguage(lang);
				Thread.sleep(2000);
				String price = hp.getEnrollPrice();
				System.out.println("\nSelected Language: " + lang + " | Price: " + price);

				// English price is different
				if (lang.equalsIgnoreCase("English")) {
					Assert.assertEquals(price, expectedNewPrice, "Price mismatch for " + lang);
				} else {
					Assert.assertEquals(price,expectedNewRegionalPrice, "Price mismatch for " + lang);
				}

				// Skip dubbed message validation for Tamil
				if (lang.equalsIgnoreCase("Tamil")) {
					System.out.println("Skipping dubbed message validation for Tamil.");
					continue;
				}

				// Validate Dubbed Message for all other regional languages (except English &
				// Tamil)
				if (!lang.equalsIgnoreCase("English")) {
					boolean isDubbedMessageDisplayed = hp.isDubbedMessageDisplayed();
					Assert.assertTrue(isDubbedMessageDisplayed, "Dubbed message not displayed for " + lang);
					System.out.println("dubbed message is displayed for " + lang);
				}
			}
		} else {
			String[] commonLanguages = { "English", "German", "French", "Italian", "Spanish", "Russian",
					"Simplified Chinese", "Traditional Chinese", "Bahasa Indonesia", "Arabic" };

			

			for (String lang : commonLanguages) {
				hp.enroll_selectLanguage(lang);
				Thread.sleep(2000);
				String price = hp.getEnrollPrice();
				System.out.println("\nSelected Language: " + lang + " | Price: " + price);

				// Verify price update
				Assert.assertEquals(price, expectedNewPrice, "Price mismatch for " + lang);
			}
		} 
	}
}