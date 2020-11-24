package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductsPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//div[@class='price-wrapper']")
	private WebElement ticket;
	
	@FindBy(xpath = "//span[@class='fare-card__button-text ng-star-inserted']")
	private WebElement fare;
	
	@FindBy(xpath = "//div[@data-ref='pax-details__ADT-0']//button[@class='dropdown__toggle b2']")
	private WebElement titleAdult1;
	
	
	@FindBy(xpath = "//input[@id='formState.passengers.ADT-0.name']")
	private WebElement firstNameAdult1;
	
	
	@FindBy(xpath = "//input[@id='formState.passengers.ADT-0.surname']")
	private WebElement LastNameAdult1;
	
	
	
	@FindBy(xpath = "//*[@id='title-0-error-message']/div[2]/button")
	private WebElement titleAdult2;
	
	
	@FindBy(xpath = "//input[@id='formState.passengers.ADT-1.name']")
	private WebElement firstNameAdult2;
	
	
	@FindBy(xpath = "//input[@id='formState.passengers.ADT-1.surname']")
	private WebElement LastNameAdult2;
	
	
	@FindBy(xpath = "//input[@id='formState.passengers.CHD-0.name']")
	private WebElement firstNameChild1;
	
	
	@FindBy(xpath = "//input[@id='formState.passengers.CHD-0.surname']")
	private WebElement LastNameChild1;
	
	@FindBy(xpath = "//div[@class='dropdown-item__label b2'][normalize-space()='Mr']")
	private WebElement MrLabel;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	private WebElement continueButton;

	
	@FindBy(xpath = "//div[@class='seats-modal__body']")
	private WebElement infoSection;
	
	@FindBy(xpath = "//button[normalize-space()='Okay, got it.']")
	private WebElement infoButton;
	
	@FindBy(xpath = "//div[@class='seatmap__seatrow seatmap__seatrow--33 ng-star-inserted']//button[1]")
	private WebElement seat1;
	
	@FindBy(xpath = "//div[@class='seatmap__seatrow seatmap__seatrow--33 ng-star-inserted']//button[2]")
	private WebElement seat2;
	
	@FindBy(xpath = "//div[@class='seatmap__seatrow seatmap__seatrow--33 ng-star-inserted']//button[3]")
	private WebElement seat3;
	
	@FindBy(xpath = "//button[normalize-space()='No, thanks']")
	private WebElement noThanks;
	
	
	@FindBy(xpath = "//label[@for='ry-radio-button--0']")
	private WebElement baggage;
	
	public ProductsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectTicket() {
		// TODO Auto-generated method stub

		 WebDriverWait wait = new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOf(ticket));
		 ticket.click();
		 	
	}

	public void selectFare() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOf(fare));
		 fare.click();
	}

	public void addAdult1(String adult) {
		// TODO Auto-generated method stub
		try
		{
		String splitStr[] = adult.split("\\s+");	
		String title=splitStr[0].trim();
		String firstname=splitStr[1].trim();
		String lastname=splitStr[2].trim();
		
		System.out.println("title"+title);
		System.out.println("firstname"+firstname);
		System.out.println("lastname"+lastname);
		WebDriverWait wait = new WebDriverWait(driver,60);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(titleAdult1));
		
		 titleAdult1.click();
		 
		 WebElement ele= driver.findElement(By.xpath("//div[@class='dropdown-item__label b2'][normalize-space()='" +title+ "']"));
		 ele.click();
		 
		 wait.until(ExpectedConditions.visibilityOf(firstNameAdult1));
		 firstNameAdult1.sendKeys(firstname);
		 
		 wait.until(ExpectedConditions.visibilityOf(LastNameAdult1));
		 LastNameAdult1.sendKeys(lastname);
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addAdult2(String adult) {
		// TODO Auto-generated method stub
		String[] splitStr = adult.split("\\s+");	
		String title=splitStr[0];
		String firstname=splitStr[1];
		String lastname=splitStr[2];	
		try {
			Thread.sleep(2000);
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", titleAdult2);
			
			WebElement ele= driver.findElement(By.xpath("//div[@class='dropdown-item__label b2'][normalize-space()='" +title+"']")); 
			ele.click();
	
		WebDriverWait wait = new WebDriverWait(driver,30);
		/*wait.until(ExpectedConditions.visibilityOf(titleAdult2));
		titleAdult2.click();
		
		WebElement ele= driver.findElement(By.xpath("//div[@class='dropdown-item__label b2'][normalize-space()='" +title+"']")); ele.click();
		*/
		 wait.until(ExpectedConditions.visibilityOf(firstNameAdult2));
		 firstNameAdult2.sendKeys(firstname);
		 
		 wait.until(ExpectedConditions.visibilityOf(LastNameAdult2));
		 LastNameAdult2.sendKeys(lastname);
}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addChild1(String child) {
		// TODO Auto-generated method stub
		String[] splitStr = child.split("\\s+");	
		String title=splitStr[0];
		String firstname=splitStr[1];
		String lastname=splitStr[2];
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOf(firstNameChild1));
		firstNameChild1.sendKeys(firstname);
		 
		 wait.until(ExpectedConditions.visibilityOf(LastNameChild1));
		 LastNameChild1.sendKeys(lastname);
	}

	public void clickContinue() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOf(continueButton));
		 continueButton.click();
		 
		 
		 wait.until(ExpectedConditions.visibilityOf(infoSection));
		 String info=infoSection.getText();
		 
		 System.out.println("Info:"+info);
		 JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", infoButton);
			
		 
	}

	public void selectSeats() {
		// TODO Auto-generated method stub
		try {
			
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,60);
		 wait.until(ExpectedConditions.visibilityOf(seat1));
		wait.until(ExpectedConditions.elementToBeClickable(seat1));
		 seat1.click();
		 
		 wait.until(ExpectedConditions.visibilityOf(seat2));
		 seat2.click();
		 
		 wait.until(ExpectedConditions.visibilityOf(seat3));
		 seat3.click();
		 
		 wait.until(ExpectedConditions.visibilityOf(continueButton));
		 continueButton.click();
		 
		 wait.until(ExpectedConditions.visibilityOf(noThanks));
		 noThanks.click();
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		 /* JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", seat1);
			 
				executor1.executeScript("arguments[0].click();", seat2);
				
					executor1.executeScript("arguments[0].click();", seat3);*/
	}

	public void selectBaggage() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver,100);
		 wait.until(ExpectedConditions.visibilityOf(baggage));
		 baggage.click();	
		 wait.until(ExpectedConditions.visibilityOf(continueButton));
		 continueButton.click();	
		 
			/*
			 * wait.until(ExpectedConditions.visibilityOf(continueButton));
			 * continueButton.click();
			 * 
			 * wait.until(ExpectedConditions.visibilityOf(continueButton));
			 * continueButton.click();
			 * 
			 * wait.until(ExpectedConditions.visibilityOf(continueButton));
			 * continueButton.click();
			 */
		 
	}
	
//	public void clickOnHeadFirstPython(){
//		headFirstPython.click();
//	}
}
