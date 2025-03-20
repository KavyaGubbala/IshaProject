package pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class IE_Home_PageElements {

	WebDriver driver;
	WebDriverWait wait;

	public IE_Home_PageElements(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("WebDriver instance is null in IE_Home_PageElements!");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Login button on top banner
	@FindBy(xpath = "//*[@id='banner-login-button']")
	public static WebElement login_btn;

	// Register Cta on top banner
	@FindBy(xpath = "//a[@id='ieo-register-banner-btn']")
	public static WebElement register_bannerbtn;
	// Register sticky cta
	@FindBy(id = "ieo-register-sticky-btn")
	public static WebElement register_Stickycta;

	@FindBy(xpath = "//div[text()='TAKE CHARGE OF YOUR LIFE ']")
	public static WebElement TakeCharge_Section;
	
	@FindBy(xpath="//div[contains(text(),'Millions of people worldwide')]")
	public static WebElement Overseas_section;

	// Language Switcher
	@FindBy(xpath = "//button[@id='banner-language-switcher']//span[@class='chakra-button__icon css-1hzyiq5']//*[name()='svg']")
	public static WebElement lang_dropdown;
	@FindBy(xpath = "//button[@id='banner-language-switcher']")
	public static WebElement lang_dropdwn_eng;

	// Language options
	@FindBy(xpath = "//button[@id='banner-language-switcher']/div/div/p/a[text()='हिंदी']")
	public static WebElement lang_dropdwn_hi;
	@FindBy(xpath = "//button[@id='banner-language-switcher']/div/div/p/a[text()='தமிழ்']")
	public static WebElement lang_dropdwn_ta;
	@FindBy(xpath = "//button[@id='banner-language-switcher']/div/div/p/a[text()='ಕನ್ನಡ']")
	public static WebElement lang_dropdwn_kn;
	@FindBy(xpath = "//button[@id='banner-language-switcher']/div/div/p/a[text()='తెలుగు']")
	public static WebElement lang_dropdwn_te;
	@FindBy(xpath = "//button[@id='banner-language-switcher']/div/div/p/a[text()='मराठी']")
	public static WebElement lang_dropdwn_mr;
	@FindBy(xpath = "//button[@id='banner-language-switcher']/div/div/p/a[text()='മലയാളം']")
	public static WebElement lang_dropdwn_ml;
	@FindBy(xpath = "//button[@id='banner-language-switcher']/div/div/p/a[text()='বাংলা']")
	public static WebElement lang_dropdwn_bn;

	// overseas language options
	@FindBy(xpath = "//button[@id='banner-language-switcher']//div//a")
	public List<WebElement> overseas_langoptions;
	@FindBy(xpath = "//a[contains(@href, '/uk/en')]")
	public  static WebElement lang_dropdwn_english_UK;
	
	//@FindBy(xpath="//button[@id='banner-language-switcher']")

	@FindBy(xpath = "//a[contains(@href, '/global/fr')]")
	public static WebElement lang_dropdwn_fr;

	@FindBy(xpath = "//a[contains(@href, '/global/de')]")
	public static WebElement lang_dropdwn_de;

	@FindBy(xpath = "//a[contains(@href, '/global/es')]")
	public static WebElement lang_dropdwn_es;

	@FindBy(xpath = "//a[contains(@href, '/global/it')]")
	public static WebElement lang_dropdwn_it;

	@FindBy(xpath = "//a[contains(@href, '/global/ru')]")
	public static WebElement lang_dropdwn_ru;
	@FindBy(xpath = "//a[contains(@href, '/global/zh-tw')]")
	public static WebElement lang_dropdwn_zh_tw;

	@FindBy(xpath = "//a[contains(text(),'简体中文')]")
	public static WebElement lang_dropdwn_zh;

	@FindBy(xpath = "//a[contains(@href, '/global/id')]")
	public static WebElement lang_dropdwn_id;

	@FindBy(xpath = "//a[contains(@href, '/global/ar')]")
	public static WebElement lang_dropdwn_ar;

	// Program Fee section
	@FindBy(xpath = "//*[@id='ieo-program-fees']/div/div/div/h2")
	public static WebElement programFeeHeading;
	@FindBy(xpath = "//div[@id='ieo-program-fees']//div/p/strong[text()='This program is also available in']")
	public static WebElement programFeeDescriptionL1;
	//India 
	@FindBy(xpath = "//*[@id='ieo-program-fees']/div/div[1]/div[1]/div[2]/div/p[text()='Hindi, Tamil, Kannada, Telugu, Marathi, Malayalam, and Bengali.']")
	public static WebElement India_programFeeDescriptionL2;
	//Overseas 
	@FindBy(xpath = "//p[contains(text(),'English, German, French, Italian, Spanish, Russian')]")
	public static WebElement Overseas_global_programFeeDescriptionL2;
	// Price details India
//	@FindBy(xpath = "//*[@id='ieo-program-fees']/div/div[1]/div[2]/div[3]/div[1]/div[text()='INR 6500']")
//	public static WebElement price6500;
//	@FindBy(xpath = "//*[@id='ieo-program-fees']/div/div[1]/div[2]/div[3]/div[2]/div[text()='INR 4000']")
//	public static WebElement price4000;
//	@FindBy(xpath = "//*[@id='ieo-program-fees']/div/div[1]/div[2]/div[3]/div[3]/div/h4[text()='Regional Languages']")
//	public static WebElement regionalLanguagesHeader;
//	@FindBy(xpath = "//*[@id='ieo-program-fees']/div/div[1]/div[2]/div[3]/div[4]/div[text()='INR 3500']")
//	public WebElement price3500;
//	@FindBy(xpath = "//*[@id='ieo-program-fees']/div/div[1]/div[2]/div[3]/div[5]/div[text()='INR 2000']")
//	public static WebElement price2000;
	
	@FindBy(xpath="//div[@id='in-en-org-price']")
	public static WebElement oldPriceLocator ;//need to change xpath 
	@FindBy(xpath="//div[@id='in-en-dis-price']")
	public static WebElement newPriceLocator;
	@FindBy(xpath="(//h4[normalize-space()='Regional Languages'])[1]")
	public static WebElement RegionalLanguagesHeading;
	@FindBy(xpath="//div[@id='in-ver-org-price']")
	public static WebElement oldRegionalPriceLocator;
	@FindBy(xpath="//div[@id='in-ver-dis-price']")
	public static WebElement newRegionalPriceLocator;
	
	//overseas locator
	@FindBy(xpath="//div[contains(@id, 'org-price')]")
	public static WebElement overseasOldPriceLocator;
	@FindBy(xpath="//div[contains(@id, 'dis-price')]")
	public static WebElement overseasNewPriceLocator;
	
	

	// Enroll form langauge switcher
	@FindBy(xpath = "//button[@id='enroll-language-switcher-btn']")
	public static WebElement enroll_LangSwitcherbtn;
	@FindBy(xpath = "//*[@id='enroll-language-switcher-btn']//div/a")
	public List<WebElement> languageOptions;
	@FindBy(xpath = "//*[@id='dubbed-voice-text']")
	public static WebElement enroll_dubbdmsg;
	@FindBy(xpath = "//div[@class='css-1pin21t']")
	public static WebElement enroll_priceText;

	// Contiune button Enroll section
	@FindBy(xpath = "//*[@id=\"ieo-enroll-section\"]/div/div/div[2]/div[1]/a")
	public static WebElement enrollContinueBtn;

	// Enroll form text fields
	@FindBy(xpath = "//div[@class='css-y5vxas']")
	public static WebElement enrollHeading;
	@FindBy(xpath = "//div[@id='ieo-enroll-section']//form/div/div[@role='group']/input[@placeholder='First Name *']")
	public static WebElement enrollFname;
	@FindBy(xpath = "//input[@name='lname']")
	public static WebElement enrollLname;
	@FindBy(xpath = "//div[@id='ieo-enroll-section']//form/div/div[@role='group']/input[@placeholder='Email *']")
	public static WebElement enrollEmail;
	@FindBy(xpath = "//div[@id='ieo-enroll-section']//form/div/div[@role='group']//select[@id='form-country']")
	public static WebElement enrollCountry;
	@FindBy(xpath = "//div[@id='ieo-enroll-section']//form/div/div/div[@role='group']/input[@type='tel']")
	public static WebElement enrollTel;
	@FindBy(xpath = "//*[@id='form-state']")
	public static WebElement enrollState;
	@FindBy(xpath = "//*[@id='ieo-enroll-section']/div/div/div[2]/div[1]/div[3]/form/div[2]/button")
	public static WebElement enrollBtn;

	// Form 2 elements
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/section[1]/div[13]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/label[1]/span[1]")
	public static WebElement whatsappSame_checkbox;
	@FindBy(xpath = "//*[@data-test-id='zip-input' and @placeholder='Postal Code *']")
	public static WebElement zipInput;

	@FindBy(xpath = "//*[@name='sPhone' and @placeholder='WhatsApp Number *']")
	public static WebElement phoneInput;

	@FindBy(xpath = "//*[@data-test-id='address1-input' and @placeholder='Address *']")
	public static WebElement addressInput;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/section[1]/div[13]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[5]/label[1]/span[1]")
	public static WebElement medicalCheckbox;

	@FindBy(xpath = "//*[@data-test-id='receiveMessages-checkbox']")
	public static WebElement receiveMessagesCheckbox;

	@FindBy(xpath = "//*[@data-test-id='age-checkbox']")
	public static WebElement ageCheckbox;

	@FindBy(xpath = "//*[@data-test-id='terms-checkbox']")
	public static WebElement termsCheckbox;

	@FindBy(xpath = "//*[@data-test-id='step2-submit' and text()='Pay Securely']")
	public static WebElement payButton;

	// In person Program links
	@FindBy(xpath = "//a[text()='Attend In Person']")
	public static WebElement attendInpersonLink;

	// Contact Us section
	@FindBy(xpath = "//a[@id='ieo-support-link']")
	public static WebElement supportLink;

	// Actions
	/// Clicking login button
	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(login_btn)).click();
	}

