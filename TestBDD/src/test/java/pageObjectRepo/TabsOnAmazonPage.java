package pageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.LoginSteps;

public class TabsOnAmazonPage {
	static String buttonName;
	@FindBy(xpath = "")
	private WebElement button;

	public TabsOnAmazonPage() {
		PageFactory.initElements(LoginSteps.driver, this);
	}

	public static WebElement getXpathOfTheTab() {
	
		String xpath = "//div[@id='nav-main']/descendant::div[@id=\"nav-xshop\"]/descendant::a[contains(text(),'"
				+ buttonName + "')]";
		
		return LoginSteps.driver.findElement(By.xpath(xpath));
	}

	public WebElement getButton() {
		return button;
	}

	public void setButton(WebElement button) {
		this.button = button;
	}

	public void clickOnTab() {
		TabsOnAmazonPage.getXpathOfTheTab().click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
