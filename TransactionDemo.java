package jdbcdemo;

import java.sql.*;
import java.sql.Date;
import java.util.*;

// DAO class for Candidate operations
class CandidateDAO2 {

    private final Connection con;

    public CandidateDAO2(Connection con) {
        this.con = con;
    }

    // Insert candidate
    public void insertCandidate(String firstName, String lastName, Date dob, String phone, String email) throws SQLException {
        String sql = "INSERT INTO candidates(first_name, last_name, dob, phone, email) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setDate(3, dob);
            pstmt.setString(4, phone);
            pstmt.setString(5, email);
            pstmt.executeUpdate();
        }
    }

    // Batch insert candidates
    public void batchInsertCandidates(List<String[]> candidates) throws SQLException {
        String sql = "INSERT INTO candidates(first_name, last_name, dob, phone, email) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            for (String[] c : candidates) {
                pstmt.setString(1, c[0]);
                pstmt.setString(2, c[1]);
                pstmt.setDate(3, Date.valueOf(c[2])); // yyyy-MM-dd
                pstmt.setString(4, c[3]);
                pstmt.setString(5, c[4]);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
    }

    // Update candidate
    public void updateCandidate(int id, String newLastName) throws SQLException {
        String sql = "UPDATE candidates SET last_name = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, newLastName);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    // Delete candidate
    public void deleteCandidate(int id) throws SQLException {
        String sql = "DELETE FROM candidates WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}

// Main application demonstrating JDBC concepts
public class TransactionDemo {

    public static void main(String[] args) {
        System.out.println("*********** JDBC Concepts Demo ********");

        // Example: Connection pooling (in real apps use HikariCP, Apache DBCP, etc.)
        try (Connection con = ConnectionUtil.createConnection()) {
            CandidateDAO2 dao = new CandidateDAO2(con);

            try {
                // Disable auto-commit for transaction management
                con.setAutoCommit(false);

                // Insert single candidate
                dao.insertCandidate("Ravi", "Kumar", Date.valueOf("1990-05-12"), "9876543210", "ravi@example.com");

                // Batch insert
                List<String[]> candidates = new ArrayList<>();
                candidates.add(new String[]{"Anita", "Sharma", "1992-07-20", "9123456789", "anita@example.com"});
                candidates.add(new String[]{"Kiran", "Patel", "1988-03-15", "9988776655", "kiran@example.com"});
                dao.batchInsertCandidates(candidates);

                // Update candidate
                dao.updateCandidate(1, "Verma");
                
             // Simulate an error (e.g., invalid SQL or constraint violation)
               // dao.insertCandidate("Bad", "Data", Date.valueOf("2025-99-99"), "123", "invalid-email"); // will throw SQLException
                
                // Commit transaction
                con.commit();
                System.out.println("Transaction committed successfully.");

            } catch (Exception e) {
                // Rollback on error
                System.out.println("Error occurred, rolling back transaction...");
                con.rollback();
                e.printStackTrace();
            } finally {
                // Restore auto-commit
                con.setAutoCommit(true);
            }

            // Delete candidate (auto-commit ON)
            dao.deleteCandidate(2);
            System.out.println("Candidate deleted with auto-commit.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
