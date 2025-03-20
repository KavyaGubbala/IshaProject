package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;

import pageobjects.IE_Home_PageElements;
import util.ExcelUtility;
@Listeners(util.Listeners.class)  
public class P1_5VerifyPrgmFeeUI extends BaseClass {

	@Test

	public void programFeeUI_Testcase() throws IOException, InterruptedException {

		System.out.println("####### TC5 ########");
		System.out.println("Verify the UI of Program Fee section");
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		usrdir = System.getProperty("user.dir");
		testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
		String[] prices = ExcelUtility.getProgramFeeDetails(testdatapath, sheetName, region);
		Thread.sleep(3000);
		hp.scrollToProgramFeeSection();
		Assert.assertEquals("Program Fee", hp.getProgramFeeHeading(), "Mismatch in Program Fee heading!");
		System.out.println("Actual Heading:- " + hp.getProgramFeeHeading());

		String expectedOldPrice = prices[0];
		String expectedNewPrice = prices[1];
		String expectedOldRegionalPrice = prices[2];
		String expectedNewRegionalPrice = prices[3];
		Thread.sleep(5000);

		// Verify "Program Fee" heading
		// Assert.assertEquals(programFeeHeading.getText(), "Program Fee", "Mismatch in
		// Program Fee heading");
		if (region.equalsIgnoreCase("IN")) {

			// Verify old and new prices

			Assert.assertEquals(hp.oldPriceLocator.getText(), expectedOldPrice, "Old price mismatch for " + region);
			System.out.println("Striken amount of India en:- " + hp.oldPriceLocator.getText());
			Assert.assertEquals(hp.newPriceLocator.getText(), expectedNewPrice, "New price mismatch for " + region);
			System.out.println("Discounted price for India english:- " + hp.newPriceLocator.getText());
			Assert.assertEquals(hp.oldRegionalPriceLocator.getText(), expectedOldRegionalPrice,
					"Old regional price mismatch for India");
			System.out.println("Striken amount of India regional languages:- " + hp.oldRegionalPriceLocator.getText());
			Assert.assertEquals(hp.newRegionalPriceLocator.getText(), expectedNewRegionalPrice,
					"New regional price mismatch for India");
			System.out
					.println("Discounted amount of India regional languages:- " + hp.newRegionalPriceLocator.getText());
		} else {
			Assert.assertEquals(hp.overseasOldPriceLocator.getText(), expectedOldPrice,
					"Old price mismatch for " + region);
			System.out.println("Striken amount of " + region +":- "+ hp.overseasOldPriceLocator.getText());
			Assert.assertEquals(hp.overseasNewPriceLocator.getText(), expectedNewPrice,
					"New price mismatch for " + region);
			System.out.println("Discounted price of "+region +":- " + hp.overseasNewPriceLocator.getText());

		}

	}
}
