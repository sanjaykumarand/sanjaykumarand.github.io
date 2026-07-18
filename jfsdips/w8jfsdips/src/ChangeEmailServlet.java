import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ChangeEmailServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String newEmail =
request.getParameter("new_email");
HttpSession session =
request.getSession();
String currentEmail =
(String) session.getAttribute("email");
try {
Connection connection =
DBConnection.getConnection();
String query =
"UPDATE users SET email=? WHERE email=?";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, newEmail);
ps.setString(2, currentEmail);
ps.executeUpdate();
session.setAttribute(
"email",
newEmail
);
response.sendRedirect(
"success.jsp"
);
} catch (Exception e) {
System.out.println(e);
}
}
}
