package stepdefinition;

import org.openqa.selenium.WebDriver;
import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.AddToCartPage;
import pageobjects.CheckOutPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProductsPage;



public class Steps {
	
	static WebDriver driver;
	TestContext testContext;
	HomePage homePage;
	ProductsPage productsPage;
	AddToCartPage addToCartPage;
	CheckOutPage checkOutPage;
	LoginPage loginPage;

	public Steps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		productsPage = testContext.getPageObjectManager().getProductListingPage();
		addToCartPage = testContext.getPageObjectManager().getAddToCartPage();
		checkOutPage = testContext.getPageObjectManager().getCheckoutPage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		
	}
	
	@Given("^user is on Home Page$")
	public void userIsOnHomePage(){
		homePage.navigateTo_HomePage();
		homePage.acceptCookies();
	}
	
	@When("^user login the ryan air application with username and password$")
	public void userLoginApplication(){
		loginPage.clickOnLogIn();
		loginPage.loginToCheckOut();
	}
	
	@When("^user selecting one way trip$")
	public void user_selecting_one_way_trip() {
	    // Write code here that turns the phrase above into concrete actions
	    homePage.selectOneWayTrip();
	}
	
	@When("^user entering destination as \"(.*)\"$")
	public void enterDestination(String destination)  {
		homePage.enterDestination(destination);
		//homePage.clickOnSearchButton();
	}
	
	@When("^user entering departure date as \"(.*)\"$")
	public void enterDepartureDate(String depDate)  {
		//homePage.enterProduct(product);
		homePage.enterDepartureDate(depDate);
		//homePage.enterReturnDate();
	}
 
	/*
	 * @When("^user entering departure date and return date$") public void
	 * enterDepartureDate() { //homePage.enterProduct(product);
	 * homePage.enterDepartureDate(); homePage.enterReturnDate(); }
	 */
	
	
	@When("^user entering adult count as \"([^\"]*)\" ,child count as \"([^\"]*)\" and infant count as \"([^\"]*)\"$")
	public void user_entering_adult_count_as_child_count_as_and_infant_count_as(String adult, String child, String infant) {
	    // Write code here that turns the phrase above into concrete actions
	
		homePage.addPassengers(adult,child,infant);
		
	}
	    
	@When("^user clicks search button$")
	public void clickSearch() {
		homePage.clickSearch();		
	}
	
	@When("^selecting a ticket and selecting fare$")
	public void selectTicket() {
		try {
			
		Thread.sleep(4000);
		productsPage.selectTicket();	
		Thread.sleep(4000);
		productsPage.selectFare();
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@When("^entering Adult1 details as \"(.*)\"$")
	public void addAdult1(String adult1) {
		productsPage.addAdult1(adult1);
	}
	
	@When("^entering Adult2 details as \"(.*)\"$")
	public void addAdult2(String adult2) {
		productsPage.addAdult2(adult2);
	}
	
	@When("^entering Child1 details as \"(.*)\"$")
	public void addChild1(String child1) {
		productsPage.addChild1(child1);
	}
	
	@When("^clicking on Continue button$")
	public void clickContinue() {
		productsPage.clickContinue();
	}
	
	@When("^selecting seats$")
	public void selectSeat(){
		productsPage.selectSeats();
	}
	
	@When("^selecting baggage type$")
	public void selectBaggage(){
		productsPage.selectBaggage();
	}
 
	@When("^selecting shopping cart and checkout$")
	public void selectShoppingCart(){
		//addToCartPage.selectContinue();
		
		addToCartPage.addTocart();
		addToCartPage.checkOut();
		
	}
	
	@When("^entering contact details$")
	public void enterContactDetails(){
		addToCartPage.enterContactDetails();
	}
 
	
	@When("^User clicks on shopping cart$")
	public void userClicksOnShoppingCart(){
		checkOutPage.clickSoppingCart();	
	}
	
	@When("^Cliks on proceed to check out$")
	public void userClicksOnProceedCheckOut(){
		checkOutPage.clicksOnProceedCheckPOut();	
	}
	
	@Then("^User should be asked to login before checkout$")
	public void enterPersonalDetailsOnLoginPage() throws InterruptedException {
		/*
		 * loginPage.loginToCheckOut(); homePage.closeBrowser();
		 */
	}

}
