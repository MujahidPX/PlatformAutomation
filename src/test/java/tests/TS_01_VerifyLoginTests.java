package tests;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ShipPage;
import pages.ShoppingCartPage;

public class TS_01_VerifyLoginTests extends TestBase {

	private ShipPage shipPage;
	private ShoppingCartPage shoppingCartPage;
	
	/**
	 * BeforeClass Method to create ExtentTest in Extent Report
	 */
	@BeforeClass
	public void setupBeforeClass() {
		extentTest = reporter.createTest("TS_01 Verify Login", "Verify login functionality");
	}

	/**
	 * Test the login functionality of the application with valid credentials
	 * This test will soft assert the home page title and validate the login
	 */
	@Test
	public void loginWithValidCredentialsTest() {
		testNode = extentTest.createNode("TC_01 Verify Login with Valid Credentials");
		testNode.assignCategory("TS_01_Platform-Login");
		homePage = new HomePage(page, testNode);
		//softAssert.assertEquals(homePage.getHomePageTitle(), HOME_PAGE_TITLE);
		loginPage = homePage.navigateToLoginPage();
		Assert.assertTrue(loginPage.doLogin(testProperties.getProperty("username"),
				testProperties.getProperty("password")));
		shipPage = homePage.navigateToShipPage();
		shipPage.onBoarding();
		shipPage.ship(); 
		
		//loginPage1 = homePage.navigateToShoppingCartPage();
		//shipPage = new ShipPage(page, testNode);
		//shipPage = shipPage.ship(); 
	}

	/**
	 * Test the login functionality of the application with invalid credentials
	 * This test will soft assert the home page title and validate the login
	 */
	@Test
	public void loginWithInvalidCredentialsTest() {
		testNode = extentTest.createNode("TC_02 Verify Open Cart Login with Invalid Credentials");
		testNode.assignCategory("TS_01_Open-Cart-Login");
		homePage = new HomePage(page, testNode);
		softAssert.assertEquals(homePage.getHomePageTitle(), HOME_PAGE_TITLE);
		loginPage = homePage.navigateToLoginPage();
		Assert.assertFalse(loginPage.doLogin(UUID.randomUUID().toString().replace("-", ""), "InvalidPassword"));
	}
	
	@Test
	public void loginWithValidCredentialsTest_02() {
		testNode = extentTest.createNode("TC_01 Verify Login with Valid Credentials");
		testNode.assignCategory("TS_01_Platform-Login");
		homePage = new HomePage(page, testNode);
		//softAssert.assertEquals(homePage.getHomePageTitle(), HOME_PAGE_TITLE);
		loginPage = homePage.navigateToLoginPage();
		Assert.assertTrue(loginPage.doLogin1(testProperties.getProperty("username1"), testProperties.getProperty("username"),
				testProperties.getProperty("password1")));
		shipPage = homePage.navigateToShipPage();
		//shipPage.onBoarding();
		shipPage.searchShip(); 
		
		//loginPage1 = homePage.navigateToShoppingCartPage();
		//shipPage = new ShipPage(page, testNode);
		//shipPage = shipPage.ship(); 
	}
}
