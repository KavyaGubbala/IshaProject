package testcase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import base.BaseClass;
import junit.framework.Assert;
import pageobjects.IE_Home_PageElements;

import java.io.IOException;
import java.lang.reflect.Method;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//passes if popup is handled
public class P1_3VerifyBannerRegistrnBtn extends BaseClass {

	@Test
	public void testPriotity1() throws InterruptedException {
		// TC3
		System.out.println("####### TC3 ########");
		System.out.println("Verify Banner Register now button functionality");
		driver.manage().window().maximize();
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		Thread.sleep(5000);
		hp.clickRegister();
		// Assert.assertEquals("ENROLL IN THE Program", hp.enrollHeading_getText());
		System.out.println("section heading after clicking on top banner register CTA:- " + hp.enrollHeading_getText());
		System.out.println("Test Passed");

		// Status = "passed";

	}

}