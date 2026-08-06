import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ChangeUsernameServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String newUsername =
request.getParameter("new_username");
HttpSession session =
request.getSession();
String email =
(String) session.getAttribute("email");
try {
Connection connection =
DBConnection.getConnection();
String query =
"UPDATE users SET username=? WHERE email=?";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, newUsername);
ps.setString(2, email);
ps.executeUpdate();
session.setAttribute(
"username",
newUsername
);
response.sendRedirect(
"success.jsp"
);
} catch (Exception e) {
System.out.println(e);
}
}
}