///Clciking Register button
	public void clickRegister() {
		WebElement Registerbtn = wait.until(ExpectedConditions.visibilityOf(register_bannerbtn));
		Registerbtn.click();
		// register_bannerbtn.click();
	}

///Clicking register sticky cta
	public void clickRegisterStickyctaIN() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", TakeCharge_Section);

		// Optional: Add a small pause for better visibility
		try {
			Thread.sleep(1000); // 1-second pause
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Wait for the sticky CTA to become visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(register_Stickycta));
		wait.until(ExpectedConditions.elementToBeClickable(register_Stickycta));

		// Click on the Sticky CTA
		register_Stickycta.click();
	}
	public void clickRegisterStickyctaOverseas() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Overseas_section);

		// Optional: Add a small pause for better visibility
		try {
			Thread.sleep(1000); // 1-second pause
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Wait for the sticky CTA to become visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(register_Stickycta));
		wait.until(ExpectedConditions.elementToBeClickable(register_Stickycta));

		// Click on the Sticky CTA
		register_Stickycta.click();
	}

///Clicking top banner language switcher
	public void openLanguageDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(lang_dropdown)).click();
		// lang_dropdwn_eng.click();
	}

	// Language selection using switch case
	public void selectLanguage(String language) {
		// wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_eng));
		// lang_dropdwn_eng.click();
		// Actions actions = new Actions(driver);
		// WebElement dropdown = driver.findElement(By.id("yourDropdownId"));
		// actions.moveToElement(lang_dropdwn_eng).click().perform();

		// lang_dropdown.click();
		switch (language.toLowerCase()) {
		case "hindi":
			wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_hi)).click();
			break;
		case "tamil":
			wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_ta)).click();
			break;
		case "kannada":
			wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_kn)).click();
			break;
		case "telugu":
			wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_te)).click();
			break;
		case "marathi":
			wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_mr)).click();
			break;
		case "malayalam":
			wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_ml)).click();
			break;
		case "bengali":
			wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_bn)).click();
			break;
		default:
			System.out.println("Invalid language: " + language);
		}
	}

	public void clickOverseasLanguageSwitcher() {
		wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_eng)).click();
	}

	// overseas top banner language switcher
	public void overseas_selectLanguage(String languageName) {
		// Actions action=new Actions(driver);
		// action.scrollToElement(enrollHeading).perform();;
		//clickOverseasLanguageSwitcher(); // Open the dropdown

		switch (languageName.toLowerCase()) {
		case "english":
			wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_english_UK)).click();
			break;
		case "french":
			wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_fr)).click();
			break;
		case "german":
			wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_de)).click();
			break;
		case "spanish":
			wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_es)).click();
			break;
		case "italian":
			wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_it)).click();
			break;
		case "russian":
			wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_ru)).click();
			break;
		default:
			System.out.println("Invalid language: " + languageName);
		}

	}
	

	// global regions
	public void global_selectLanguage(String languageName) {
	    // Open the language dropdown
		//clickOverseasLanguageSwitcher(); 

	    switch (languageName.toLowerCase()) {
	        case "english":
	            wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_eng)).click();
	            break;
	        case "french":
	            wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_fr)).click();
	            break;
	        case "german":
	            wait.until(ExpectedConditions.visibilityOf(lang_dropdwn_de)).click();
	            break;
	        case "spanish":
	            wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_es)).click();
	            break;
	        case "italian":
	            wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_it)).click();
	            break;
	        case "russian":
	            wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_ru)).click();
	            break;
	        case "traditionalchinese":
	            wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_zh_tw)).click();
	            break;
	        case "simplifiedchinese":
	            wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_zh)).click();
	            break;
	        case "bahasaindonesia":
	            wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_id)).click();
	            break;
	        case "arabic":
	            wait.until(ExpectedConditions.elementToBeClickable(lang_dropdwn_ar)).click();
	            break;
	        default:
	            System.out.println("Invalid language: " + languageName);
	    }
	}

	/// Program Fee section headings
	// Method to get program fee heading text
	public String getProgramFeeHeading() {
		//Actions actions = new Actions(driver);
		//actions.scrollToElement(programFeeHeading);
		return programFeeHeading.getText();
	}

	// Scroll to program fee section
	public void scrollToProgramFeeSection() {
		Actions actions = new Actions(driver);
		actions.scrollToElement(programFeeHeading);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", programFeeHeading);
	}

	// Verify all elements are displayed
