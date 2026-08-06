import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddFacultyServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String facultyName =
request.getParameter("faculty_name");
String subjectName =
request.getParameter("subject_name");
String email =
request.getParameter("email");
try {
Connection connection =
DBConnection.getConnection();
String query =
"INSERT INTO faculty(faculty_name, subject_name, email) VALUES (?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, facultyName);
ps.setString(2, subjectName);
ps.setString(3, email);
ps.executeUpdate();
response.sendRedirect(
"success.jsp"
);
} catch (Exception e) {
System.out.println(e);
}
}
}