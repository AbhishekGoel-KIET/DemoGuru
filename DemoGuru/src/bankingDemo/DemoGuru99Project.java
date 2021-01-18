package bankingDemo;

public class DemoGuru99Project {

	public static void main(String[] args) {

		Guru99Project guru = new Guru99Project();
		guru.invokeBrowser();
		guru.loginToGuru99("mngr304066", "egUzaja");
		guru.addCustomer();
		guru.customerDetails("Abhishek", "m", "Flat No 7 Street 2", "Meerut", "UP", "250001", "9000000001",
				"Password@123");
		

		String CustID = guru.getCustID();
		System.out.println("Customer ID : " + CustID);
		
		guru.closeBrowser();
		
	}

}
