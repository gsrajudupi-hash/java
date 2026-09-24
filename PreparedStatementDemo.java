package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Author   : rajgs
 * Date     : 24 Sept 2026
 * Time     : 3:27:51 pm
 * Project  : AdvancedJava
 * 
 * JDBC PreparedStatement Example to retrieve records from MySQL Database
 * table using PreparedStatement.
 *
 * PreparedStatement is used to execute parameterized queries.
 * It is more efficient and secure than Statement.
 */

public class PreparedStatementDemo {
	
	public static void main(String[] args) {
		

        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password = "redhat";

        String sql = "SELECT customerNumber, customerName, city, country FROM customers WHERE country=?";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = con.prepareStatement(sql);
                Scanner scan = new Scanner(System.in)
        ) {

            System.out.println("Enter Country name of Customers to be displayed :");
            String country = scan.next();

            // Assign value to input parameter of PreparedStatement
            pstmt.setString(1, country);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
                }
            }

            System.out.println("*****************************************");

            System.out.println("Enter Country name of Customers to be displayed :");
            String country1 = scan.next();

            // Reuse PreparedStatement
            pstmt.setString(1, country1);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

		
	}

}
