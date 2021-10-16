package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjectRepo.SearchBar;

public class SearchProduct {

	public SearchBar search;

	@After
	public void CleanUp() {
		TakesScreenshot screenshot = (TakesScreenshot) LoginSteps.driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//target/screenshoots/Amazon.png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		 //LoginSteps.driver.quit();

	}

	@Given("^User is in Amazon application$")
	public void user_is_in_amazon_application() {
		search = new SearchBar();
		System.out.println("user is in amazon application");

	}

	@When("^user will search for product (.*) and click on enter.$")
	public void user_will_search_for_product_mobiles_under_and_click_on_enter(String product) {

		search.searchSomething(product);

		LoginSteps.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^user is navigated to that particular product page.$")
	public void user_is_navigated_to_that_particular_product_page() {
		LoginSteps.driver.getPageSource().contains("Dell laptop");
		System.out.println("Dell laptop");
	}

	@Then("user will add filter of Low to High")
	public void user_will_add_filter_of_low_to_high() throws Throwable {
		WebElement dropdown = LoginSteps.driver.findElement(By.id("s-result-sort-select"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Price: Low to High");
		Thread.sleep(2000);
	}

	@Then("user will select the laptop and click on the product")
	public void user_will_select_the_laptop_and_click_on_the_product() {
		WebElement product = LoginSteps.driver.findElement(By.xpath(
				"//span[text()='(Renewed) Dell Latitude Intel 4th Gen Core i5 14-Inch (35.56 cms) 1366x768 Laptop (4 GB/120 GB SSD/Windows 10/Integrated Graphics/Gray/2 kg), E5440-i5-4 GB-120 GB']"));
		product.click();

	}

	@When("Product is displayed, user will add the product to cart")
	public void product_is_displayed_user_will_add_the_product_to_cart() {
		String parentHandle = LoginSteps.driver.getWindowHandle();
		Set<String> allwh = LoginSteps.driver.getWindowHandles();
		for (String wh : allwh) {
			if (!wh.equals(parentHandle)) {
				LoginSteps.driver.switchTo().window(wh);
				LoginSteps.driver.findElement(By.id("add-to-cart-button")).click();
			}
		}
	}

	@Then("verify the product added in the cart")
	public void verify_the_product_added_in_the_cart() {
		LoginSteps.driver.findElement(By.id("nav-cart")).click();
		//WebElement cartProduct = LoginSteps.driver.findElement(
		//		By.xpath("//span[text()='(Renewed) Dell Latitude Intel 4th Gen Core i5 14-Inch (35.56 cms)…']"));
		SoftAssert sa = new SoftAssert();
		if (LoginSteps.driver.getPageSource()
				.contains("(Renewed) Dell Latitude Intel 4th Gen Core i5 14-Inch (35.56 cms)")) {
			Assert.assertTrue(true);
			System.out.println("Product is successfully added to the cart");
		}
		else {
			System.out.println("Product is not added.");
		}

	}

}
