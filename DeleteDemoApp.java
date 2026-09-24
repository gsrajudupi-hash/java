package jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// DAO class for Candidate operations
class CandidateDAO1 {

    private final Connection con;

    public CandidateDAO1(Connection con) {
        this.con = con;
    }

    // Delete candidate by last name pattern
    public int deleteByLastNamePattern(String pattern) throws SQLException {
        String sql = "DELETE FROM candidates WHERE RTRIM(last_name) LIKE ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, pattern);
            return pstmt.executeUpdate();
        }
    }

    // Delete candidate by ID
    public int deleteById(int id) throws SQLException {
        String sql = "DELETE FROM candidates WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }
}

// Main application class
public class DeleteDemoApp {

    public static void main(String[] args) {
        System.out.println("*********** Delete Candidate ********");

        try (Connection con = ConnectionUtil.createConnection();
             Scanner sc = new Scanner(System.in)) {

            CandidateDAO1 dao = new CandidateDAO1(con);

            // Ask user which option they want
            System.out.println("Choose delete option:");
            System.out.println("1. Delete by Last Name Pattern");
            System.out.println("2. Delete by ID");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            int cnt = 0;
            if (choice == 1) {
                System.out.print("Enter last name pattern (e.g., Y%g): ");
                String pattern = sc.nextLine();
                cnt = dao.deleteByLastNamePattern(pattern);

            } else if (choice == 2) {
                System.out.print("Enter candidate ID: ");
                int id = sc.nextInt();
                cnt = dao.deleteById(id);

            } else {
                System.out.println("Invalid choice!");
                return;
            }

            if (cnt > 0) {
                System.out.println(cnt + " record(s) deleted.");
            } else {
                System.out.println("No matching record found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
