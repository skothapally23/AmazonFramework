package stepDefinitions;

import io.cucumber.java.en.Given;
import pageObjectRepo.TabsOnAmazonPage;

public class MultipleTabs {
	TabsOnAmazonPage tabsPage;

	@Given("User will click on any of the following tabs given below")
	public void user_will_click_on_any_of_the_following_tabs_given_below(io.cucumber.datatable.DataTable dataTable) {
		tabsPage = new TabsOnAmazonPage();
		tabsPage.clickOnTab();
	}

	@Given("User will click on any of the following tabs given below (.*)")
	public void user_will_click_on_any_of_the_following_tabs_given_below_all() {
		tabsPage = new TabsOnAmazonPage();
		tabsPage.clickOnTab();
	}

	@Given("User will click on any of the following tabs given below Fresh")
	public void user_will_click_on_any_of_the_following_tabs_given_below_fresh() {
		tabsPage = new TabsOnAmazonPage();
		tabsPage.clickOnTab();
	}

}
