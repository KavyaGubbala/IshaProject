package base;

import java.io.File;
import java.util.Optional;
import java.util.Set;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.emulation.Emulation;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.*;

import util.ExcelUtility;

public class BaseClass {
	// public RemoteWebDriver driver;
	public WebDriver driver;
	protected WebDriver wait;
	// protected String Status = "failed";
	protected String link;
	protected String usrdir;
	protected String testdatapath;
	protected String[] LambdaCredentials;
	protected String region;
	Calendar rightNow = Calendar.getInstance();
	int hour = rightNow.get(Calendar.HOUR_OF_DAY);
	int min = rightNow.get(Calendar.MINUTE);
	// protected String username;
	// protected String accessKey;

	// Calendar rightNow = Calendar.getInstance();
	// int hour = rightNow.get(Calendar.HOUR_OF_DAY);
	// int min = rightNow.get(Calendar.MINUTE);

//	@BeforeClass
//	@Parameters({ "browser" })
//	public void setup(String browser) throws IOException {
//		usrdir = System.getProperty("user.dir");
//		System.out.println("CurreUsrDir:" + usrdir);
//		testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
//		System.out.println("Actual test data path:" + testdatapath);
//
//		// Read Excel Data
//		FileInputStream fs = new FileInputStream(testdatapath);
//		XSSFWorkbook workbook = new XSSFWorkbook(fs);
//		XSSFSheet sheet = workbook.getSheetAt(1);
//
//		// username = sheet.getRow(0).getCell(1).toString();
//		// accessKey = sheet.getRow(1).getCell(1).toString();
//		link = workbook.getSheetAt(3).getRow(0).getCell(1).toString();
//
//		workbook.close();
//		fs.close();
//
//		// Setup LambdaTest Capabilities
////	        ChromeOptions chromeOptions = new ChromeOptions();
////	        HashMap<String, Object> ltOptions = new HashMap<>();
////	        ltOptions.put("platform", platform);
////	        ltOptions.put("version", version);
////	        ltOptions.put("build", "ID:" + LocalDate.now() + "_" + hour + "_" + min);
////	        ltOptions.put("name", this.getClass().getName());
////	        ltOptions.put("w3c", true);
////	        ltOptions.put("geoLocation", "IN");
////	        ltOptions.put("console", true);
////	        ltOptions.put("terminal", true);
////	        chromeOptions.setCapability("LT:Options", ltOptions);
////
////	        try {
////	            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), chromeOptions);
////	        } catch (MalformedURLException e) {
////	            System.out.println("Invalid grid URL");
////	        }
//		if (browser.equalsIgnoreCase("chrome")) {
//			// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//			driver = new ChromeDriver();
//		} else if (browser.equalsIgnoreCase("firefox")) {
//			// System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
//			driver = new FirefoxDriver();
//		} else if (browser.equalsIgnoreCase("edge")) {
//			// System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
//			driver = new EdgeDriver();
//		} else {
//			throw new IllegalArgumentException("Invalid browser name provided!");
//		}
//		if (link == null || link.trim().isEmpty()) {
//			throw new IllegalArgumentException("URL from Excel is empty! Check TestData.xlsx.");
//		}
//		driver.get(link);
//
//		System.out.println("Driver setup completed");
//
//	}
//
//	public WebDriver getDriver() {
//		return driver;
//	}
//
//	@AfterClass
//	public void closeDriver() {
//		// driver.executeScript("lambda-status=" + Status);
//		driver.quit();
//		System.out.println("Driver quit successfully");
//	}
//}

//	@BeforeClass
//    @Parameters({"browser", "env"})
//    public void setup(String browser, String env) throws IOException {
//        usrdir = System.getProperty("user.dir");
//        testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
//
//        // Read Excel Data
//        FileInputStream fs = new FileInputStream(testdatapath);
//        XSSFWorkbook workbook = new XSSFWorkbook(fs);
//        
//        // Dynamically select the environment sheet
//        switch (env.toLowerCase()) {
//            case "uat":
//                link = workbook.getSheet("uat").getRow(0).getCell(1).toString();
//                break;
//            case "dev":
//                link = workbook.getSheet("dev").getRow(0).getCell(1).toString();
//                break;
//            case "live":
//                link = workbook.getSheet("live").getRow(0).getCell(1).toString();
//                break;
//            case "staging":
//            	link=workbook.getSheet("staging").getRow(0).getCell(1).toString();
//            	break;
//            default:
//                throw new IllegalArgumentException("Invalid environment: " + env);
//        }
//
//        workbook.close();
//        fs.close();
//
//        // Initialize WebDriver based on browser parameter
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase("edge")) {
//            driver = new EdgeDriver();
//        } else {
//            throw new IllegalArgumentException("Invalid browser name provided!");
//        }
//
//        if (link == null || link.trim().isEmpty()) {
//            throw new IllegalArgumentException("URL from Excel is empty! Check TestData.xlsx.");
//        }
//        driver.manage().window().maximize();
//        driver.get(link);
//
//        System.out.println("Navigated to: " + link);
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
//
//    @AfterClass
//    public void closeDriver() {
//        if (driver != null) {
//            driver.quit();
//            System.out.println("Driver quit successfully");
//        }
//    }

//	@Parameters({ "browser", "env", "region" })
//	@BeforeClass
//	public void setup(String browser, String sheetName, String region) throws IOException {
//	    usrdir = System.getProperty("user.dir");
//	    testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
//
//	    // Read Excel Data
//	    FileInputStream fs = new FileInputStream(testdatapath);
//	    XSSFWorkbook workbook = new XSSFWorkbook(fs);
//
//	    // Convert sheetName to lowercase to match Excel sheet names
//	    XSSFSheet sheet = workbook.getSheet(sheetName.toLowerCase());
//
//	    if (sheet == null) {
//	        workbook.close();
//	        fs.close();
//	        throw new IllegalArgumentException("Invalid sheet name: " + sheetName);
//	    }
//
//	    // Loop through the rows to find the matching region
//	    boolean linkFound = false;
//	    for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
//	        String regionName = sheet.getRow(i).getCell(0).toString();
//	        if (regionName.equalsIgnoreCase(region)) {
//	            link = sheet.getRow(i).getCell(1).toString();
//	            linkFound = true;
//	            break;
//	        }
//	    }
//
//	    // If no link is found for the region, throw an error
//	    if (!linkFound) {
//	        workbook.close();
//	        fs.close();
//	        throw new IllegalArgumentException("No URL found for region: " + region);
//	    }
//
//	    workbook.close();
//	    fs.close();
//
//	    // Browser setup
//	    if (browser.equalsIgnoreCase("chrome")) {
//	        driver = new ChromeDriver();
//	    } else if (browser.equalsIgnoreCase("firefox")) {
//	        driver = new FirefoxDriver();
//	    } else if (browser.equalsIgnoreCase("edge")) {
//	        driver = new EdgeDriver();
//	    } else {
//	        throw new IllegalArgumentException("Invalid browser name provided!");
//	    }
//
//	    // Open the URL
//	    driver.get(link);
//	    System.out.println("Navigated to: " + link);
//	}
//	@AfterClass
//  public void closeDriver() {
//    if (driver != null) {
//        driver.quit();
//        System.out.println("Driver quit successfully");
//     }
//  }
//
//}
//	@Parameters({ "browser", "env", "region" })
//	@BeforeClass
//	public void setup(String browser, String sheetName, String region) throws IOException {
//	    usrdir = System.getProperty("user.dir");
//	    testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
//
//	    // Read Excel Data
//	    FileInputStream fs = new FileInputStream(testdatapath);
//	    XSSFWorkbook workbook = new XSSFWorkbook(fs);
//
//	    // Convert sheetName to lowercase to match Excel sheet names
//	    XSSFSheet sheet = workbook.getSheet(sheetName.toLowerCase());
//
//	    if (sheet == null) {
//	        workbook.close();
//	        fs.close();
//	        throw new IllegalArgumentException("Invalid sheet name: " + sheetName);
//	    }
//
//	    // Loop through the rows to find the matching region
//	    boolean linkFound = false;
//	    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//	        String regionName = sheet.getRow(i).getCell(0).toString();
//	        if (regionName.equalsIgnoreCase(region)) {
//	            link = sheet.getRow(i).getCell(1).toString();
//	            linkFound = true;
//	            break;
//	        }
//	    }
//
//	    // If no link is found for the region, throw an error
//	    if (!linkFound) {
//	        workbook.close();
//	        fs.close();
//	        throw new IllegalArgumentException("No URL found for region: " + region);
//	    }
//
//	    workbook.close();
//	    fs.close();
//
//	    // Setting up Proxy
//	    Proxy proxy = new Proxy();
//	    proxy.setHttpProxy("45.22.209.157:8888");
//	    proxy.setSslProxy("45.22.209.157:8888");
//
//	    // Browser setup with proxy
//	    if (browser.equalsIgnoreCase("chrome")) {
//	        ChromeOptions options = new ChromeOptions();
//	        options.setProxy(proxy);
//	        driver = new ChromeDriver(options);
//	    } else if (browser.equalsIgnoreCase("firefox")) {
//	        FirefoxOptions options = new FirefoxOptions();
//	        options.setProxy(proxy);
//	        driver = new FirefoxDriver(options);
//	    } else if (browser.equalsIgnoreCase("edge")) {
//	        EdgeOptions options = new EdgeOptions();
//	        options.setProxy(proxy);
//	        driver = new EdgeDriver(options);
//	    } else {
//	        throw new IllegalArgumentException("Invalid browser name provided!");
//	    }
//
//	    // Open the URL
//	    driver.get(link);
//	    System.out.println("Navigated to: " + link);
//	}
//
//	@AfterClass
//	public void closeDriver() {
//	    if (driver != null) {
//	        driver.quit();
//	        System.out.println("Driver quit successfully");
//	    }
//	}

	@Parameters({ "browser", "env", "region", "version", "platform", "lambdacredentailssheet" })
	@BeforeClass
	public void setup(String browser, String sheetName, String region, String version, String platform,
			String LambdaCredentialsSheet) throws IOException, InterruptedException {
		String hub = "@hub.lambdatest.com/wd/hub";
		usrdir = System.getProperty("user.dir");
		testdatapath = usrdir + "\\src\\test\\resources\\TestData.xlsx";
		this.region = region;

		LambdaCredentials = ExcelUtility.getLambdaTestCredentials(testdatapath, LambdaCredentialsSheet);
		String userName = LambdaCredentials[0];
		String passWord = LambdaCredentials[1];
		System.out.println("LambdaTest Username: " + LambdaCredentials[0]);
		System.out.println("LambdaTest Passkey: " + LambdaCredentials[1]);

		// Fetch link from Excel
		link = ExcelUtility.getLink(testdatapath, sheetName, region);
		if (browser.equalsIgnoreCase("chrome")) {
			// driver = new ChromeDriver();
			// driver.get("chrome://settings/clearBrowserData");
			// Thread.sleep(2000); // Wait for the page to load
			// driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
			String username = userName;
			String accessKey = passWord;

			ChromeOptions chromeOptions = new ChromeOptions();
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", username);
			ltOptions.put("accessKey", accessKey);
			ltOptions.put("project", "IEphase1");
			ltOptions.put("console", true);
			ltOptions.put("terminal", true);
			ltOptions.put("devicelog", true);
			ltOptions.put("w3c", true);

			ltOptions.put("platform", platform);
			ltOptions.put("version", version);
			ltOptions.put("build", "ID:" + LocalDate.now() + "_" + hour + "_" + min);
			ltOptions.put("name", this.getClass().getName());
			ltOptions.put("plugin", "git-testng");
			ltOptions.put("geoLocation", "IN");
			String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
			ltOptions.put("tags", Tags);

			chromeOptions.setCapability("LT:Options", ltOptions);

			try {
				driver = new RemoteWebDriver(
						new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), chromeOptions);
			} catch (MalformedURLException e) {
				System.out.println("Invalid grid URL");
			}
			System.out.println("The driver setup process is completed using BeforeSuite");
		} else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser name provided!");
		}

		// Open the URL
		driver.manage().window().maximize();
		driver.get(link);
		System.out.println("Navigated to: " + link);
		popup();

	}

	@AfterClass
	public void closeDriver() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver quit successfully");
		}
	}

	public void popup() throws InterruptedException {

		if (region.equalsIgnoreCase("US")) {
//			System.out.println("Handling US-specific popup...");
//			Thread.sleep(5000);
//			String mainWindowId = driver.getWindowHandle();
//			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			System.out.println("US Nurture Pop up Handle");
//			String windowIds = driver.getWindowHandle();
//			// for(String windowId : windowIds){
//			driver.switchTo().window(windowIds);
//			String popupText = driver.findElement(By.xpath("//*[@id='isPasted']/span[1]")).getText();
//			System.out.println(popupText);
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//*[@id='om-ugpkop8dbcgry3vdauf7-yesno']/div/button")).click();
//			driver.switchTo().window(mainWindowId);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("document.querySelector('button[title='Close']').click();");
//
//			System.out.println("Nurture popup removed using JavaScript.");
//			//System.out.println("Nurture popup removed using JavaScript.");
//			Thread.sleep(2000);
			System.out.println("Handling US-specific popup...");

			// Wait for the popup to appear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='isPasted']/span[1]")));

			// Get main window ID
			String mainWindowId = driver.getWindowHandle();

			// Retrieve and print popup text
			String popupText = driver.findElement(By.xpath("//*[@id='isPasted']/span[1]")).getText();
			System.out.println("Nurtue popup Text:- "+ popupText);

			// Click the close button on the popup
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='om-ugpkop8dbcgry3vdauf7-yesno']/div/button"))).click();
			System.out.println("Nurture pop up closed");

			// Switch back to main window (only if a new window was opened)
			driver.switchTo().window(mainWindowId);
			Thread.sleep(2000);

			System.out.println("Checking for Exit Popup...");

			if (!driver.findElements(By.cssSelector("#om-u8welaoz8o8bcqac8osu-yesno")).isEmpty()) {
			    System.out.println("Exit Popup detected. Closing it...");
			    
			    // Wait for Exit popup to be visible
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#om-u8welaoz8o8bcqac8osu-yesno")));

			    // Click the Close button
			    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#om-u8welaoz8o8bcqac8osu-yesno button"))).click();
			    System.out.println("Exit Popup closed.");
			} else {
			    System.out.println("No Exit Popup detected. Continuing execution...");
			}



		}

		else if (region.equalsIgnoreCase("CA")) {

			System.out.println("Handling CA region popup...");
			Actions actions = new Actions(driver);
			actions.moveByOffset(10, 10).perform();
			System.out.println("Checking for Exit Popup...");
			Thread.sleep(2000);

			if (!driver.findElements(By.cssSelector("#om-u8welaoz8o8bcqac8osu-yesno")).isEmpty()) {
			    System.out.println("Exit Popup detected. Closing it...");
			    
			    // Wait for Exit popup to be visible
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#om-u8welaoz8o8bcqac8osu-yesno")));

			    // Click the Close button
			    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#om-u8welaoz8o8bcqac8osu-yesno button"))).click();
			    System.out.println("Exit Popup closed.");
			   
			} else {
			    System.out.println("No Exit Popup detected. Continuing execution...");
			}

			


		}

	}
}
