package xyz;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdbb";
        String user = "root";
        String password = "Mohan@28";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String insertQuery = "INSERT INTO students (id, name, marks) VALUES (1, 'Alice', 85)";
            stmt.executeUpdate(insertQuery);
            System.out.println("Inserted record.");

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Marks: " + rs.getInt("marks"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
