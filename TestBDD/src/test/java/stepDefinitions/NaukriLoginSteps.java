//package stepDefinitions;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.openqa.selenium.OutputType;
////import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.google.common.io.Files;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pageObjectRepo.DownloadOptionPage;
//import pageObjectRepo.NaukriLoginPages;
//
//public class NaukriLoginSteps {
//
//	public static WebDriver driver = new ChromeDriver();
//	NaukriLoginPages lp;
//	DownloadOptionPage dp;
//
//	@Before
//	public void setUp() {
//		System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
//	}
//
//	@After
//	public void teardown() {
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File src = screenshot.getScreenshotAs(OutputType.FILE);
//		File dest = new File(".//target/screenshoots/Image1.png");
//		try {
//			Files.copy(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		driver.quit();
//
//	}
//
//	@Given("^open browser and enter url$")
//	public void open_browser_and_enter_url() {
//
//		driver.get("http:www.naukri.com");
//
//	}
//
//	@When("^Enter (.*) and (.*)$")
//	public void enter_skothapally23_gmail_com_and_sravanthisravs(String username, String password) throws Throwable {
//		lp = new NaukriLoginPages(driver);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		String parentTitle = driver.getWindowHandle();
//		Set<String> allwh = driver.getWindowHandles();
//		for (String wh : allwh) {
//			
//			if (!wh.equals(parentTitle)) {
//				driver.switchTo().window(wh);
//				Thread.sleep(2000);
//				driver.close();
//			} 
//		}
//		driver.switchTo().window(parentTitle);
//		Thread.sleep(2000);
//		lp.icon();
//		lp.login(username, password);
//		System.out.println(parentTitle);
//	}
//
//	@And("^click on signin$")
//	public void click_on_signin() {
//		System.out.println("After clicking on signin button, User is navigated to home page ");
//	}
//
//	@Then("^user click on update resume$")
//	public void user_click_on_update_resume() {
//		dp = new DownloadOptionPage(driver);
//		dp.updateResume();
//	}
//
//	@And("^Click on download arrow to download the resume.$")
//	public void click_on_download_arrow_to_download_the_resume() throws Throwable {
//		dp = new DownloadOptionPage(driver);
//		dp.DownloadOption();
//		Thread.sleep(5000);
//	}
//
//	@When("User wants to read data from downloaded file")
//	public void user_wants_to_read_data_from_downloaded_file() throws Throwable {
//
//		File file = new File("C:/Users/sravanthi.kothapally/Downloads/Resume.docx");
//
//		List<String> docLines = new ArrayList<String>();
//
//		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
//		XWPFDocument document = new XWPFDocument(fis);
//		List<XWPFParagraph> paragraphs = document.getParagraphs();
//		for (XWPFParagraph para : paragraphs) {
//		    docLines.add(para.getText());
//		}
//		fis.close();
//		
//		System.out.println(docLines.get(0));
//	}
//
//}
