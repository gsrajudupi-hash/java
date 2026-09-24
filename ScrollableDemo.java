package jdbcdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Author   : rajgs
 * Date     : 24 Sept 2026
 * Time     : 3:50:44 pm
 * Project  : AdvancedJava
 */

public class ScrollableDemo {

	public static void main(String[] args) {
		try (Connection con = ConnectionUtil.createConnection();
				Statement stmt = con.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM candidates")) {

			System.out.println("********** Display Records from Top to Bottom ********* ");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}

			System.out.println("********** Display Records from Bottom to Top ********* ");
			rs.afterLast();
			while (rs.previous()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}

			System.out.println("***************** Display 50th Record ***********************");
			if (rs.absolute(50)) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			System.out.println("**********************************************************");

			System.out.println("************ Display 40th record using relative() ***********");
			if (rs.relative(-10)) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			System.out.println("**********************************************************");

			System.out.println("************ Display First record using first() ***********");
			if (rs.first()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			System.out.println("**********************************************************");

			rs.absolute(4);
			System.out.println("Current Cursor Position : " + rs.getRow());

			rs.last();
			System.out.println("Total no. of Records: " + rs.getRow());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
