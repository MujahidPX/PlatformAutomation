package pages;

import static base.PlaywrightFactory.takeScreenshot;
import static utils.ExtentReporter.extentLogWithScreenshot;

import java.util.Base64;

import org.testng.Assert;

import static utils.ExtentReporter.extentLog;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

/**
 * Page Object Class for Login Page
 * 
 * @author Nayeem John
 */
public class LoginPage {

    private Page page;
    private Page page1;
    private ExtentTest extentTest;
    private String emailId = "//input[@id='input-email']";
    private String password1 = "//input[@id='input-password']";
    private String loginBtn = "//input[@value='Login']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";
    private String alertErrorSelector = "#passwordError";
    //private String logoutLink1= "//div[@id='content']//a[text()='" + product + "']";
    
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
    
    
    private String track = "//a[@href='/track']";
    //private String getStarted = "//span[text()='Get Started']";
    private String searchIconTrack = "//img[contains(@src,'search')]";
    private String searchBox = "//input[@type='search']";
    
    /**
     * Constructor to initialize the page objects with the {@link Page} instance and
     * {@link ExtentTest} instance
     * 
     * @param page       - {@link Page}
     * @param extentTest - {@link ExtentTest}
     */
    public LoginPage(Page page, ExtentTest extentTest) {
        this.page = page;
        this.extentTest = extentTest;
    }

    /**
     * Method to get Login page title
     * 
     * @return String - Returns page title
     */
    public String getLoginPageTitle() {
        return page.title();
    }

    /**
     * Method to Login using the username and password
     * 
     * @param appUserName - {@link String} username for the App
     * @param appPassword - {@link String} username for the password
     * @return boolean - Returns true after successful login else false
     */
    
    public boolean doLogin(String appUserName, String appPassword) {
        extentLog(extentTest, Status.INFO, "Login to Application using username " + appUserName);
        
        //page.fill(email, appUserName);
        //page.fill(email, HomePage.generateTestEmail());
        
        String newEmail = HomePage.generateTestEmail();
        page.fill(email, newEmail);
        System.out.println(newEmail);
        page.click(signInWithEmailBtn);
        page.waitForLoadState();
        page.waitForSelector(loginLinkValidation);        
        Assert.assertTrue(true, newEmail);
        
        //assertThat(response).isOK();
        
        /*
        Page popup = page.waitForPopup(() -> {
        	page.click("a[target='_blank']");
        });
        popup.waitForLoadState();
        */
        
        page.navigate("https://outlook.office365.com/mail/");
        page.waitForLoadState();
        page.fill(emailOL, appUserName);
        page.click(nextBtnOL);
        page.fill(passwordOL, new String(Base64.getDecoder().decode(appPassword)));
        page.click(nextBtnOL);
        page.waitForLoadState();
       
        if (page.isVisible(staySignedIn)) {
        	page.click(nextBtnOL);
        	page.waitForLoadState();
        } else {
			System.out.println("No, Stay signed in option");
		}
        
        page.waitForLoadState();  
        
        if (page.locator(inboxOL).isVisible()) {
        	//popup.focus(inboxOL);
            extentLog(extentTest, Status.PASS, "User login to the outlook successful.");
            return true;
        }
        page.waitForLoadState(); 
        boolean isErrorDisplayed = page.textContent(alertErrorSelector)
                .contains("Your account or password is incorrect. If you don't remember your password, ");
        extentLogWithScreenshot(extentTest, Status.FAIL, "User login to the outlook is unsuccessful.",
                takeScreenshot(page));
        return !isErrorDisplayed;     
        
    }
    
    public boolean doLogin1(String appUserName1, String appUserName, String appPassword1) {
        extentLog(extentTest, Status.INFO, "Login to Application using username " + appUserName1);
        
        page.fill(email, appUserName1);
        //page.fill(email, HomePage.generateTestEmail());
        
        //String newEmail = HomePage.generateTestEmail();
        //page.fill(email, newEmail);
        //System.out.println(newEmail);
        page.click(signInWithEmailBtn);
        page.waitForLoadState();
        page.waitForSelector(loginLinkValidation);        
       // Assert.assertTrue(true, newEmail);
        
        //assertThat(response).isOK();
        
        /*
        Page popup = page.waitForPopup(() -> {
        	page.click("a[target='_blank']");
        });
        popup.waitForLoadState();
        */
        
        page.navigate("https://outlook.office365.com/mail/");
        page.waitForLoadState();
        page.fill(emailOL, appUserName);
        page.click(nextBtnOL);
        page.fill(passwordOL, appPassword1);
        page.click(nextBtnOL);
        page.waitForLoadState();
       
        if (page.isVisible(staySignedIn)) {
        	page.click(nextBtnOL);
        	page.waitForLoadState();
        } else {
			System.out.println("No, Stay signed in option");
		}
        
        page.waitForLoadState();  
        
        if (page.locator(inboxOL).isVisible()) {
        	//popup.focus(inboxOL);
            extentLog(extentTest, Status.PASS, "User login to the outlook successful.");
            return true;
        }
        page.waitForLoadState(); 
        boolean isErrorDisplayed = page.textContent(alertErrorSelector)
                .contains("Your account or password is incorrect. If you don't remember your password, ");
        extentLogWithScreenshot(extentTest, Status.FAIL, "User login to the outlook is unsuccessful.",
                takeScreenshot(page));
        return !isErrorDisplayed;     
        
    }
    
    public void onBoarding() {
    	
    	page.waitForLoadState();
    	//page.waitForSelector(foldersOL, setTimeout: 80000 );
    	page.waitForTimeout(1000);
    	page.click(foldersOL); 
    	//page.mouse().wheel(100, 100);
    	page.waitForTimeout(3000);
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
        page1.fill(addresstxt, "500 7th Ave, 100, New York, NY 10018, United States");
        page1.waitForSelector(addressddl);
        page1.click(addressddl);
        page1.fill(unitNumbertxt, "street 9");
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
        
        //return new ShipPage(page, extentTest);
    
    }
    
    public void ship() {
    	
        page1.waitForLoadState();
    	//page1.focus(createOne);
    	page1.waitForSelector(createOne);
    	page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create one")).click();
		//page.click(createOne); 	
    
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
    	
    	page1.waitForTimeout(20000);
    	
    }
    
    public void track() {
    	
    	 page1.click(track);
         page1.waitForLoadState();
          
         page1.click(getStarted);
         page1.click(searchIconTrack);
         page1.click(searchBox);
         
    }
}
