package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	public static WebDriver driver ;

	// public static WebDriver driver= new FirefoxDriver();
//	@Given("^user launch chrome browser and enter url$")
//	public void user_launch_chrome_browser_and_enter_url() {
//		if()
//		driver.get("http:www.amazon.in");
//		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
//	}

	@Given("user launch {string} browser and enter url")
	public void user_launch_browser_and_enter_url(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("Webdriver.gecko.driver", "C:\\Users\\sravanthi.kothapally\\eclipse-workspace\\TestBDD\\src\\main\\resources\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
		}
		else {
			System.out.println("Browsers should be only chrome or firefox");
			
		}
		driver.get("http:www.amazon.in");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	}

	@When("^i will enter valid Email or mobile phone number$")
	public void i_will_enter_valid_email_or_mobile_phone_number() {
		driver.findElement(By.id("ap_email")).sendKeys("8096106044");
	}

	@And("^click on continue$")
	public void click_on_continue() {
		driver.findElement(By.id("continue")).click();
	}

	@Then("^it will redirected to another page to enter password$")
	public void it_will_redirected_to_another_page_to_enter_password() {
		driver.findElement(By.id("ap_password")).sendKeys("sravanthisravs");
	}

	@And("^click on signin$")
	public void click_on_signin() {
		driver.findElement(By.id("signInSubmit")).click();
	}

	@Then("^It will navigate to home page.$")
	public void it_will_navigate_to_home_page() {

		System.out.println("Now we are in amazon home page");
	}
}
