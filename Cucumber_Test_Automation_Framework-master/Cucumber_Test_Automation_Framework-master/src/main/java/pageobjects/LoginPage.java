package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class LoginPage {
	
	WebElement element;
	WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='email@email.com']")
	private WebElement enterEmail;
	
	@FindBy(xpath = "//button[text()=' Log in ']")
	private WebElement clickOnContinue;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement enterPassword;
	
	@FindBy(xpath = "//span[text()='Log in']")
	private WebElement logIn;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private void enterEmail(){
		enterEmail.clear();
		enterEmail.sendKeys(FileReaderManager.getInstance().getConfigReader().getLoginEmail());
	}
	
	private void clickOnContinue(){
		clickOnContinue.click();
	}
	
	private void enterPassword(){
		enterPassword.clear();
		enterPassword.sendKeys(FileReaderManager.getInstance().getConfigReader().getLoginPassword());
	}
	
	public void clickOnLogIn(){
		logIn.click();
	}
	
	public void loginToCheckOut(){
		enterEmail();
		enterPassword();
		clickOnContinue();
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,30);
		 * wait.until(ExpectedConditions.invisibilityOf(clickOnContinue));
		 */
		

		
		
	}

}
