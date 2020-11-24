package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

	WebDriver driver;

	@FindBy(xpath = "//div[contains(@class, 'basket-total')]")
	private WebElement addToCart;

	@FindBy(xpath = "//button[@data-ref='basket-continue-flow__check-out']")
	private WebElement checkOut;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//select[@name='phoneNumberCountry']")
	private WebElement mobileCountry;

	@FindBy(xpath = "//select[@name='phoneNumberCountry']//option[normalize-space()='Austria']")
	private WebElement mobileCountryValue;

	@FindBy(xpath = "//div[@class='contact-details__inputs-wrapper ng-star-inserted']//ry-input-d[@formcontrolname='phoneNumber']//input")
	private WebElement mobileNo;

	// @FindBy(xpath = "//input[@id='insurance-opt-in']")
	@FindBy(xpath = "//body/app-root[1]/ng-component[1]/ry-spinner[1]/div[1]/payment-form[1]/form[1]/div[2]/insurance[1]/div[1]/div[3]/div[1]/ry-checkbox[1]/label[1]/div[1]/div[1]")
	private WebElement insurance;

	@FindBy(xpath = "//ry-input-d[@formcontrolname='accountNumber']//input")
	private WebElement cardDetails;

	@FindBy(xpath = "//span[normalize-space()='Month']")
	private WebElement month;

	@FindBy(xpath = "//div[normalize-space()='February']")
	private WebElement monthValue;
	/*
	 * @FindBy(xpath = "//div[normalize-space()='October']") private WebElement
	 * monthValue;
	 */
	@FindBy(xpath = "//span[normalize-space()='Year']")
	private WebElement year;

	@FindBy(xpath = "//div[normalize-space()='2021']")
	private WebElement yearValue;
	/*
	 * @FindBy(xpath = "//select[@name='expiryYear']") private WebElement yearValue;
	 */
	@FindBy(xpath = "//input[@placeholder='CVV']")
	private WebElement cvv;

	@FindBy(xpath = "//ry-input-d[@formcontrolname='accountName']//input")
	private WebElement cardHolderName;

	@FindBy(xpath = "//ry-input-d[@formcontrolname='line1']//input")
	private WebElement address;

	@FindBy(xpath = "//ry-input-d[@formcontrolname='city']//input")
	private WebElement city;

	@FindBy(xpath = "//ry-input-d[@formcontrolname='postcode']//input")
	private WebElement zip;


	@FindBy(xpath = "//ry-autocomplete[@formcontrolname='country']//input")
	private WebElement country;

	@FindBy(xpath = "//button[@class='pay-button ry-button--gradient-yellow']")
	private WebElement payNow;

	// @FindBy(xpath = "//input[@id='termsAndConditions']")

	@FindBy(xpath = "//label[@for='termsAndConditions']//div[@class='_background']")
	private WebElement terms;

	@FindBy(xpath = "//ry-dropdown[@formcontrolname='foreignCurrencyCode']/div[2]")
	private WebElement currency;

	@FindBy(xpath = "//ry-alert[@data-ref='payment-methods__error-message']//div[@class='alert__wrapper ng-star-inserted']/div")
	private WebElement alert;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addTocart() {
		try {
			Thread.sleep(1000);
			System.out.println("Inside Add to cart");
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOf(continueButton));
			continueButton.click();
			/*
			 * Thread.sleep(2000); addToCart.sendKeys(Keys.ENTER);
			 */
			Thread.sleep(2000);
			// WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOf(addToCart));
			addToCart.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkOut() {
		try {
			Thread.sleep(1000);
			System.out.println("Inside checkout");
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOf(checkOut));
			checkOut.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectContinue() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(continueButton));
		continueButton.click();
	}

	public void enterContactDetails() {
		// TODO Auto-generated method stub
		{

			try {

				Thread.sleep(3000);
				/*
				 * WebDriverWait wait = new WebDriverWait(driver,100);
				 * wait.until(ExpectedConditions.visibilityOf(mobileCountry));
				 * mobileCountry.click();
				 * 
				 * wait.until(ExpectedConditions.visibilityOf(mobileCountryValue));
				 * mobileCountryValue.click();
				 */

				//System.out.println("With senkeys");

				WebDriverWait wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOf(insurance));
				insurance.click();
				wait.until(ExpectedConditions.visibilityOf(mobileNo));
				mobileNo.sendKeys("894442603");
				wait.until(ExpectedConditions.visibilityOf(insurance));
				insurance.click();
				// System.out.println("With Javscript");
				// mobileNo.clear();
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].value='894442603'", mobileNo);

				wait.until(ExpectedConditions.visibilityOf(insurance));
				insurance.click();
				jse.executeScript("window.scrollBy(0,250)", "");
				wait.until(ExpectedConditions.visibilityOf(cardDetails));
				jse.executeScript("arguments[0].value='5555555555555557';", cardDetails);

				wait.until(ExpectedConditions.visibilityOf(month));
				month.click();

				wait.until(ExpectedConditions.visibilityOf(monthValue));
				monthValue.click();

				wait.until(ExpectedConditions.visibilityOf(year));
				year.click();

				wait.until(ExpectedConditions.visibilityOf(yearValue));
				yearValue.click();

				/*
				 * Select se= new Select(month); se.selectByValue("10");
				 * 
				 * Select se1= new Select(year); se1.selectByValue("2020");
				 */

				wait.until(ExpectedConditions.visibilityOf(cvv));
				cvv.sendKeys("123");

				wait.until(ExpectedConditions.visibilityOf(cardHolderName));
				cardHolderName.sendKeys("Mathew Jose");

				wait.until(ExpectedConditions.visibilityOf(address));
				address.sendKeys("ADDRESS 1");
				wait.until(ExpectedConditions.visibilityOf(city));
				city.sendKeys("CITY 1");
                
				wait.until(ExpectedConditions.visibilityOf(country));
				//Select objSelect = new Select(country);
				//objSelect.selectByVisibleText("India");
				country.click();
				country.sendKeys(Keys.ENTER);
				Thread.sleep(500);
				Thread.sleep(500);
				wait.until(ExpectedConditions.visibilityOf(zip));
				zip.sendKeys("686508");
				
				country.sendKeys(Keys.ENTER);
				Thread.sleep(500);
				wait.until(ExpectedConditions.visibilityOf(terms));
				terms.click();
				
				/*
				 * wait.until(ExpectedConditions.visibilityOf(currency)); currency.click();
				 * Thread.sleep(500); currency.sendKeys(Keys.ENTER); Thread.sleep(500);
				 */
				jse.executeScript("window.scrollBy(0,100)", "");
				wait.until(ExpectedConditions.visibilityOf(payNow));
				payNow.click();

				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOf(alert));
				String alertMsg = alert.getText();

				if (alertMsg != null) {
					System.out.println("Transactiontion failed");

				}

				else {
					System.out.println("Transaction passed");
				}

			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
