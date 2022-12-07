package pages;

import static base.PlaywrightFactory.takeScreenshot;
import static utils.ExtentReporter.extentLog;
import static utils.ExtentReporter.extentLogWithScreenshot;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Page Object Class for Home Page
 * 
 * @author Nayeem John
 */
public class HomePage {

	private Page page;
	private ExtentTest extentTest;

	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";
	private String productSearchResult = "div.product-thumb";
	private String addToCartSelector = "text='Add to Cart'";
	private String alertSelector = "div.alert";
	private String productCaption = ".caption h4 a";
	private String shoppingCartLink = "//a[contains(text(), 'shopping cart')]";
	private String shoppingCartIcon = "div#cart";
	private String viewCartLink = "text='View Cart'";
	
	//private String email ="//input[@type='email']";
	private String email ="input[name='email']";
	
	
	
	private String ship = "//a[@href='/ship']";
    private String getStarted = "//span[text()='Get Started']";
    private String createOne = "(//a[@href='/ship/shipments/new'])[2]";
    private String filter = "//div[text()='Filter']";
    private String nameSender = "//input[@type='text']";
    private String emailSender = "//input[@type='email']";
    private String phoneSender = "//input[@type='tel']";
    private String locationddl = "//div[text()='Location']";
    private String streetAddress = "//textarea[@class='field__textarea svelte-1lzvkyw']";
    private String unitNumberSender = "(//input[@class='field__input svelte-1lzvkyw'])[4]";
    private String nextRecipientDetails = "//span[text()='Next: Recipient Details']";	

    
	/**
	 * Constructor to initialize the page objects with the {@link Page} instance and
	 * {@link ExtentTest} instance
	 * 
	 * @param page       - {@link Page}
	 * @param extentTest - {@link ExtentTest}
	 */
	public HomePage(Page page, ExtentTest extentTest) {
		this.page = page;
		this.extentTest = extentTest;
	}

	/**
	 * Method to retrieve the Home Page title
	 * 
	 * @return String - Returns page title
	 */
	public String getHomePageTitle() {
		return page.title();
	}

	/**
	 * Method to search item in the portal for productName
	 * 
	 * @param productName - Name of the product to search
	 * @return boolean - Returns true if search found results else false
	 */
	public boolean searchProduct(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String header = page.textContent(searchPageHeader);
		extentLog(extentTest, Status.PASS, "Search of '" + header + "' Product is successful");
		if (page.locator(productSearchResult).count() > 0) {
			extentLog(extentTest, Status.PASS, "Search of '" + productName + "' Product is successful");
			return true;
		}
		extentLogWithScreenshot(extentTest, Status.FAIL, "No Product is available for the search '" + productName + "'",
				takeScreenshot(page));
		return false;
	}

	/**
	 * Method to add a product to the cart. Product will be added to cart and
	 * screenshot is taken
	 * 
	 * @return String - Returns actual product catalog name
	 */
	public String addProductToCart() {
		Locator productLocator = page.locator(productSearchResult).nth(0);
		productLocator.locator(addToCartSelector).click();
		String product = productLocator.locator(productCaption).textContent();
		if (page.locator(alertSelector).textContent()
				.contains("You have added " + product + " to your shopping cart!")) {
			extentLogWithScreenshot(extentTest, Status.PASS, "The '" + product + "' product is added to the cart.",
					takeScreenshot(page));
			return product;
		}
		extentLog(extentTest, Status.FAIL, "Unable to add the product to the cart");
		return null;
	}

	/**
	 * Method to navigate from Homepage to Login page
	 * 
	 * @return LoginPage - Returns {@link LoginPage} instance
	 */
	public LoginPage navigateToLoginPage() {
		//page.click(myAccountLink);
		//page.click(loginLink);
		//generateTestEmail();
		return new LoginPage(page, extentTest);
	}
	
	
	
	public LoginPage navigateToLoginPage_1() {
		page.click(email);
		page.type(email, "123");
		page.click(loginLink);
		return new LoginPage(page, extentTest);
	}
	
	public ShipPage navigateToShipPage() {
		//page.click(email);
		//page.type(email, "123");
		//page.click(loginLink);
		return new ShipPage(page, extentTest);
	}

	/**
	 * Method to navigate from Homepage to Shopping cart page
	 * 
	 * @return ShoppingCartPage - Returns {@link ShoppingCartPage} instance
	 */
	public ShoppingCartPage navigateToShoppingCartPage() {
		//if (page.isVisible(shoppingCartLink)) {
		if (page.isVisible(createOne)) {
			page.click(createOne);
			System.out.println("111");
		} else {
			page.click(shoppingCartIcon);
			page.click(viewCartLink);
		}
		return new ShoppingCartPage(page, extentTest);
	}
	
	 public static String generateTestEmail(){
	        String Email;
	        String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	        String TestName="Automation"+timeStamp+"@packagex.xyz";
	        Email = TestName;
	        return Email;
	    }
	 
	 public LoginPage ship() {
	    	
	    	//Page popup2 = popup1.newPage();
	    	
//	    	Page popup1 = page.waitForPopup(() -> {        	
//	        	page.click(getStarted);
//	        });
//	        popup1.waitForLoadState();
	    	
	    	page.click(getStarted);
	    	page.click(createOne);
	    	page.fill(nameSender,"1111");
	    	return new LoginPage(page, extentTest);
	    	
	    }
}
