package utils;

//import com.microsoft.playwright.*;
//import com.microsoft.playwright.options.*;
//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
//import java.util.*;
//public class Example {
//  public static void main(String[] args) {
//    try (Playwright playwright = Playwright.create()) {
//      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//        .setHeadless(false));
//      BrowserContext context = browser.newContext();
//      Page page = context.newPage();
//      page.navigate("https://playwright.dev/");
//      page.navigate("https://www.google.com/");
//     // page.getByRole(COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click();
//      //page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).fill("automation testing");
//      //page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).press("Enter");
//      assertThat(page).hasURL("https://www.google.com/search?q=automation+testing&source=hp&ei=RDhaY7LdFYrglwTe3YaIAg&iflsig=AJiK0e8AAAAAY1pGVDVyEuYMXImkRx0DYKYRO1PAOn5P&ved=0ahUKEwiyj8So9v_6AhUK8IUKHd6uASEQ4dUDCAg&uact=5&oq=automation+testing&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOhEILhCPARCPARDqAhCMAxDlAjoRCAAQjwEQjwEQ6gIQjAMQ5QI6EwgAEI8BEI8BEOoCEAoQjAMQ5QI6CAguELEDEIMBOggIABCxAxCDAToICC4QgAQQsQM6EQguEIAEELEDEIMBEMcBENEDOgUILhCABDoLCC4QgAQQsQMQgwE6CwgAEIAEELEDEIMBOg4ILhCABBCxAxCDARDUAjoOCC4QgAQQsQMQxwEQrwE6CAgAEIAEELEDOhQILhCABBCxAxCDARDHARDRAxDUAjoLCC4QgAQQxwEQ0QM6CwguEIAEEMcBEK8BUJUJWPYwYLU2aAFwAHgAgAHaAogB1iGSAQYyLTE3LjGYAQCgAQGwAQo&sclient=gws-wiz");
//      //page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("What is Automation Testing? Test Tutorial - Guru99 https://www.guru99.com › automation-testing")).click();
//      assertThat(page).hasURL("https://www.guru99.com/automation-testing.html");
//      //page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("What is Automation Testing? Test Tutorial")).click();
//    }
//  }
//}


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();

      Page page = context.newPage();

     

      page.navigate("https://staging--cloud.packagex.io/");

      page.locator("input[type=\"email\"]").click();

      page.locator("input[type=\"email\"]").fill("qaautomation@packagex.io");

      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In With Email Link")).click();

      page.getByText("Message sent to qaautomation@packagex.io").click();

      Page page1 = context.newPage();

      page1.navigate("https://outlook.office365.com/mail/");
      page1.waitForLoadState();


      page1.getByPlaceholder("Email, phone, or Skype").click();

      page1.getByPlaceholder("Email, phone, or Skype").fill("qaautomation@packagex.io");

      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      

      page1.getByPlaceholder("Password").click();

      page1.getByPlaceholder("Password").fill("VisionX3210");

      page1.getByPlaceholder("Password").press("Enter");
      assertThat(page1).hasURL("https://login.microsoftonline.com/common/login");
      page1.waitForLoadState();
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
      assertThat(page1).hasURL("https://outlook.office365.com/mail/");

      page1.getByRole(AriaRole.TREEITEM, new Page.GetByRoleOptions().setName("Inbox")).getByText("Inbox").click();
      
      

      page1.locator("(//span[text()='PackageX Cloud Login'])[1]").click();
      page1.waitForLoadState();
      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login To PackageX Cloud")).click();
