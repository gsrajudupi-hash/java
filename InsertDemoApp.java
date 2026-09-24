package jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Author   : rajgs
 * Date     : 24 Sept 2026
 * Time     : 3:57:32 pm
 * Project  : AdvancedJava
 */
//DAO class for Skills table
class SkillDAO {

	private final Connection con;

	public SkillDAO(Connection con) {
		this.con = con;
	}

	// Insert a new skill
	public int insertSkill(String skillName) throws SQLException {
		String insertSql = "INSERT INTO skills(name) VALUES(?)";
		try (PreparedStatement ps = con.prepareStatement(insertSql)) {
			ps.setString(1, skillName);
			return ps.executeUpdate();
		}
	}

	// Display all skills
	public void displayAllSkills() throws SQLException {
		String selectSql = "SELECT id, name FROM skills";
		try (PreparedStatement ps = con.prepareStatement(selectSql);
				ResultSet rs = ps.executeQuery()) {

			System.out.println("\nAll Records in Skills Table:");
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") +
						", Name: " + rs.getString("name"));
			}
		}
	}

	// Count total records
	public int countSkills() throws SQLException {
		String countSql = "SELECT COUNT(id) FROM skills";
		try (PreparedStatement ps = con.prepareStatement(countSql);
				ResultSet rs = ps.executeQuery()) {

			if (rs.next()) {
				return rs.getInt(1);
			}
		}
		return 0;
	}
}
//JDBC Code to Insert Records to table
public class InsertDemoApp {

	public static void main(String[] args) {
		try (Connection con = ConnectionUtil.createConnection();
				Scanner sc = new Scanner(System.in)) {

			SkillDAO dao = new SkillDAO(con);

			// Take input from user
			System.out.print("Enter Skill Name: ");
			String skillName = sc.nextLine();

			// Insert record
			int count = dao.insertSkill(skillName);
			if (count > 0) {
				System.out.println(count + " Record Inserted Successfully");
			}

			// Display all records
			dao.displayAllSkills();

			// Count total records
			int total = dao.countSkills();
			System.out.println("\nTotal no. of records is: " + total);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
