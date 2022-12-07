package pages;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ShipPage {

	//private ShipPage shipPage;
	private Page page;
	public Page page1;
	public Page page2;
	private ExtentTest extentTest;
	
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
    
    private String firstRateProvider = "(//img[@alt='Provider Logo'])[1]";
    private String selectPaymentMethodddl = "//div[text()='Select Payment Method']/following-sibling::span";
    private String addNewCard = "//div[text()='Add New Card']";
    private String cardholderName = "(//input[@class=\"field__input svelte-1lzvkyw\"])[1]";
    private String cardholderName1 = "(//input[@type='text'])[1]";
    private String stripeFrame = "id=__stripe__card__element";
    private String stripeFrame1 = "//iframe[contains(@name,'__privateStripeFrame')]";
    private String cardNumber = "//input[@aria-label='Credit or debit card number']";
    private String monthYear = "//input[@aria-label='Credit or debit card expiration date']";
    private String cvc = "//input[@aria-label='Credit or debit card CVC/CVV']";
    private String zip = "//input[@aria-label='ZIP']";
    private String purchaseLabel = "//span[contains(text(),'Purchase label:')]";
    
    private String shipmentTrackingNo = "(//p[contains(@class,'text')])[1]";
    private String shipmentTrackingNoIn = "//div[text()='Tracking Number']/following::span[1]";
    private String supportRefShipProcider = "//div[text()='Support Reference']/following::span[1]";
    
    
    private String settingsShip = "//div[text()='Settings']";
    private String shippingLabels = "//p[text()='Shipping Labels']";
    private String recipientNotifications = "//p[text()='Recipient Notifications']";
    private String manageProviders = "//p[text()='Manage Providers']";
    
    private String track = "//a[@href='/track']";
    //private String getStarted = "//span[text()='Get Started']";
    private String searchIconTrack = "//img[contains(@src,'search')]";
    private String searchBox = "//input[@type='search']";
    
    public ShipPage(Page page, ExtentTest extentTest) {
		this.page = page;
		this.extentTest = extentTest;
	}
	
	
  public ShipPage onBoarding() {
    	
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
       //ship();
        return new ShipPage(page, extentTest);
    }
    
  public ShipPage ship() {

	  page1.waitForLoadState();
	  //page1.focus(createOne);
	  page1.waitForSelector(createOne);

	  //page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create one")).click();
	  page1.click(createOne); 	

	  page1.fill(nameSender,"Sender123");
	  page1.fill(emailSender,"Sender123@yopmail.com");
	  page1.fill(phoneSender,"+18004444444");
	  // page1.click(locationddl);
	  page1.fill(streetAddress,"2131 Industrial Pkwy, Silver Spring, MD 20904, United States");
	  page1.waitForSelector(streetAddressddl);
	  page1.click(streetAddressddl);
	  page1.fill(unitNumberSender,"10");
	  page1.click(nextRecipientDetails);

	  page1.fill(nameRecipient,"Recipient123");
	  page1.fill(emailRecipient,"Recipient123@yopmail.com");
	  page1.fill(phoneRecipient,"+18004444445");

	  page1.fill(streetAddressRecipient,"500 7th Ave, 100, New York, NY 10018, United States");
	  page1.fill(unitNumberRecipient,"10");
	  page1.click(nextPackageInfo);
	  //page1.mouse().wheel(10, 10);

	  page1.click(packageTypeddl);
	  page1.click(searchtxt);
	  page1.fill(searchtxt,"Custom");
	  page1.click(searchddl);
	  page1.fill(length,"12.5");
	  page1.fill(width,"6.5");
	  page1.fill(height,"9.5");
	  page1.fill(packageWeight,"8");
	  page1.fill(specialHandling,"Fragile");
	  // page1.mouse().down();
	  page1.hover(nextGetShippingOptions);
	  page1.click(nextGetShippingOptions);
	  page1.waitForTimeout(10000);

	  page1.click(firstRateProvider);
	  page1.click(selectPaymentMethodddl);
	  page1.waitForTimeout(3000);
	  page1.waitForSelector(addNewCard);
	  page1.click(addNewCard);
	  page1.waitForTimeout(3000);
	  page1.click(cardholderName);
	  page1.fill(cardholderName,"Mujahid");
	  //page1.locator("#cardholder_name").getByRole(AriaRole.TEXTBOX).click();
	  //page1.locator("#cardholder_name").getByRole(AriaRole.TEXTBOX).fill("Mujahid");
	  //page1.click(stripeFrame1);
	  page1.frameLocator(stripeFrame1).locator(cardNumber).click();
	  page1.frameLocator(stripeFrame1).locator(cardNumber).fill("4242424242424242");
	  page1.frameLocator(stripeFrame1).locator(monthYear).fill("0425");
	  page1.frameLocator(stripeFrame1).locator(cvc).fill("123");
	  page1.frameLocator(stripeFrame1).locator(zip).fill("12345");
	  //page1.fill(cardNumber,"4242424242424242");
	  //page1.fill(monthYear,"0425");
	  //page1.fill(cvc,"11111111");

	  //page1.scrollIntoView(purchaseLabel);
	  //page1.mouse().down();
	  page1.hover(purchaseLabel);
	  page1.click(purchaseLabel);

	  page1.waitForTimeout(25000);

	  page1.keyboard().press("Escape");
	  page1.waitForTimeout(5000);
	  return new ShipPage(page, extentTest);
  }
    
    public void searchShip() {

    	page.waitForLoadState();
    	//page.waitForSelector(foldersOL, setTimeout: 80000 );
    	page.click(foldersOL); 
    	page.waitForSelector(mailTestingOL);
    	page.click(mailTestingOL); 
    	page.waitForLoadState();
    	page.click(inboxOL);
    	page.waitForLoadState();
    	page.click(packageX);
    	page.waitForLoadState();
        // popup.click(loginToPackageXCloud);
        // popup.waitForLoadState();
        
        page1 = page.waitForPopup(() -> {        	
        	page.click(loginToPackageXCloud);
        });
        page1.waitForLoadState();
    	
    	page1.click(ship);
    	page1.waitForLoadState();
    	String stn = page1.textContent(shipmentTrackingNo);
    	System.out.println(stn);
    	
    }
}
