package pages;

import static base.PlaywrightFactory.takeScreenshot;
import static utils.ExtentReporter.extentLogWithScreenshot;

import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

/**
 * Page Object Class for shopping cart Page
 * 
 * @author Nayeem John
 */
public class ShoppingCartPage {

    private Page page;
	public Page page1;
    private ExtentTest extentTest;

    private String checkout = "//a[text()='Checkout']";
    private String login = "//input[@value='Login']";
    private String billingAddress = "//a[@href='#collapse-payment-address']";
    
    
    //
    
    private String email ="input[type='email']";
    private String signInWithEmailBtn ="//span[text()='Sign In With Email Link']";
    private String loginLinkValidation ="//span[contains(text(),'Message sent to')]";
    //private String password = "input[type='password']";
    private String signInBtnOL ="//a[text()='Sign in']";
    private String emailOL ="//input[@type='email']";
    private String nextBtnOL ="//input[@type='submit']";
    private String staySignedIn ="//div[text()='Stay signed in?']";
    private String passwordOL ="//input[@type='password']";
    private String inboxOL ="(//span[text()='Inbox'])[1]";
    private String foldersOL ="//span[text()='Folders']";
    private String mailTestingOL ="(//span[text()='Mail Testing'])[1]";
    private String mailTestingInboxOL ="((//span[text()='Mail Testing'])[1]/following::div/span[text()='Inbox'])[1]";
    private String packageX ="(//span[text()='PackageX Cloud Login'])[1]";
    private String loginToPackageXCloud ="//span[text()='Login To PackageX Cloud']";
    private String packageXCloud ="//h2[text()='PackageX Cloud']";
    
    
    private String letsGoBtn = "//span[text()=\"Let's Go\"]";
    private String nametxt = "//input[@type='text']";
    private String nextBtn = "//span[text()='Next']";
    private String companyNametxt = "(//input[@type='text'])[1]";
    private String companyDBANametxt = "(//input[@type='text'])[2]";
    private String addresstxt = "//textarea[@class='field__textarea svelte-1lzvkyw']";
    private String addressddl = "(//div[contains(@class,'title')])[1]";
    private String unitNumbertxt = "//input[@type='text']";
    private String submitBtn = "//span[text()='Submit']";
    private String proceedToDashboardBtn = "//span[text()='Proceed To Dashboard']";
    
    private String ship = "//a[@href='/ship']";
    private String getStarted = "//span[text()='Get Started']";
    private String createOne = "(//a[@href='/ship/shipments/new'])[1]";
    //private String createOne = "id=51c2391a-1970-479f-aa7b-90195404d64d";
    private String filter = "//div[text()='Filter']";
    private String nameSender = "//input[@type='text']";
    private String emailSender = "//input[@type='email']";
    private String phoneSender = "//input[@type='tel']";
    private String locationddl = "//div[text()='Location']/following-sibling::span";
    private String streetAddress = "//textarea[@class='field__textarea svelte-1lzvkyw']";
    private String streetAddressddl = "//textarea[@class='field__textarea svelte-1lzvkyw']/following::div[contains(@class,'title')][1]";
    private String unitNumberSender = "(//input[@class='field__input svelte-1lzvkyw'])[4]";
    private String nextRecipientDetails = "//span[text()='Next: Recipient Details']";		
    
    private String nameRecipient = "//input[@type='text']";
    private String emailRecipient = "//input[@type='email']";
    private String phoneRecipient = "//input[@type='tel']";
    private String streetAddressRecipient = "//textarea[@class='field__textarea svelte-1lzvkyw']";
    private String unitNumberRecipient = "(//input[@class='field__input svelte-1lzvkyw'])[4]";
    private String nextPackageInfo = "//span[text()='Next: Package Information']";
    
    private String packageTypeddl = "//div[text()='Package Type']/following::span[1]";
    //private String searchtxt = "//input[@placeholder='Start typing to search...']";
    private String searchtxt = "//input[contains(@class,'search')]";
    private String searchddl = "//input[contains(@class,'search')]/following::div[contains(@class,'title')][1]";
    private String width = "//span[text()='Width (In)']/following::input[1]";
    private String length = "//span[text()='Length (In)']/following::input[1]";
    private String height = "//span[text()='Height (In)']/following::input[1]";
    private String packageWeight = "//span[text()='Package Weight (LBS)']/following::input[1]";
    private String specialHandling = "//span[text()='Special Handling (optional)']/following::input[1]";
    private String nextGetShippingOptions = "//span[text()='Next: Get Shipping Options']";
    
