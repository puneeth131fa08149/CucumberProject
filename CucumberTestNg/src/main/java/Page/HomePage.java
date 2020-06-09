package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utlities.testBase;

public class HomePage extends testBase {
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	//Identify webElements
	@FindBy(how = How.XPATH,using = "//a[@href='#']//span[contains(text(),'Customers')]")
	WebElement CustomersMenu;
	
	@FindBy(how = How.XPATH,using ="//a[@href='/Admin/Customer/List']//span[contains(text(),'Customers')]")
	WebElement customerMenuItem;
	
	@FindBy(how = How.XPATH,using ="//a[@class='btn bg-blue']")
	WebElement addButton;
	
	@FindBy(how= How.XPATH, using ="//input[@name='Email']")
	WebElement Email_text;
	
	@FindBy(how=How.XPATH,using ="//input[@id='Password']")
	WebElement Password_text;
	
	@FindBy(how= How.XPATH,using ="//input[@id='FirstName']")
	WebElement FirstName_text;
	
	@FindBy(how= How.XPATH,using ="//input[@name='LastName']")
	WebElement LastName_text;
	
	@FindBy(how= How.ID,using ="Gender_Male")
	WebElement Gender;
	
	
	@FindBy(how= How.XPATH,using ="//input[@name='DateOfBirth']")
	WebElement DOB_date;
	
	@FindBy(how= How.XPATH,using ="//input[@id='Company']")
	WebElement Company_name_text;
	
	@FindBy(how= How.XPATH,using ="//input[@name='IsTaxExempt']")
	WebElement is_tax_empty_chbox;
	
	@FindBy(how= How.XPATH,using ="(//div[@class='k-multiselect-wrap k-floatwrap' and @role='listbox'])[1]")
	WebElement Newsletter_chbox;
	
	@FindBy(how= How.XPATH,using ="//li[contains(text(),'Test store 2')]")
	WebElement Test_store2_chbox;
	
	@FindBy(how= How.XPATH,using ="//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement Customer_role_drpdn;
	
	
	By AlreadySelected_custrole = By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[contains(text(),'Registered')]");
	By Administrators_option = By.xpath("//li[contains(text(),'Administrators')]");
	By ForumModerators_option  = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By Guest_option = By.xpath("//li[contains(text(),'Guests')]");
	By Vendors_option = By.xpath("//li[contains(text(),'Vendors')]");
	
	@FindBy(how=How.XPATH,using="//select[@name='VendorId']")
	WebElement Manager_of_vendor;
	
	By Vendor_1 = By.xpath("//option[contains(text(),'Vendor 1')]");
	By Vendor_2 = By.xpath("//option[contains(text(),'Vendor 2')]");
	
	@FindBy(how=How.XPATH,using="//input[@name='Active']")
	WebElement Active_chbox;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='AdminComment']")
	WebElement Admin_comment;
	
	@FindBy(how=How.XPATH, using ="//button[@name='save']")
	WebElement save_button;
	
	@FindBy(how=How.ID, using ="SearchEmail")
	WebElement Email_Search;
	
	@FindBy(how=How.ID, using ="search-customers")
	WebElement Search;
	
	//select//option[contains(text(),'Vendor 1')]
	
	//action methods for elements identified
	public void clickCustomersMenu()  {
		CustomersMenu.click();
		
	}
	
	public void clickCustomerMenuItem() {
		customerMenuItem.click();
	}
	
	public void clickOnAddbutton() {
		addButton.click();
	}
	
	public void Enter_email(String string) {
		Email_text.sendKeys(string);
	}
	
	public void Enter_password(String string) {
		Password_text.sendKeys(string);
	}
	
	public void Enter_Frist_Name(String string) {
		FirstName_text.sendKeys(string);
	}
	
	public void Enter_Last_Name(String string) {
		LastName_text.sendKeys(string);
	}
	
	public void select_gender() {
		Gender.click();
	}
	
	public void Enter_DOB(String date) {
		DOB_date.sendKeys(date);
	}
	
	public void Enter_company_name(String compname) {
		Company_name_text.sendKeys(compname);
	}
	
	public void clickOn_is_taxempty() {
		is_tax_empty_chbox.click();
	}
	
//	public void cickOn_Newsletter() {
//		Newsletter_chbox
//	}
//	
//	public void select_customerRole(String role) {
	
		
	//	}
	
	public void select_vendor(String vendorID) {
		Select vendor = new Select(Manager_of_vendor);
		
		if(vendorID.equals("Vendor 1")) {
			vendor.selectByVisibleText("Vendor 1");
		}
		else if(vendorID.equals("Vendor 2")) {
			vendor.selectByVisibleText("Vendor 2");
		}
			
		
	}
	
	public void activeChbx_status() {
	boolean status = Active_chbox.isSelected();
	System.out.println("Active staus is" + status);
	}
	
	public void AddAdmin_comments(String string) {
		Admin_comment.sendKeys(string);
	}
	
	public void click_save() {
		save_button.click();
			}
	
	public void Email_search(String string) {
		Email_Search.sendKeys(string);;
			}
	public void search() {
		Search.click();
			}


}
