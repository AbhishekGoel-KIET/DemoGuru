package bankingDemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
		System.out.println(emailid); // Print the Email ID
		driver.findElement(By.name("emailid")).sendKeys(emailid);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("sub")).click();
	}

	public String getCustID() {
		String custID = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
		return custID;

	}

	public void addAccount(String custID) {
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.name("cusid")).sendKeys(custID);

		WebElement accountDropDown = driver.findElement(By.name("selaccount"));
		Select selectAccount = new Select(accountDropDown);
		selectAccount.selectByVisibleText("Savings");
		driver.findElement(By.name("inideposit")).sendKeys("100000");
		driver.findElement(By.name("button2")).click();
	}

	public String getAccountID() {
		return driver
				.findElement(
						By.xpath("//table[@id='account']/tbody/tr/td[text() = 'Account ID']//following-sibling::td"))
				.getText();

	}

	public String initialBalance() {
		return driver
				.findElement(By
						.xpath("//table[@id='account']/tbody/tr/td[text() = 'Current Amount']//following-sibling::td"))
				.getText();
	}

	public void deposit(String accountID) {
		driver.findElement(By.linkText("Deposit")).click();
		driver.findElement(By.name("accountno")).sendKeys(accountID);
		driver.findElement(By.name("ammount")).sendKeys("50000");
		driver.findElement(By.name("desc")).sendKeys("Testing the Deposit amount");
		driver.findElement(By.name("AccSubmit")).click();

	}

	public String getDepositTransactionID() {
		return driver
				.findElement(By
						.xpath("//table[@id='deposit']/tbody/tr/td[text() = 'Transaction ID']//following-sibling::td"))
				.getText();
	}

	public String getBalanceAfterDeposit() {
		return driver
				.findElement(By
						.xpath("//table[@id='deposit']/tbody/tr/td[text() = 'Current Balance']//following-sibling::td"))
				.getText();
	}

	public void withdrawl(String accountID) {
		driver.findElement(By.linkText("Withdrawal")).click();
		driver.findElement(By.name("accountno")).sendKeys(accountID);
		driver.findElement(By.name("ammount")).sendKeys("10000");
		driver.findElement(By.name("desc")).sendKeys("Testing the Withdrawl amount");
		driver.findElement(By.name("AccSubmit")).click();

	}

	public String getWithdrawTransactionID() {
		return driver
				.findElement(By
						.xpath("//table[@id='withdraw']/tbody/tr/td[text() = 'Transaction ID']//following-sibling::td"))
				.getText();
	}

	public String getBalanceAfterWithdrawal() {
		return driver
				.findElement(By.xpath(
						"//table[@id='withdraw']/tbody/tr/td[text() = 'Current Balance']//following-sibling::td"))
				.getText();
	}

	public void miniStatement(String accountID) {
		driver.findElement(By.linkText("Mini Statement")).click();
		driver.findElement(By.name("accountno")).sendKeys(accountID);
		driver.findElement(By.name("AccSubmit")).click();
	}

}
