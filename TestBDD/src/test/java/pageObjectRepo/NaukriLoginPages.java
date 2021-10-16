package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.NaukriLoginSteps;

public class NaukriLoginPages {
	@FindBy(xpath="//div[text()='Login']")private WebElement loginIcon;
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")private WebElement username;
	@FindBy(xpath = "//input[@type='password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement loginTab;
	//WebDriver driver;
	public NaukriLoginPages(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLoginIcon() {
		return loginIcon;
	}
	public void setLoginIcon(WebElement loginIcon) {
		this.loginIcon = loginIcon;
	}
	public WebElement getUsername() {
		return username;
	}
	public void setUsername(WebElement username) {
		this.username = username;
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword(WebElement password) {
		this.password = password;
	}
	public WebElement getLoginTab() {
		return loginTab;
	}
	public void setLoginTab(WebElement loginTab) {
		this.loginTab = loginTab;
	}
	public void icon() {
		loginIcon.click();
	}
	public void login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginTab.click();
	}
	

}
