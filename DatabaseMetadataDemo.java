package jdbcdemo;

import java.sql.*;
/*
 * To retrieve metadata information from a database using JDBC, you can use the 
 * DatabaseMetaData and ResultSetMetaData classes. 
 * These classes provide details about the database, tables, and columns.
 */
public class DatabaseMetadataDemo {

	public static void main(String[] args) throws Exception {
		
		Connection connection = null;

        try {
            // Step 1: Establish a connection
            connection = ConnectionUtil.createConnection();

            // Step 2: Get Database Metadata
            DatabaseMetaData dbMetaData = connection.getMetaData();

            // Display basic database information
            System.out.println("Database Product Name: " + dbMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbMetaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbMetaData.getDriverName());
            System.out.println("Driver Version: " + dbMetaData.getDriverVersion());
            System.out.println("URL: " + dbMetaData.getURL());
            System.out.println("User: " + dbMetaData.getUserName());

            // Step 3: Get Table Metadata
            ResultSet tables = dbMetaData.getTables(null, null, "%", new String[] {"TABLE"});
            System.out.println("\nTables in the Database:");
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("- " + tableName);
                
                // Step 4: Get Column Metadata for Each Table
                ResultSet columns = dbMetaData.getColumns(null, null, tableName, "%");
                System.out.println("  Columns in " + tableName + ":");
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    int columnSize = columns.getInt("COLUMN_SIZE");
                    System.out.println("    - " + columnName + " (" + columnType + ", size: " + columnSize + ")");
                }
                columns.close();
            }
            tables.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}

}
