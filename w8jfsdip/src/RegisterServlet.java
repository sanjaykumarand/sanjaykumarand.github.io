import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegisterServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String username =
request.getParameter("username");
String email =
request.getParameter("email");
String password =
request.getParameter("password");
try {
Connection connection =
DBConnection.getConnection();
String query =
"INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, username);
ps.setString(2, email);
ps.setString(3, password);
ps.executeUpdate();
response.sendRedirect(
"login.jsp"
);
} catch (Exception e) {
System.out.println(e);}}}