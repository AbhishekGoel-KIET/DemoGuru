package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonProject {

	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://www.amazon.in");
	}

	public void selectPrimeMusic() {
		Actions action = new Actions(driver);
		WebElement searchCat = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
		action.moveToElement(searchCat).build().perform();
		action.moveToElement(searchCat).click().build().perform();
		
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[12]/a/div"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[12]/a/div"))).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[7]/li[3]/a")).click();

	}
}
