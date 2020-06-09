package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utlities.testBase;

public class LoginPage extends testBase{
	@FindBy(how=How.ID,using="Email") WebElement email;
	@FindBy(how=How.ID,using="Password") WebElement password;
	@FindBy(how=How.XPATH,using="//input[@class='button-1 login-button']") WebElement Login;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Logout')]") WebElement Logout;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un ,String pwd) {
		email.clear();
		email.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		Login.click();
		return new HomePage();
	}

	public HomePage SetLogout() {
		Logout.click();
		
		return new HomePage();
	}
}
