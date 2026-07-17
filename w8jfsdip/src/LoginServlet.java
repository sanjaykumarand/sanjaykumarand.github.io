import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String email =
request.getParameter("email");
String password =
request.getParameter("password");
try {
Connection connection =
DBConnection.getConnection();
String query =
"SELECT * FROM users WHERE email=? AND password=?";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, email);
ps.setString(2, password);
ResultSet rs =
ps.executeQuery();
if(rs.next()) {
HttpSession session =
request.getSession();
session.setAttribute(
"username",
rs.getString("username")
);
session.setAttribute(
"email",
rs.getString("email")
);
response.sendRedirect(
"dashboard.jsp"
);
} else {
response.getWriter().println(
"Invalid Login"
);
}
} catch (Exception e) {
System.out.println(e);
}
}
}
