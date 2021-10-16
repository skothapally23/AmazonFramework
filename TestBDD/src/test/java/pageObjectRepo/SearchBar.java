package pageObjectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.LoginSteps;

public class SearchBar {
	
	@FindBy(id="twotabsearchtextbox") private WebElement searchbar;

	public SearchBar() {
		
		PageFactory.initElements(LoginSteps.driver, this);
	}

	public WebElement getSearchbar() {
		return searchbar;
	}
	public void searchSomething(String search) {
		searchbar.sendKeys(search);
		searchbar.sendKeys(Keys.ENTER);
	}

	
	
	
	

}
