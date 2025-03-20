package pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Overseas_HomePage_Elements {
	WebDriver driver;
	WebDriverWait wait;

	public Overseas_HomePage_Elements(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("WebDriver instance is null in IE_Home_PageElements!");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@value='gift']")
	public static WebElement TopBanner_Gift_button;

	@FindBy(xpath = "//a[@id='banner-login-button']")
	public static WebElement TopBanner_Login_button;
	@FindBy(xpath = "//a[@id='ieo-register-banner-btn']")
	public static WebElement TopBanner_Register_button;

	// Enroll form Elements
	@FindBy(xpath = "//input[@id='form-fname-input']")
	public static WebElement enroll_first_Name;
	@FindBy(xpath = "//input[@id='form-lname-input']")
	public static WebElement enroll_last_Name;
	@FindBy(xpath = "//input[@id='form-email-input']")
	public static WebElement enroll_Email;
	@FindBy(xpath = "//select[@id='form-pCountry']")
	public static WebElement countryCode;
	@FindBy(xpath = "//input[@name='pPhone']")
	public static WebElement enroll_Phone;
	@FindBy(xpath = "//select[@id='form-country']")
	public static WebElement enroll_country;

	@FindBy(xpath = "//button[@data-test-id='step1-submit']")
	public static WebElement enroll_button;

	// Form2 Elements
	@FindBy(xpath = "//input[@data-test-id='zip-input']")
	public static WebElement PostalCode;
	@FindBy(xpath = "//select[@id='form-state']")
	public static WebElement select_State;
	@FindBy(xpath = "//input[@data-test-id='city-input']")
	public static WebElement enter_city;
	@FindBy(xpath = "//input[@data-test-id='address1-input']")
	public static WebElement enter_Address;
	// better to have id's
	//@FindBy(css = "div[class='tc-content css-9ymd22'] p:nth-child(10)")
//	public static WebElement Terms_Conditons_first_Contentbox;
//	@FindBy(xpath = "//div[7]//div[2]//label[1]//span[1]")
//	public static WebElement Disclaimer_WaiverCheckbox;
//	@FindBy(xpath = "//strong[contains(text(),'I HAVE READ THIS AGREEMENT, FULLY UNDERSTAND ITS T')]")
//	public static WebElement Terms_Conditions_second_Contentbox;
//	@FindBy(xpath = "(//span[@class='chakra-checkbox__control css-1utwllg'])[2]")
//	public static WebElement liabilityWavierCheckbox;
	
	@FindBy(xpath="//*[@id='ieo-enroll-section']/div/div/div[2]/div[1]/form/div/div[7]/div[2]/label/span[1]")
	public static WebElement first_checkbox;
	
	@FindBy(xpath="//div[contains(@class,'tc-content')]/p[contains(text(),'jury trial for any Claim that I may assert')]")
	public static WebElement agreement_container;
	
	@FindBy(xpath="//div[@id='ieo-enroll-section']/div/div/div[2]/div[1]/form/div/div[10]/div[2]/label/span[1]")
	public static WebElement second_checkbox;
	@FindBy(xpath="//div[contains(@class,'tc-content')]/p[contains(text(),'other participants in Isha Events.')]")
	public static WebElement second_agreement_container;
	
	@FindBy(xpath = "//label[@data-test-id='terms-checkbox']")
	public static WebElement age_Checkbox;
	@FindBy(xpath = "//label[@data-test-id='privacy-checkbox']")
	public static WebElement privacy_Checkbox;

	@FindBy(xpath = "//button[@data-test-id='step2-submit']")
	public static WebElement pay_Securely_button;

//	public void popup() {
//		// overseas
//		Actions actions = new Actions(driver);
//		actions.moveByOffset(10, 10).perform();
//		WebElement popup = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//div[@class='yabucoa-c-canvas Campaign__canvas']"))); // Adjust
//																												// selector
//
//		WebElement closeButton = popup.findElement(By.xpath("//button[@title='Close']"));
//		closeButton.click();
//
//	}

	public void click_TopBanner_Gift_button() {
		TopBanner_Gift_button.click();
	}

	public void click_TopBanner_Login_button() {
		TopBanner_Login_button.click();
	}

	public void click_TopBanner_Register_button() {
		TopBanner_Register_button.click();
	}

	public void enterFirstName(String firstName) {

		// WebElement firstNameField =
		// wait.until(ExpectedConditions.visibilityOf(enroll_first_Name));

		// firstNameField.clear(); // Clear the field before entering text
		// firstNameField.sendKeys(firstName);
		// System.out.println("Entered First Name: " + firstName);

		Actions actions = new Actions(driver);
		actions.scrollToElement(enroll_first_Name).perform();
		enroll_first_Name.sendKeys(firstName);

	}

	public void enterLastName(String lname) {
		WebElement lastname = wait.until(ExpectedConditions.visibilityOf(enroll_last_Name));
		// lastname.clear();

		lastname.sendKeys(lname);
	}

	public void enterEmail(String emailText) {
		WebElement email = wait.until(ExpectedConditions.visibilityOf(enroll_Email));
		email.sendKeys(emailText);
	}

	// random email
	public String generateRandomEmail() {
		return "test" + new Random().nextInt(10000) + "Sri" + "@yopmail.com";
	}

	public void enterRandomEmail() {
		enterEmail(generateRandomEmail());
	}

	public void enterPhoneNumber(String phone) {
		WebElement phonenumber = wait.until(ExpectedConditions.elementToBeClickable(enroll_Phone));
		phonenumber.sendKeys(phone);
	}

	public void enterCountry(String country) {
		enroll_country.click();
		Select select_country = new Select(enroll_country);
		List<WebElement> options1 = select_country.getOptions();
		// System.out.println(options);
		boolean stateFound = false;

		// Step 4: Loop through options and check if the state exists
		for (WebElement option : options1) {
			if (option.getText().trim().equals(country)) {
				select_country.selectByVisibleText(country);
				System.out.println("Selected State: " + country);
				stateFound = true;
				break;
			}
		}

		// Step 5: Handle case where state is not found
		if (!stateFound) {
			System.out.println("State not found in dropdown: " + country);
		}

	}

	public void clickEnroll() {
		// WebElement Enrollbutton =
		// wait.until(ExpectedConditions.elementToBeClickable(enroll_button));
		// Enrollbutton.click();
		Actions actions = new Actions(driver);
		actions.scrollToElement(enroll_button).perform();
		enroll_button.click();
	}

	// Form 2 actions
	public void PostalCode(String postalcode) {
		wait.until(ExpectedConditions.visibilityOf(PostalCode));
		PostalCode.sendKeys(postalcode);
	}

	public void SelectState(String StateName) {
		select_State.click();
		Select selectstate = new Select(select_State);
		List<WebElement> options = selectstate.getOptions();
		System.out.println(options);
		boolean stateFound = false;

		// Step 4: Loop through options and check if the state exists
		for (WebElement option : options) {
			if (option.getText().trim().equals(StateName)) {
				selectstate.selectByVisibleText(StateName);
				System.out.println("Selected State: " + StateName);
				stateFound = true;
				break;
			}
		}

		// Step 5: Handle case where state is not found
		if (!stateFound) {
			System.out.println("State not found in dropdown: " + StateName);
		}
//		switch (StateName.toLowerCase()) {
//		case "alberta":
//			select.selectByVisibleText("Alberta");
//			break;
//		case "british columbia":
//			select.selectByVisibleText("British Columbia");
//			break;
//		case "manitoba":
//			select.selectByVisibleText("Manitoba");
//			break;
//		case "new brunswick":
//			select.selectByVisibleText("New Brunswick");
//			break;
//		case "newfoundland and labrador":
//			select.selectByVisibleText("Newfoundland and Labrador");
//			break;
//		case "northwest territories":
//			select.selectByVisibleText("Northwest Territories");
//			break;
//		case "nova scotia":
//			select.selectByVisibleText("Nova Scotia");
//			break;
//		case "nunavut":
//			select.selectByVisibleText("Nunavut");
//			break;
//		case "ontario":
//			select.selectByVisibleText("Ontario");
//			break;
//		case "prince edward island":
//			select.selectByVisibleText("Prince Edward Island");
//			break;
//		case "quebec":
//			select.selectByVisibleText("Quebec");
//			break;
//		case "saskatchewan":
//			select.selectByVisibleText("Saskatchewan");
//			break;
//		case "yukon":
//			select.selectByVisibleText("Yukon");
//			break;
//		///US cities
//		
//		
//		default:
//			System.out.println("State not found in dropdown: " + StateName);
//		}
	}

	public void enterCity(String city) {
		wait.until(ExpectedConditions.visibilityOf(enter_city));
		enter_city.sendKeys(city);
	}

	public void enterAddress(String address) {
		wait.until(ExpectedConditions.visibilityOf(enter_Address));
		enter_Address.sendKeys(address);
	}

	public void click_firstCheckbox() throws InterruptedException {
		Actions actions = new Actions(driver);
////		actions.scrollToElement(Terms_Conditons_first_Contentbox);
//		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//		//		Terms_Conditons_first_Contentbox);
//
//		wait.until(ExpectedConditions.elementToBeClickable(Disclaimer_WaiverCheckbox));
//		//actions.scrollToElement(Disclaimer_WaiverCheckbox);
//		Thread.sleep(2000);
//		Disclaimer_WaiverCheckbox.click();
		String isDisabled = first_checkbox.getAttribute("data-disabled");
	    System.out.println("Before clicking agreement, checkbox disabled: " + isDisabled);
	    actions.moveToElement(agreement_container).click().perform();
	    System.out.println("Clicked on agreement section");
	    do {
	        actions.sendKeys(Keys.PAGE_DOWN).perform();
	        System.out.println("Performed page down");

	        try {
	            Thread.sleep(2000); // Small delay to allow content to load properly
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        isDisabled = first_checkbox.getAttribute("data-disabled");
	        System.out.println("After scrolling, checkbox disabled: " + isDisabled);

	    } while (isDisabled != null);  // Keep scrolling until the checkbox is enabled

	    // Click the checkbox once it's enabled
	    //actions.scrollToElement(pay_Securely_button);
	    //Thread.sleep(2000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", first_checkbox);
	    //first_checkbox.click();
	    System.out.println("Clicked on checkbox successfully");

		
	}

	public void click_secondCheckbox() throws InterruptedException {
		Actions actions = new Actions(driver);
//		actions.scrollToElement(Terms_Conditions_second_Contentbox);
//		wait.until(ExpectedConditions.elementToBeClickable(liabilityWavierCheckbox));
//		liabilityWavierCheckbox.click();
		String isDisabled = second_checkbox.getAttribute("data-disabled");
	    System.out.println("Before clicking agreement, checkbox disabled: " + isDisabled);

	   // Actions actions = new Actions(driver);
	    actions.moveToElement(second_agreement_container).click().perform();
	    System.out.println("Clicked on agreement section");

	    do {
	        actions.sendKeys(Keys.PAGE_DOWN).perform();
	        System.out.println("Performed PAGE_DOWN");

	        try {
	            Thread.sleep(2000); // Small delay to allow content to load properly
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        isDisabled = second_checkbox.getAttribute("data-disabled");
	        System.out.println("After scrolling, checkbox disabled: " + isDisabled);

	    } while (isDisabled != null); // Continue scrolling until the checkbox is enabled

	    // Click the checkbox using JavaScriptExecutor
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", second_checkbox);
	    System.out.println("Clicked on checkbox successfully");

	}

	public void click_terms_Checkbox() {
		Actions actions = new Actions(driver);
		actions.scrollToElement(age_Checkbox).build().perform();
		// wait.until(ExpectedConditions.elementToBeClickable(terms_Checkbox));
		age_Checkbox.click();
	}

	public void click_privacy_Checkbox() {
		Actions actions = new Actions(driver);
		actions.scrollToElement(privacy_Checkbox).build().perform();
		// wait.until(ExpectedConditions.elementToBeClickable(privacy_Checkbox));
		privacy_Checkbox.click();
	}

	public void click_PaySecurely() {
		Actions actions = new Actions(driver);
		actions.scrollToElement(pay_Securely_button).build().perform();
		// wait.until(ExpectedConditions.elementToBeClickable(pay_Securely_button));
		pay_Securely_button.click();
	}

}
