package testcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.SkipException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
//test

import base.BaseClass;
import pageobjects.IE_Home_PageElements;

public class P1_2VerifyRegionLangSwitchr extends BaseClass {
	@Test
	public void testPriotity1() throws InterruptedException {

		System.out.println("####### TC2 ########");
		System.out.println("Verify the Language Switcher Functionality for different regions");
		driver.manage().window().maximize();
		IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
		// Thread.sleep(5000);
		// hp.clickRegister();
		// hp.openLanguageDropdown();
		// Thread.sleep(5000);
		// hp.selectLanguage("Hindi");
		// System.out.println("Test Passed!:- Tamil is selected");
		// hp.selectLanguage("Telugu");
		// System.out.println("Test Passed!:- Telugu is selected");
		// hp.selectLanguage("Tamil");
		// System.out.println("Test Passed!:- Telugu is selected");
		if (region.equalsIgnoreCase("IN")) {
			String[][] languages = { { "Hindi", "/in/hi/inner-engineering" }, { "Tamil", "/in/ta/inner-engineering" },
					{ "Kannada", "/in/kn/inner-engineering" }, { "Telugu", "/in/te/inner-engineering" },
					{ "Marathi", "/in/mr/inner-engineering" }, { "Malayalam", "/in/ml/inner-engineering" },
					{ "Bengali", "/in/bn/inner-engineering" } /* ,{"Russian","/in/ru/inner-engineering"} */ };
			// Loop through each language and verify navigation
			for (String[] lang : languages) {
				String languageName = lang[0];
				String expectedUrl = lang[1];

				// Open language dropdown
				hp.openLanguageDropdown();
				Thread.sleep(2000);

				// Select language
				hp.selectLanguage(languageName);
				Thread.sleep(3000); // Wait for navigation

				// Capturing actual URL
				String actualUrl = driver.getCurrentUrl();

				// Printdetails
				System.out.println("Language: " + languageName);
				System.out.println("Expected URL should contain: " + expectedUrl);
				System.out.println("Actual URL: " + actualUrl);

				// Verify that the actual URL contains the expected path
				Assert.assertTrue(actualUrl.contains(expectedUrl), "Navigation failed for: " + languageName);

				System.out.println("Passed: " + languageName + " navigated successfully.");
				driver.get(link);
				Thread.sleep(3000);

			}

		} else if (region.equalsIgnoreCase("UK")) {
			String[][] ukLanguages = { { "French", "/global/fr/inner-engineering" },
					{ "German", "/global/de/inner-engineering" }, { "Spanish", "/global/es/inner-engineering" },
					{ "Italian", "/global/it/inner-engineering" }, { "Russian", "/global/ru/inner-engineering" } };
			for (String[] lang : ukLanguages) {
				String languageName = lang[0];
				String expectedUrl = lang[1];
				hp.overseas_selectLanguage(languageName);
				String actualUrl = driver.getCurrentUrl();
				System.out.println("Language: " + languageName);
				System.out.println("Expected URL should contain: " + expectedUrl);
				System.out.println("Actual URL: " + actualUrl);
				Assert.assertTrue(actualUrl.contains(expectedUrl), "Navigation failed for: " + languageName);

				System.out.println("Passed: " + languageName + " navigated successfully.");

				driver.get(link);
				Thread.sleep(3000);
			}
		} else if (region.equalsIgnoreCase("global")) {
			String[][] globalLanguages = { { "French", "/global/fr/inner-engineering" },

					{ "German", "/global/de/inner-engineering" }, { "Spanish", "/global/es/inner-engineering" },
					{ "Italian", "/global/it/inner-engineering" }, { "Russian", "/global/ru/inner-engineering" },
					{ "Traditionalchinese", "/global/zh-tw/inner-engineering" },
					
					{ "BahasaIndonesia", "/global/id/inner-engineering" },
					{ "Arabic", "/global/ar/inner-engineering" }, 
					{ "simplifiedchinese", "/global/zh/inner-engineering" }};
			for (String[] lang : globalLanguages) {
				String languageName = lang[0];
				String expectedUrl = lang[1];
				hp.global_selectLanguage(languageName);
				String actualUrl = driver.getCurrentUrl();
				System.out.println("Language: " + languageName);
				System.out.println("Expected URL should contain: " + expectedUrl);
				System.out.println("Actual URL: " + actualUrl);
				Assert.assertTrue(actualUrl.contains(expectedUrl), "Navigation failed for: " + languageName);

				System.out.println("Passed: " + languageName + " navigated successfully.");

				driver.get(link);
				Thread.sleep(3000);
			}

		}
		else {
			Thread.sleep(5000);
//			 String mainWindowId = driver.getWindowHandle();
//	 	       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	 	       System.out.println("US Nurture Pop up Handle");
//	 	       String windowIds = driver.getWindowHandle();
//	 		  //for(String windowId : windowIds){
//	 			driver.switchTo().window(windowIds);
//	 			String popupText = driver.findElement(By.xpath("//*[@id='isPasted']/span[1]")).getText();
//	 			System.out.println(popupText);
//	 			Thread.sleep(3000);
//	 			driver.findElement(By.xpath("//*[@id='om-ugpkop8dbcgry3vdauf7-yesno']/div/button")).click();
//	 	        driver.switchTo().window(mainWindowId);
//	 	        System.out.println("popup is closed in the page");
			System.out.println("Skipping test: Language switcher is not available for region " + region);
		}
	}
}
