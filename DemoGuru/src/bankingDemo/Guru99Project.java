package bankingDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99Project {
	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("http://demo.guru99.com/v4/");
	}

	public void closeBrowser() {

		driver.quit();
	}

	public void loginToGuru99(String username, String password) {

		// To perform Multiple Operations
		WebElement userElement;
		userElement = driver.findElement(By.name("uid"));
		userElement.sendKeys(username);

		// To perform single operation
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

	}

	public void addCustomer() {
		driver.findElement(By.linkText("New Customer")).click();

	}

	public void customerDetails(String name, String gender, String address, String city, String state, String pincode,
			String number, String password) {

		driver.findElement(By.name("name")).sendKeys(name);

		if (gender == "m") {
			driver.findElement(By.xpath("//input[@value='m']")).click();
		} else {
			driver.findElement(By.xpath("//input[@value='f']")).click();
		}

		driver.findElement(By.name("dob")).sendKeys("04/02/1990");
		driver.findElement(By.name("addr")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("pinno")).sendKeys(pincode);
		driver.findElement(By.name("telephoneno")).sendKeys(number);
		String emailid = "aa" + System.currentTimeMillis() + "@gmail.com";
		System.out.println(emailid); //Print the Email ID
		driver.findElement(By.name("emailid")).sendKeys(emailid);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("sub")).click();
	}
	
	public String getCustID() {
		return driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
				
	}

}
