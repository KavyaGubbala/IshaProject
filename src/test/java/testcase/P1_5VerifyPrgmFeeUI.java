package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

import pageobjects.IE_Home_PageElements;

public class P1_5VerifyPrgmFeeUI extends BaseClass {

	@Test
	public void testPriotity1() {
		driver.manage().window().maximize();
		System.out.println("####### TC5 ########");
		System.out.println("Verify the UI of Program Fee section");
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		Assert.assertEquals("Program Fee", hp.getProgramFeeHeading(), "Mismatch in Program Fee heading!");
		System.out.println("Actual Heading:- " + hp.getProgramFeeHeading());
		

	}

}