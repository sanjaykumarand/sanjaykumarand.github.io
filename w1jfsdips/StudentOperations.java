import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class StudentOperations {
public void addStudent(
String studentName,
String department,
String email
) {
try {
Connection connection =
DBConnection.getConnection();
String query =
"INSERT INTO students(student_name, department, email) VALUES (?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, studentName);
ps.setString(2, department);
ps.setString(3, email);
ps.executeUpdate();
System.out.println(
"Student Added Successfully"
);
} catch (Exception e) {
System.out.println(e);
}
}
public void viewStudents() {
try {
Connection connection =
DBConnection.getConnection();
String query =
"SELECT * FROM students";
PreparedStatement ps =
connection.prepareStatement(query);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
System.out.println(
rs.getInt("id") + " | " +
rs.getString("student_name") + " | " +
rs.getString("department") + " | " +
rs.getString("email")
);
}
} catch (Exception e) {
System.out.println(e);
}
}
}