//	public boolean verifyIndiaProgramFeeElements() {
//		return programFeeHeading.isDisplayed() && programFeeDescriptionL1.isDisplayed()
//				&& India_programFeeDescriptionL2.isDisplayed() && price6500.isDisplayed() && price4000.isDisplayed()
//				&& regionalLanguagesHeader.isDisplayed() && price3500.isDisplayed() && price2000.isDisplayed();
//	}

	/// Enroll form language switcher actions actions

	// Clicks the Language Switcher dropdown
	public void clickLanguageSwitcher() {
		wait.until(ExpectedConditions.elementToBeClickable(enroll_LangSwitcherbtn)).click();
	}

	// Selects a language from the dropdown
	public void enroll_selectLanguage(String languageName) {
		Actions action = new Actions(driver);
		// action.scrollToElement(enrollHeading).perform();;
		clickLanguageSwitcher(); // Open the dropdown

		for (WebElement lang : languageOptions) {
			if (lang.getText().trim().equalsIgnoreCase(languageName)) {
				lang.click();
				break;
			}
		}
	}

	// Verifies if the Dubbed Message is displayed
	public boolean isDubbedMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(enroll_dubbdmsg)).isDisplayed();
	}

	// Gets the price text after changing the language
	public String getEnrollPrice() {
		return wait.until(ExpectedConditions.visibilityOf(enroll_priceText)).getText();
	}

	/// Continue button actions
	public void clickContinueWith() {
		enrollContinueBtn.click();
	}

	// Get the current URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle_URL() {
		return driver.getTitle();
	}

	// Enroll form text fields actions
	public String enrollHeading_getText() {
		return enrollHeading.getText();
	}

	public void enterFirstName(String firstName) {

		WebElement firstNameField = wait.until(ExpectedConditions.visibilityOf(enrollFname)); // Use the correct locator
																								// here
		// firstNameField.clear(); // Clear the field before entering text
		firstNameField.sendKeys(firstName);
		// System.out.println("Entered First Name: " + firstName);
	}

	public void enterLastName(String lname) {
		WebElement lastname = wait.until(ExpectedConditions.visibilityOf(enrollLname));
		// lastname.clear();

		lastname.sendKeys(lname);
	}

	public void enterEmail(String emailText) {
		WebElement email = wait.until(ExpectedConditions.visibilityOf(enrollEmail));
		email.sendKeys(emailText);
	}

	// random email
	public String generateRandomEmail() {
		return "test" + new Random().nextInt(10000) + "@yopmail.com";
	}

	public void enterRandomEmail() {
		enterEmail(generateRandomEmail());
	}

	public void selectCountry(String country) {
		WebElement Enrollcountry = wait.until(ExpectedConditions.elementToBeClickable(enrollCountry));
		Enrollcountry.sendKeys(country);
	}

	public void enterPhoneNumber(String phone) {
		WebElement phonenumber = wait.until(ExpectedConditions.elementToBeClickable(enrollTel));
		phonenumber.sendKeys(phone);
	}

	public void selectState(String state) {

		enrollState.sendKeys(state);
	}

	public void clickEnrollButton() {
		WebElement Enrollbutton = wait.until(ExpectedConditions.elementToBeClickable(enrollBtn));
		Enrollbutton.click();
	}

	// Form2 actions
	public void enterZipCode(String zipCode) {
		WebElement zipElement = wait.until(ExpectedConditions.visibilityOf(zipInput));
		zipElement.sendKeys(zipCode);
		// zipElement.sendKeys(Keys.ENTER);
		// zipElement.sendKeys(Keys.TAB);
	}

	public void whatsAppSame() {
		WebElement whatsAppSame = wait.until(ExpectedConditions.elementToBeClickable(whatsappSame_checkbox));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whatsAppSame);
		whatsAppSame.click();
		// whatsAppSame.click();
	}

	public void enterPhoneNumber_form2(String phoneNumber) {
		WebElement phoneElement = wait.until(ExpectedConditions.visibilityOf(phoneInput));
		phoneElement.sendKeys(phoneNumber);
	}

	public void enterAddress(String address) {
		WebElement addressElement = wait.until(ExpectedConditions.visibilityOf(addressInput));
		addressElement.sendKeys(address);
	}

	public void clickMedicalCheckbox() {
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", medicalCheckbox);
		// WebElement medicalCheckboxElement =
		// wait.until(ExpectedConditions.visibilityOf(medicalCheckbox));
		// medicalCheckboxElement.click();
		Actions actions = new Actions(driver);
		actions.scrollToElement(medicalCheckbox).perform();
		medicalCheckbox.click();
	}

	public void clickReceiveMessagesCheckbox() {
		// WebElement receiveMessagesCheckboxElement =
		// wait.until(ExpectedConditions.elementToBeClickable(receiveMessagesCheckbox));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// receiveMessagesCheckboxElement);
		// receiveMessagesCheckboxElement.click();
		Actions actions = new Actions(driver);
		actions.scrollToElement(receiveMessagesCheckbox).perform();
		receiveMessagesCheckbox.click();
	}

	public void clickAgeCheckbox() {
		// WebElement ageCheckboxElement =
		// wait.until(ExpectedConditions.elementToBeClickable(ageCheckbox));
		// ageCheckboxElement.click();
		Actions actions = new Actions(driver);
		actions.scrollToElement(ageCheckbox).perform();
		ageCheckbox.click();
	}

	public void clickTermsCheckbox() {
		// WebElement termsCheckboxElement =
		// wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// termsCheckboxElement);
		// termsCheckboxElement.click();
		Actions actions = new Actions(driver);
		actions.scrollToElement(termsCheckbox).perform();
		termsCheckbox.click();

	}

	public void clickPayButton() {
		// WebElement payButtonElement =
		// wait.until(ExpectedConditions.elementToBeClickable(payButton));

		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// payButtonElement);
		// payButtonElement.click();
		Actions actions = new Actions(driver);
		actions.scrollToElement(payButton).perform();
		payButton.click();
	}

	/// Attend In person action
	public void clickAttendInPerson() {
		Actions action = new Actions(driver);
		action.scrollToElement(attendInpersonLink).perform();
		attendInpersonLink.click();

	}

	// Contact us actions
	public void clickSupportLink() {

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("document.querySelector('.css-jfezgn').style.display='none';");
		// (Replace .cookie-banner-class with the actual class of the cookie banner.)
		Actions action = new Actions(driver);

		wait.until(ExpectedConditions.visibilityOf(supportLink));
		action.scrollToElement(supportLink).perform();
		supportLink.click();
	}

}
