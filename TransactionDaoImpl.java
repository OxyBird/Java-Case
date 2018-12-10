package dao;

import java.sql.*;


public class TransactionDaoImpl implements TransactionDao {

	@Override
	public void getbyZipcode(String zip, int month, int year) throws SQLException {
/*
		String url = "jdbc:mysql://localhost:3306/cdw_sapp";
        String uname ="root";
        String passw = "root";
        //String query = "Select studentname from student where idstusdent = 1";
        
        String query = "Select * from student ";
        
        try {			Class.forName ("com.mysql.cj.jdbc.Driver");}
		catch (ClassNotFoundException e) 
		{			e.printStackTrace(); 			}	
        Connection con = DriverManager.getConnection(url, uname, passw);
*/		
		
		 Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;
		
		try {			Class.forName ("com.mysql.cj.jdbc.Driver");}
		catch (ClassNotFoundException e) 
		{			e.printStackTrace(); 			}	
			
			
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp","root","root");

			
			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query1);

			// 2a. set the parameter;
			myStmt.setString(1, zip);
			myStmt.setInt(2, month);
			myStmt.setInt(3, year);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println(myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR")
						+ " " + myRs.getString("CREDIT_CARD_NO") + "  " + myRs.getString("CUST_SSN")+ "  " + myRs.getString("BRANCH_CODE")
						+ " " + myRs.getString("TRANSACTION_TYPE") + "  " + myRs.getString("TRANSACTION_VALUE"));
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR")
					    + " " + myRs.getString("CREDIT_CARD_NO") + "  " + myRs.getString("CUST_SSN")+ "  " + myRs.getString("BRANCH_CODE")
						+ " " + myRs.getString("TRANSACTION_TYPE") + "  " + myRs.getString("TRANSACTION_VALUE"));
			}
		}
		
		catch (SQLException e) {
			 e.printStackTrace();
			
		}
		
		finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

	}

	@Override
	public void getbyType(String type) throws SQLException {

		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp", "root", "root");

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query2);

			// 2a. set the parameter;
			myStmt.setString(1, type);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println(myRs.getString("# of Transaction") + "  " + myRs.getString("Transaction Amount"));
						
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("# of Transaction") + "  " + myRs.getString("Transaction Amount"));
				
			}
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			
		}

	}

	@Override
	public void getbyState(String state) throws SQLException {
		Connection myConn = null;
		// Statement myStmt = null;
		PreparedStatement myStmt = null;

		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp", "root", "root");

			System.out.println("Database connection successful!\n");

			// 2. Create a statement
			myStmt = myConn.prepareStatement(SqlFile.query3);

			// 2a. set the parameter;
			myStmt.setString(1, state);

			// 3. Execute SQL query
			myRs = myStmt.executeQuery();

			if (myRs.next() == false) {
				System.out.println("***********************************");
				System.out.println("No information for your selection !");
				System.out.println("***********************************");
			} else {
				System.out.println(myRs.getString("# of Transaction") + "  " + myRs.getString("Transaction Amount"));
			}
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("# of Transaction") + "  " + myRs.getString("Transaction Amount"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

	}
}