    //
    
    

    /**
     * Constructor to initialize the page objects with the {@link Page} instance and
     * {@link ExtentTest} instance
     * 
     * @param page       - {@link Page}
     * @param extentTest - {@link ExtentTest}
     */
    public ShoppingCartPage(Page page, ExtentTest extentTest) {
        this.page = page;
        this.extentTest = extentTest;
    }

    /**
     * Method to verify the product added to cart is available in cart
     * 
     * @param products - {@link List<String>} Of products to verify
     * @return boolean - Returns true if all products is available in cart else
     *         false if any one product is not available
     */
    public boolean checkProductInCart(List<String> products) {
        for (String product : products) {
            String productInCartSelector = "//div[@id='content']//a[text()='" + product + "']";
            if (!page.waitForSelector(productInCartSelector).isVisible()) {
                extentLogWithScreenshot(extentTest, Status.FAIL,
                        "The '" + product + "' Product is not available to the cart", takeScreenshot(page));
                return false;
            }
        }
        extentLogWithScreenshot(extentTest, Status.PASS,
                "The '" + products.toString() + "' Products is available to the cart", takeScreenshot(page));
        return true;
    }

    /**
     * Method to checkout the cart with the product items
     * 
     * @param isUserLoggedIn - {@link Boolean} - User Login state
     * @return boolean - Returns true if checkout was successful else @throws {@link
     *         com.microsoft.playwright.TimeoutError}
     *         Exception
     */
    public boolean checkoutCart(boolean isUserLoggedIn) {
        page.click(checkout);
        if (isUserLoggedIn) {
            return page.waitForSelector(billingAddress).isVisible();
        } else {
            return page.waitForSelector(login).isVisible();
        }
    }
    
    
    
public void onBoarding() {
    	
    	page.waitForLoadState();
    	//page.waitForSelector(foldersOL, setTimeout: 80000 );
    	page.click(foldersOL); 
    	page.waitForSelector(mailTestingOL);
    	page.click(mailTestingOL); 
    	page.waitForLoadState();
    	page.click(mailTestingInboxOL);
    	page.waitForLoadState();
    	page.click(packageX);
    	page.waitForLoadState();
        // popup.click(loginToPackageXCloud);
        // popup.waitForLoadState();
        
        page1 = page.waitForPopup(() -> {        	
        	page.click(loginToPackageXCloud);
        });
        page1.waitForLoadState();
        
        page1.click(letsGoBtn);
        page1.fill(nametxt, "Testing");
        page1.click(nextBtn);
        page1.fill(companyNametxt, "Automation Testing");
        page1.fill(companyDBANametxt, "Automation DB");
        page1.click(nextBtn);
        page1.fill(addresstxt, "Amsterdam, Netherlands");
        page1.waitForSelector(addressddl);
        page1.click(addressddl);
        page1.fill(unitNumbertxt, "100");
        page1.click(submitBtn);
        page1.click(proceedToDashboardBtn);
        
        page1.click(ship);
        page1.waitForLoadState();
         
        page1.click(getStarted);
       // page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create one")).click();
        
       // Page page2 = context.newPage(); 
        //page.click(createOne);
        //popup1.waitForSelector(createOne);
       ship();
        //return new ShipPage(page, extentTest);
    }
    
    public void ship() {
    	
    	page1.waitForLoadState();
    	page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create one")).click();
    	//page.waitForSelector(createOne);
    	//page.click(createOne); 	

    	page1.fill(nameSender,"Sender123");
    	page1.fill(emailSender,"Sender123@yopmail.com");
    	page1.fill(phoneSender,"3197010281472");
    	page1.click(locationddl);
    	page1.fill(streetAddress,"Amsterdam, Netherlands");
    	page1.fill(unitNumberSender,"10");
    	page1.click(nextRecipientDetails);

    	page1.fill(nameSender,"Sender123");
    	page1.fill(emailSender,"Sender123@yopmail.com");
    	page1.fill(phoneSender,"3197010281472");

    	page1.fill(streetAddress,"Amsterdam, Netherlands");
    	page1.fill(unitNumberSender,"10");
    	page1.click(nextRecipientDetails);
    	
    	//return new ShipPage(page, extentTest);
    }
    
    
    
    
}
