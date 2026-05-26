import java.sql.*;

public class StudentDAO {

    // Add student
    public void addStudent(Student student) {
        String query =
                "INSERT INTO students(name, department, marks) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getDepartment());
            ps.setInt(3, student.getMarks());

            ps.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all students
    public void viewStudents() {
        String query = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Department: " + rs.getString("department") +
                    ", Marks: " + rs.getInt("marks")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}