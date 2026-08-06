import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddEmployeeServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String employeeName =
request.getParameter("employee_name");
String department =
request.getParameter("department");
String salary =
request.getParameter("salary");
try {
Connection connection =
DBConnection.getConnection();
String query =
"INSERT INTO employees(employee_name, department, salary) VALUES (?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, employeeName);
ps.setString(2, department);
ps.setString(3, salary);
ps.executeUpdate();
PrintWriter out =
response.getWriter();
out.println(
"Employee Added Successfully"
);
} catch (Exception e) {
System.out.println(e);
}
}
}