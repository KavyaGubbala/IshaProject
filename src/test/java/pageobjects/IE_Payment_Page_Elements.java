package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IE_Payment_Page_Elements {
	WebDriver driver;
	WebDriverWait wait;

	public IE_Payment_Page_Elements(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("WebDriver instance is null in IE_Payment_Page_Elements");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id='payment-options']//p[text()='Net Banking']")
	public static WebElement Payment_type_selection;
	
	@FindBy(xpath="//*[@id='net-banking-list-TESTPGNB-pop']//span[text()='Test bank']")
	public static WebElement Select_Test_Bank;
	
	@FindBy(xpath="//*[@id='net-banking-list-TESTPGNB-pop']//button[text()='PROCEED']")
	public static WebElement click_proceed;
	
	@FindBy(xpath="//*[@id='username' and @placeholder='Enter payu as username']")
	public static WebElement Enter_Username;
	
	@FindBy(xpath="//*[@id='password' and @placeholder='Enter payu as password']")
	public static WebElement Enter_password;
	
	@FindBy(xpath="//*[@id='CredForm']/input[@type='submit']")
	public static WebElement click_Submit;
	
	@FindBy(xpath="//*[@name='authenticate' and @value='Simulate Success Response']")
	public static WebElement simulate_Success_response_button;
	
	@FindBy(xpath="//input[@id='failure']")
	public static WebElement simulate_Failure_response_button;
	
	@FindBy(xpath="//*[@id='ieo-enroll-section']/div/div/div[1]/div/div[2]/h2[text()='Complete']")
	public static WebElement registration_Complete_Text;
	
	//Failure Response
	@FindBy(xpath="//h2[text()='Payment Failed']")
	public static WebElement failure_text;
	
	//In progress response
	@FindBy(xpath="//p[text()='In progress']")
	public static WebElement In_Progress_text;
	
	
	
	//Actions
	
	public void Select_payment_type() {
		WebElement payment_Type=wait.until(ExpectedConditions.elementToBeClickable(Payment_type_selection));
		payment_Type.click();
	}
	public void Select_Test_Bank() {
		WebElement Select_TestBank=wait.until(ExpectedConditions.visibilityOf(Select_Test_Bank));
		Select_TestBank.click();
	}
	public void click_Proceed_button() {
		WebElement click_Proceed=wait.until(ExpectedConditions.visibilityOf(click_proceed));
		click_Proceed.click();
	}
	public void Enter_User_name(String Bank_Username) {
		WebElement enter_Username=wait.until(ExpectedConditions.visibilityOf(Enter_Username));
		enter_Username.sendKeys(Bank_Username);
	}
	public void Enter_Password_(String Bank_Password) {
//		WebElement enter_Password=wait.until(ExpectedConditions.visibilityOf(Enter_password));
//		enter_Password.sendKeys(Bank_Password);
		Enter_password.sendKeys(Bank_Password);
	}
	public void clickSubmit() {
		click_Submit.click();
	}
	//simulate_success_response_button
	public void Simulate_success_Response() {
		wait.until(ExpectedConditions.visibilityOf(simulate_Success_response_button));
		simulate_Success_response_button.click();
	}
	//simulate_Failure_response_button
	public void Simulate_failure_Response() {
		wait.until(ExpectedConditions.visibilityOf(simulate_Failure_response_button));
		simulate_Failure_response_button.click();
	}
	public void Complete_Payment_Response() {
		//wait.until(ExpectedConditions.stalenessOf(registration_Complete_Text));
		wait.until(ExpectedConditions.visibilityOf(registration_Complete_Text));
		System.out.println("Payment Success");
		System.out.println("Registration: " + registration_Complete_Text.getText());
	}
	public void Failure_Payment_Response() {
		wait.until(ExpectedConditions.visibilityOf(failure_text));
		System.out.println("Registration: " + failure_text.getText());
	}
	public void In_Progress_Response() {
		wait.until(ExpectedConditions.visibilityOf(In_Progress_text));
		System.out.println("Registration: " + In_Progress_text.getText());
	}
	
	
	

}
