package jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// DAO class for Candidate operations
class CandidateDAO {

    private final Connection con;

    public CandidateDAO(Connection con) {
        this.con = con;
    }

    // Update candidate's last name by ID
    public int updateCandidateLastName(int id, String newLastName) throws SQLException {
        String sqlUpdate = "UPDATE candidates SET last_name = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, newLastName);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate();
        }
    }
}

// Main application class
public class UpdateDemoApp {

    public static void main(String[] args) {
        System.out.println("*********** Update Candidate Details ********");

        try (Connection con = ConnectionUtil.createConnection();
             Scanner sc = new Scanner(System.in)) {

            CandidateDAO dao = new CandidateDAO(con);

            // Take input from user
            System.out.print("Enter Employee ID: ");
            int eid = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter employee's new last name: ");
            String newLastname = sc.nextLine();

            // Perform update
            int cnt = dao.updateCandidateLastName(eid, newLastname);
            System.out.println("Row affected: " + cnt);

            // Example reuse of DAO method
            cnt = dao.updateCandidateLastName(6, "Pandit");
            System.out.println("Row affected: " + cnt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    catch (Exception e) {
        e.printStackTrace();
    }
    }
}
