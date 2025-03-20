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
import pageobjects.IE_Home_PageElements;


public class P1_4VerifyStickyCTA extends BaseClass{

	@Test
	 public void StickyRegisterCta() throws InterruptedException
	   {
		 System.out.println("####### TC4 ########");
	       System.out.println("Verify Sticky Register now button functionality");
	       driver.manage().window().maximize();
	       IE_Home_PageElements hp = new IE_Home_PageElements(this.driver);
	       Thread.sleep(5000);
	       if(region.equalsIgnoreCase("IN"))
	       {
	    	   hp.clickRegisterStickyctaIN();
	       }
	       else {
	    	   hp.clickRegisterStickyctaOverseas();
	       }
	       System.out.println("section heading after clicking on top banner register CTA:- " + hp.enrollHeading_getText());
	       //System.out.println("Test Passed");
		 
		
	   }
	 
	   }
	
	