//      ship();
    	
    	
    	
    	
//    	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//    	        .setHeadless(false));
//    	      BrowserContext context = browser.newContext();
//    	      Page page = context.newPage();
//    	      page.navigate("https://demo.playwright.dev/todomvc/");
//    	      page.navigate("https://demo.playwright.dev/todomvc/#/");
//    	      page.navigate("https://staging--cloud.packagex.io/");
//    	      page.navigate("https://staging--cloud.packagex.io/auth/refresh?continue=/dashboard");
//    	      page.navigate("https://staging--cloud.packagex.io/auth/login");
//    	      page.getByRole(AriaRole.TEXTBOX).click();
//    	      page.getByRole(AriaRole.TEXTBOX).fill("qaautomation@packagex.io");
//    	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In With Email Link")).click();
//    	      Page page1 = context.newPage();
//    	      page1.navigate("https://outlook.live.com/owa/");
//    	      page1.getByRole(AriaRole.NAVIGATION, new Page.GetByRoleOptions().setName("Quick links")).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Sign in")).click();
//    	      page1.getByPlaceholder("Email, phone, or Skype").click();
//    	      page1.getByPlaceholder("Email, phone, or Skype").fill("qaautomation@packagex.io");
//    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
//    	      page1.locator("#i0118").click();
//    	      page1.getByPlaceholder("Password").fill("VisionX3210");
//    	      page1.getByPlaceholder("Password").press("Enter");
//    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
//    	      page1.locator(".gMkyO").click();
//    	      Page page2 = page1.waitForPopup(() -> {
//    	        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login To PackageX Cloud")).click();
//    	      });
      
    	      //page.navigate("https://staging--cloud.packagex.io/dashboard");
    	      page1.navigate("https://staging--cloud.packagex.io/dashboard");
    	      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ship")).click();
    	      page1.locator("header").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("icon")).click();
    	      page1.locator("[id=\"sender\\.name\"]").getByRole(AriaRole.TEXTBOX).click();
    	      page1.locator("[id=\"sender\\.name\"]").getByRole(AriaRole.TEXTBOX).fill("Sender");
    	      page1.locator("input[type=\"email\"]").click();
    	      page1.locator("input[type=\"email\"]").fill("sender12@yopmail.com");
    	      page1.locator("input[type=\"tel\"]").click();
    	      page1.locator("input[type=\"tel\"]").fill("3197010281472");
    	      page1.getByText("Location An error occurred Select an option").click();
    	      page1.locator("[id=\"sender\\.location_id\"] div").filter().nth(1).click();
    	      page1.locator("textarea").click();
    	      page1.locator("textarea").fill("500");
    	      page1.getByText("500 West Madison Street, Chicago, IL, USA").click();
    	      page1.locator("[id=\"sender\\.address_line2\"]").getByRole(AriaRole.TEXTBOX).click();
    	      page1.locator("[id=\"sender\\.address_line2\"]").getByRole(AriaRole.TEXTBOX).fill("100");
    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next: Recipient Details")).click();
    	      page1.locator("[id=\"recipient\\.name\"]").getByRole(AriaRole.TEXTBOX).click();
    	      page1.locator("[id=\"recipient\\.name\"]").getByRole(AriaRole.TEXTBOX).fill("Recipient");
    	      page1.locator("input[type=\"email\"]").click();
    	      page1.locator("input[type=\"email\"]").fill("recipient12@yopmail.com");
    	      page1.locator("input[type=\"tel\"]").click();
    	      page1.locator("input[type=\"tel\"]").fill("3197010281473");
    	      page1.locator("textarea").click();
    	      page1.locator("textarea").fill("21");
    	      page1.locator("textarea").dblclick();
    	      page1.locator("textarea").click();
    	      page1.locator("textarea").dblclick();
    	      page1.locator("textarea").fill("2131 Industrial Pkwy, Silver Spring, MD 20904, United States\n");
    	      page1.getByText("2131 Industrial Pkwy, Silver Spring, MD 20904, United States").click();
    	      page1.locator("[id=\"recipient\\.address_line2\"]").getByRole(AriaRole.TEXTBOX).click();
    	      page1.locator("[id=\"recipient\\.address_line2\"]").getByRole(AriaRole.TEXTBOX).fill("11");
    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next: Package Information")).click();
    	      page1.locator("[id=\"package\\.length\"]").getByRole(AriaRole.SPINBUTTON).click();
    	      page1.locator("[id=\"package\\.length\"]").getByRole(AriaRole.SPINBUTTON).fill("2");
    	     // page2.locator("[id=\"package\\.length\"]").getByRole(AriaRole.SPINBUTTON).press("Tab");
    	      page1.locator("[id=\"package\\.width\"]").getByRole(AriaRole.SPINBUTTON).fill("2");
    	      page1.locator("[id=\"package\\.width\"]").getByRole(AriaRole.SPINBUTTON).press("Tab");
    	      page1.locator("[id=\"package\\.height\"]").getByRole(AriaRole.SPINBUTTON).fill("2");
    	      page1.locator("[id=\"package\\.height\"]").getByRole(AriaRole.SPINBUTTON).press("Tab");
    	      page1.locator("[id=\"package\\.weight\"]").getByRole(AriaRole.SPINBUTTON).fill("2");
    	      page1.getByRole(AriaRole.TEXTBOX).click();
    	      page1.getByRole(AriaRole.TEXTBOX).fill("Confidential");
    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next: Get Shipping Options")).click();
    	      page1.locator("input[type=\"tel\"]").click();
    	     
    	      page1.locator("input[type=\"tel\"]").fill("+3197010281472");
    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next: Recipient Details")).click();
    	      page1.locator("input[type=\"tel\"]").click();
    	     // page2.locator("input[type=\"tel\"]").press("ArrowLeft");
    	      
    	      page1.locator("input[type=\"tel\"]").fill("+3197010281473");
    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next: Package Information")).click();
    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next: Get Shipping Options")).click();
    	      page1.navigate("https://staging--cloud.packagex.io/ship/shipments/ship_b7tBhCXSfLuH3UtG6SksVS");
    	      page1.getByText("PackageX Demo Same Day").click();
    	      page1.getByText("Select Payment Method Select a payment method MasterCard ····5100").click();
    	      page1.locator("#payment_method div").filter().nth(1).click();
    	      page1.locator("#cardholder_name").getByRole(AriaRole.TEXTBOX).click();
    	      page1.locator("#cardholder_name").getByRole(AriaRole.TEXTBOX).fill("Mujahid");
    	      page1.frameLocator("iframe[name=\"__privateStripeFrame8196\"]").getByPlaceholder("Card number").click();
    	      page1.frameLocator("iframe[name=\"__privateStripeFrame8196\"]").getByPlaceholder("Card number").fill("4242 4242 4242 4242");
    	      page1.frameLocator("iframe[name=\"__privateStripeFrame8196\"]").getByPlaceholder("MM / YY").fill("02 / 25");
    	      page1.frameLocator("iframe[name=\"__privateStripeFrame8196\"]").getByPlaceholder("MM / YY").click();
    	      page1.frameLocator("iframe[name=\"__privateStripeFrame8196\"]").getByPlaceholder("CVC").click();
    	      page1.locator("#card_token div").filter().locator("div").nth(2).click();
    	      page1.frameLocator("iframe[name=\"__privateStripeFrame8196\"]").getByPlaceholder("CVC").fill("122");
    	      page1.frameLocator("iframe[name=\"__privateStripeFrame8196\"]").getByPlaceholder("ZIP").fill("333333");
    	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Purchase label: $16.01")).click();
     
    }
  }
  
  public static void ship() {
	  
  
	  try (Playwright playwright = Playwright.create()) {
	  
	  Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
	  BrowserContext context = browser.newContext();
	  Page page = context.newPage();
	  
	  page.navigate("https://staging--cloud.packagex.io/dashboard");
	  page.waitForLoadState();
	  page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("PackageX Cloud")).click();
//
//      context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json"))); 
      
      
      //BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));      
      //Page page1 = context.newPage();      
      //page1.navigate("https://staging--cloud.packagex.io/dashboard");
      
      Page page2 = context.newPage();
      page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ship")).click();
      assertThat(page2).hasURL("https://staging--cloud.packagex.io/ship/shipments");
      
      
      
      
      //page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ship")).click();
      //assertThat(page2).hasURL("https://sandbox--cloud.packagex.io/ship/shipments");
      page2.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Shipments")).click();
      page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create one")).click();
      assertThat(page2).hasURL("https://staging--cloud.packagex.io/ship/shipments/new");
      page2.getByText("Location An error occurred Select an option").click();
	  }
  }
}