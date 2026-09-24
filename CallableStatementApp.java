package jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// DAO class for Skills operations
class SkillsDAO {

    private final Connection con;

    public SkillsDAO(Connection con) {
        this.con = con;
    }

    // Call stored procedure to get candidate skills
    public void getSkills(int candidateId) throws SQLException {
        String sql = "{ call get_candidate_skill(?) }";
        try (CallableStatement cstmt = con.prepareCall(sql)) {
            cstmt.setInt(1, candidateId);

            try (ResultSet rs = cstmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("No Skills");
                } else {
                    while (rs.next()) {
                        System.out.println(
                            rs.getString("first_name") + " " +
                            rs.getString("last_name") + " - " +
                            rs.getString("skill")
                        );
                    }
                }
            }
        }
    }
}

// Main application class
public class CallableStatementApp {

    public static void main(String[] args) {
        System.out.println("*********** Candidate Skills via Stored Procedure ********");

        try (Connection con = ConnectionUtil.createConnection();
             Scanner sc = new Scanner(System.in)) {

            SkillsDAO dao = new SkillsDAO(con);

            System.out.print("Enter Candidate ID: ");
            int id = sc.nextInt();

            dao.getSkills(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
