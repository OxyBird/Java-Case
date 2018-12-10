package runner;

 import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.CustomerDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRunner {

	public void method1() throws SQLException {
		String ssn;
		

		String selection1 = "\nPlease enter a valid Social Security Number \n" + "";
		System.out.print(selection1);
		Scanner input = new Scanner(System.in);
		ssn = input.next();

		
		CustomerDaoImpl CustDaoimpl1 = new CustomerDaoImpl();
		CustDaoimpl1.CheckCustomer(ssn);
	}

	public void method2() throws SQLException {
		Boolean found;
		String CUST_ZIP, CUST_PHONE; 
		String FIRST_NAME, MIDDLE_NAME, LAST_NAME, CREDIT_CARD_NO, APT_NO, STREET_NAME, CUST_CITY, CUST_STATE;
		String CUST_COUNTRY, CUST_EMAIL, SSN;
		int menu;
		String expression = "AK|AL|AR|AZ|CA|CO|CT|DC|DE|FL|GA|HI|IA|ID|IL|IN|KS|KY|LA|MA|MD|ME|MI|MN|MO|MS|MT|NC|ND|NE|NH|NJ|NM|NV|NY|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VA|VT|WA|WI|WV|WY" 
                + "ak|al|ar|az|ca|co|ct|dc|de|fl|ga|hi|ia|id|il|in|ks|ky|la|ma|md|me|mi|mn|mo|ms|mt|nc|nd|ne|nh|nj|nm|nv|ny|oh|ok|or|pa|ri|sc|sd|tn|tx|ut|va|vt|wa|wi|wv|wy";


		
		Scanner input = new Scanner(System.in);

		String selection1 = "\nPlease enter a valid Social Security Number to modify the record \n" + "";
		System.out.print(selection1);
		SSN = input.next();

		while (SSN.length() != 9) {
			System.out.print("*************************************\n");
			System.out.print("***You have entered invalid Number***\n");
			System.out.print("*************************************\n");
			System.out.print(selection1);
			SSN = input.next();
		}	
		String selection = "\nSelect the number from the following menu you would like to modify. \n \n" 
				+ "1. Name Fields \n"
				+ "2. Address \n"
				+ "3. Phone \n"
				+ "4. Email \n"; 
				
		System.out.print(selection);
		menu = input.nextInt();

		while (menu < 1 || menu > 4) {
			System.out.print("******************************************\n");
			System.out.print("*** You have entered invalid selection ***\n");
			System.out.print("******************************************\n");
			System.out.print(selection);
			menu = input.nextInt();
		}

		switch (menu) {
		case 1:
			System.out.print("Enter First Name: ");
			FIRST_NAME = input.next();
			System.out.print("Enter Middle Name: ");
			MIDDLE_NAME = input.next();
			System.out.print("Enter Last Name: ");
			LAST_NAME = input.next();
			CustomerDaoImpl CustDaoimpl2a = new CustomerDaoImpl();
			CustDaoimpl2a.ModifyCustomerName(SSN, FIRST_NAME, MIDDLE_NAME, LAST_NAME);
			//CustDaoimpl2a.ModifyCustomerName(FIRST_NAME, MIDDLE_NAME, LAST_NAME);
			
			//ModifyCustomerName(String SSN, String FIRST_NAME, String MIDDLE_NAME, String LAST_NAME) throws SQLException; //
			
			
		 	break; 
		case 2:
			System.out.print("Enter Apartment NO: ");
			APT_NO = input.next();
			System.out.print("Enter Street Name: ");
			STREET_NAME = input.next();
			System.out.print("Enter City: ");
			CUST_CITY = input.next();
			System.out.print("Enter State: ");
			CUST_STATE = input.next();
	        CharSequence inputStr = CUST_STATE;
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(inputStr);
     
            while (!matcher.matches()) {
		          System.out.print("************************************\n");
		          System.out.print("***You have entered invalid State***\n");
		          System.out.print("************************************\n");
		          System.out.print("Enter State: ");
		          CUST_STATE = input.next();
		          inputStr = CUST_STATE;
                  pattern = Pattern.compile(expression);
                  matcher = pattern.matcher(inputStr);
	        }
			
			System.out.print("Enter Country: ");
			CUST_COUNTRY = input.next();
			System.out.print("Enter Zip: ");
			CUST_ZIP = input.next();
			while (CUST_ZIP.length() != 5) {
				System.out.print("****************************************\n");
				System.out.print("***You have entered invalid zip code ***\n");
				System.out.print("****************************************\n");
				System.out.print("Enter Zip: ");
				CUST_ZIP = input.next();
			}	
		 	CustomerDaoImpl CustDaoimpl2b = new CustomerDaoImpl();
		 	CustDaoimpl2b.ModifyCustomerAdd(SSN, APT_NO,STREET_NAME, CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP);
		 	break;
		case 3:
			System.out.print("Enter 7 digit Phone number: ");
			CUST_PHONE = input.next();
			while (CUST_PHONE.length() != 7) {
				System.out.print("********************************************\n");
				System.out.print("***You have entered invalid Phone number ***\n");
				System.out.print("********************************************\n");
				System.out.print("Enter Phone number:  ");
				CUST_PHONE = input.next();
			}	
		 	CustomerDaoImpl CustDaoimpl2c = new CustomerDaoImpl();
		 	CustDaoimpl2c.ModifyCustomerPhone(SSN, CUST_PHONE);
		 	break;
		case 4:
			
			do {
			System.out.print("Enter Email: ");
			CUST_EMAIL = input.next();
			//below checking correct email  - should contain special character @
			if (!(CUST_EMAIL.contains("@")))
			{
			System.out.println("You entered invalid email address.Try again");
			CUST_EMAIL = "";
			}
											
			} while (CUST_EMAIL == "");
		 	
			
			CustomerDaoImpl CustDaoimpl2d = new CustomerDaoImpl();
		 	CustDaoimpl2d.ModifyCustomerEmail(SSN, CUST_EMAIL);
		 	break;
		default:
			System.out.println("It is not a correct #");
		}	
	}
	
	public void method3() throws SQLException {
		String creditCard;
		int month, year;
		Scanner input = new Scanner(System.in);

		String selection1 = "\nPlease enter a valid Credit Card Number \n" + "";
		System.out.print(selection1);
		creditCard = input.next();

		while (creditCard.length() != 16) {
			System.out.print("*************************************\n");
			System.out.print("***You have entered invalid Number***\n");
			System.out.print("*************************************\n");
			System.out.print(selection1);
			creditCard = input.next();
		}

		String selection2 = "\nPlease enter a valid Month as MM \n" + "";
		System.out.print(selection2);
		month = input.nextInt();
		while (month < 1 || month > 12) {
			System.out.print("************************************\n");
			System.out.print("***You have entered invalid Month***\n");
			System.out.print("************************************\n");
			System.out.print(selection2);
			month = input.nextInt();
		}

		String selection3 = "\nPlease enter a valid year between " + "1950 to 2018 as YYYY  \n" + "";
		System.out.print(selection3);
		year = input.nextInt();
		while (year < 1900 || year > 2018) {
			System.out.print("***********************************\n");
			System.out.print("***You have entered invalid Year***\n");
			System.out.print("***********************************\n");
			System.out.print(selection3);
			year = input.nextInt();

		}
		CustomerDaoImpl CustDaoimpl3 = new CustomerDaoImpl();
		CustDaoimpl3.GenerateBill(creditCard, month, year);
	}

	public void method4() throws SQLException {
		String ssn;
		int fromYear, toYear, fromMonth, toMonth, fromDay, toDay;
		Scanner input = new Scanner(System.in);

		String selection1 = "\nPlease enter a valid Social Security Number \n" + "";
		System.out.print(selection1);
		ssn = input.next();

		while (ssn.length() != 9) {
			System.out.print("*************************************\n");
			System.out.print("***You have entered invalid Number***\n");
			System.out.print("*************************************\n");
			System.out.print(selection1);
			ssn = input.next();
		}

		String selection2 = "\nPlease enter a valid year between " + "1950 to 2018 as YYYY from  \n" + "";
		System.out.print(selection2);
		fromYear = input.nextInt();
		String selection3 = "\nPlease enter a valid year between " + "1950 to 2018 as YYYY to \n" + "";
		System.out.print(selection3);
		toYear = input.nextInt();
		while (fromYear < 1900 || fromYear > 2018) {
			System.out.print("***********************************\n");
			System.out.print("***You have entered invalid Year***\n");
			System.out.print("***********************************\n");
			System.out.print(selection3);
			fromYear = input.nextInt();
		}
		
		String selection4 = "\nPlease enter a valid Month as MM from \n" + "";
		System.out.print(selection4);
		fromMonth = input.nextInt();
		String selection5 = "\nPlease enter a valid Month as MM to \n" + "";
		System.out.print(selection5);
		toMonth = input.nextInt();
		while (fromMonth < 1 || fromMonth > 12) {
			System.out.print("************************************\n");
			System.out.print("***You have entered invalid Month***\n");
			System.out.print("************************************\n");
			System.out.print(selection5);
			fromMonth = input.nextInt();
		}

		String selection6 = "\nPlease enter a valid Day as DD from \n" + "";
		System.out.print(selection6);
		fromDay = input.nextInt();
		String selection7 = "\nPlease enter a valid Day as DD to \n" + "";
		System.out.print(selection7);
		toDay = input.nextInt();
		while (fromDay < 1 || fromDay > 30) {
			System.out.print("************************************\n");
			System.out.print("***You have entered invalid Day ***\n");
			System.out.print("************************************\n");
			System.out.print(selection5);
			fromDay = input.nextInt();
		}
		CustomerDaoImpl CustDaoimpl4 = new CustomerDaoImpl();
		CustDaoimpl4.DisplayTrans(ssn, fromYear, toYear, fromMonth, toMonth, fromDay, toDay);
	}
}
