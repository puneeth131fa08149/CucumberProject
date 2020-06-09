package StepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Page.HomePage;
import Page.LoginPage;
import Utlities.testBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination extends testBase{
	HomePage homePage;
	LoginPage loginpage;
	@Given("^user enters browser$")
	public void user_enters_browser() throws Throwable {
	//	test=extend.createTest("nopcommercetitleTest");
		loginpage.initialization();
	}

	@Given("^user is on loginpage$")
	public void user_is_on_loginpage() throws Throwable {
		loginpage=new LoginPage();
		String title=loginpage.validateTitle();
		System.out.println("Login page title :: "+title);
		Assert.assertEquals("Your store. Login", title);
		logger.info("************ Validating Title Page Before Login **********");
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		homePage=loginpage.login(prop.getProperty("userName"), prop.getProperty("password"));
		logger.info("************ Entering UserName and Password **********");
	}


	@Then("^validate home page title$")
	public void validate_home_page_title() throws Throwable {
		String title=homePage.verifyHomePageTitle();
		System.out.println("HomePageTitle ::" +title);
		Assert.assertEquals("Dashboard / nopCommerce administration", title);
		logger.info("************ Checkin Title After login page **********");
	}
	
	@Then("^user enter valid information$")
	public void user_enter_valid_information() throws Throwable {
	  homePage.clickCustomersMenu();
	  logger.info("************ Click on Customer Menu **********");
	  homePage.clickCustomerMenuItem();
	  logger.info("************ Click on CustomerMenuItem **********");
	  homePage.clickOnAddbutton();
	  logger.info("************ Click on ADD Button **********");
	  homePage.Enter_email("puneeth225@gmail.com");
	  logger.info("************ Enter the Email.id **********");
	  homePage.Enter_password("131");
	  logger.info("************ Enter the Password **********");
	  homePage.Enter_Frist_Name("pun");
	  logger.info("************ Enter the FirstName **********");
	  homePage.Enter_Last_Name("mal");
	  logger.info("************ Enter the LastName **********");
	  homePage.select_gender();
	  logger.info("************ Click Gender **********");
	  homePage.Enter_DOB("08/21/1992");
	  logger.info("************ Enter the DOB **********");
	  homePage.Enter_company_name("AAAA");
	  logger.info("************ Enter Company Name **********");
	  homePage.clickOn_is_taxempty();
	  logger.info("************ Check the taxEmpty **********");
	  homePage.select_vendor("Vendor 1");
	  logger.info("************ Select the Vendor **********");
	  homePage.activeChbx_status();
	  logger.info("************Check the Statue of the check Box **********");
	  homePage.AddAdmin_comments("This is an account created for Test by Admin");
	  logger.info("************ Enter the some valid text  **********");
	  homePage.click_save();
	  logger.info("************ Click on save Button **********");
	}
	@Then("^check email created or not$")
	public void check_email_created_or_not() throws Throwable {
	   homePage.Email_search("puneeth225@gmail.com");
	   logger.info("************ Search After entry Details Verify the Email Id **********");
	   homePage.search();
	   logger.info("************ Check the Details are created  **********");
	}

	@Then("^logout page sucessfully working$")
	public void logout_page_sucessfully_working() throws Throwable {
		Thread.sleep(3000);
		loginpage.SetLogout();
		logger.info("************ LogOut Button **********");
	}

	@Then("^Browser will be close$")
	public void browser_will_be_close() throws Throwable {
	  driver.quit();
	}
}
