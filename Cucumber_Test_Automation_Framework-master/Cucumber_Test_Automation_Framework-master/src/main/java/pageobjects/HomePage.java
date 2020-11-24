package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;


public class HomePage {
	WebDriver driver;
	String baseUrl;

	
	@FindBy(xpath="//label[normalize-space()='One way']")
	private WebElement oneWay;
	
	@FindBy(xpath="//input[@id='input-button__destination']")
	private WebElement searchBox;
	
	@FindBy(xpath="//span[contains(text(),'Berlin Brandenburg')]")
	private WebElement searchItem;
	
	
	@FindBy(xpath="//div[@data-ref='input-button__dates-from']//div[@class='input-button__input ng-star-inserted'][normalize-space()='Choose date']")
	private WebElement departureDateBox;
	
	@FindBy(xpath="//div[@class='calendar-body__cell calendar-body__cell--weekend'][normalize-space()='26']")
	private WebElement departureDate;
	
	@FindBy(xpath="//button[contains(text(),'Yes, I agree')]")
	private WebElement acceptCookies;
	
	@FindBy(xpath="//div[@data-ref='input-button__dates-to']//div[@class='input-button__input ng-star-inserted'][normalize-space()='Choose date']")
	private WebElement returnDateBox;
	
	@FindBy(xpath="//div[@class='calendar-body__cell calendar-body__cell--weekend'][normalize-space()='27']")
	private WebElement returnDate;
	
	@FindBy(xpath="//ry-counter[@data-ref='passengers-picker__adults']//div[@class='counter__button-wrapper--enabled']")
	private WebElement adultAdd;
	
	@FindBy(xpath="//ry-counter[@data-ref='passengers-picker__children']//div[@class='counter__button-wrapper--enabled']")
	private WebElement childAdd;
	
	@FindBy(xpath="//ry-counter[@data-ref='passengers-picker__infant']//div[@class='counter__button-wrapper--enabled']")
	private WebElement infantAdd;
	
	@FindBy(xpath="//button[@aria-label='Search']")
	private WebElement search;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	public void enterDestination(String destination){
		
		try {
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", searchBox);
		//searchBox.click();
		
		Thread.sleep(1000);
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", searchItem);
		//searchItem.click();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void enterDepartureDate(String depDate){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(departureDateBox));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", departureDateBox);
		//departureDateBox.click();
		//WebElement date= driver.findElement(By.xpath("//div[@data-id='" +depDate+ "']"));
		wait.until(ExpectedConditions.visibilityOf(departureDate));
		//executor.executeScript("arguments[0].click();", date);
		departureDate.click();
	}
	
	/*
	 * public void clickOnSearchButton(){ searchButton.click(); }
	 */

	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

	public void acceptCookies() {
		// TODO Auto-generated method stub
		Boolean value= acceptCookies.isEnabled();
		Boolean value1= acceptCookies.isDisplayed();
		if(value1)
		{
			if(value)
			{
				acceptCookies.click();
			}
		}
		
	}

	public void enterReturnDate() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(returnDateBox));
		returnDateBox.click();
		wait.until(ExpectedConditions.visibilityOf(returnDate));
		returnDate.click();
	}

	public void clickSearch() {
		// TODO Auto-generated method stub
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(search));
		search.click();
	}

	public void selectOneWayTrip() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(oneWay));
		//oneWay.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", oneWay);
		
	}

	public void addPassengers(String adult, String child, String infant) {
		// TODO Auto-generated method stub
		int adultCount= Integer.parseInt(adult);
		int childCount=Integer.parseInt(child);
		int infantCount=Integer.parseInt(infant);
		
		if(adultCount>1)
		{
			for(int i=1; i<adultCount;i++)
			{
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", adultAdd);
			}
		}
		
		
		if(childCount>0)
		{
			for(int i=1; i<=childCount;i++)
			{
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", childAdd);
			}
			}
			
		
		if(infantCount>0)
		{
			for(int i=1; i<=infantCount;i++)
			{
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", infantAdd);
			}
			}
		}	
	
}
	
