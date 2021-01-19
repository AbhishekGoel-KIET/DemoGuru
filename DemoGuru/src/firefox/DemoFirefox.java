package firefox;

public class DemoFirefox {

	public static void main(String[] args) {

		FirefoxProject guru = new FirefoxProject();
		guru.invokeBrowser();
		guru.loginToGuru99("mngr304066", "egUzaja");
		guru.addCustomer();
		guru.customerDetails("Rahul J", "m", "Flat No 7 Street 2", "Delhi", "New Delhi", "110055", "9000000013",
				"Paswrd@123");

		String CustID = guru.getCustID();
		System.out.println("Customer ID : " + CustID);

		guru.addAccount(CustID);
		String accountID = guru.getAccountID();
		System.out.println("Account ID : " + accountID);

		String InitialBalance = guru.initialBalance();
		System.out.println("Initial Balance : " + InitialBalance);

		// Deposit into an Account Number and Get the Transaction ID and Balance After
		// Deposit
		guru.deposit(accountID);

		String depositTransID = guru.getDepositTransactionID();
		System.out.println("Deposit Transaction ID : " + depositTransID);
		// System.out.println("Deposit Transaction ID : " +
		// guru.getDepositTransactionID());

		String balanceAfterDeposit = guru.getBalanceAfterDeposit();
		System.out.println("Balance After Deposit : " + balanceAfterDeposit);
		// System.out.println("Balance After Deposit : " +
		// guru.getBalanceAfterDeposit());

		// Withdrawal from an Account Number and Get the Transaction ID and Balance
		// After Withdrawal
		guru.withdrawl(accountID);
		String withdrawTransID = guru.getWithdrawTransactionID();
		System.out.println("Withdrawal Transaction ID : " + withdrawTransID);
		// System.out.println("Withdrawal Transaction ID : " +
		// guru.getWithdrawTransactionID());

		String balanceAfterWithdrawal = guru.getBalanceAfterWithdrawal();
		System.out.println("Balance After Withdrawal : " + balanceAfterWithdrawal);
		// System.out.println("Balance After Withdrawal : " +
		// guru.getBalanceAfterWithdrawal());

		guru.miniStatement(accountID);

		// guru.closeBrowser();

	}

}