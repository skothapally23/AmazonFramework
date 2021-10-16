package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadOptionPage {
	@FindBy(xpath ="//div[text()='UPDATE PROFILE']") private WebElement update;
	@FindBy(xpath="//div[@class='attachCV']/descendant::i[@class='icon']") private WebElement download;
	
	public DownloadOptionPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getUpdate() {
		return update;
	}

	public WebElement getDownload() {
		return download;
	}
	
	public void updateResume() {
		update.click();
	}
	public void DownloadOption() {
		download.click();
	}

}
