package w3Schools;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FrameAndAlertHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver;

		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert	");
		
		/*
		 * DesiredCapabilities dCap = new DesiredCapabilities();
		 * dCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 */
	

		driver.switchTo().frame("iframeResult");
		// To switch back from a frame
		// driver.switchTo().defaultContent();
		driver.findElement(By.tagName("button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(5000);
		alert.accept();
		// alert.dismiss();

	}

}
