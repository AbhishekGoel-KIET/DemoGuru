package flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartProject {
	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Implicit Wait
		driver.navigate().to("https://www.flipkart.com/");
	}

	public void closePopup() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	}

	public void selectSamsung() {
		Actions action = new Actions(driver);
		WebElement electronicsLink = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/span[1]"));
		action.moveToElement(electronicsLink).build().perform();
		//Explicit Wait
		waitTillElementVisible(By.xpath(
				"//div[contains(@class, '_1QrT3s')]/div[contains(@class, '_1fwVde')]/a[contains(@class, '_3QN6WI')][4]"), 10);
		action.moveToElement(driver.findElement(By.xpath(
				"//div[contains(@class, '_1QrT3s')]/div[contains(@class, '_1fwVde')]/a[contains(@class, '_3QN6WI')][4]")))
				.click().build().perform();
	}

	private void waitTillElementVisible(By by, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

}
