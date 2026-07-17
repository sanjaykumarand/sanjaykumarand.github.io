import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class BookTicketServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String customerName =
request.getParameter("customer_name");
String movieName =
request.getParameter("movie_name");
String seats =
request.getParameter("seats");
String showTime =
request.getParameter("show_time");
try {
Connection connection =
DBConnection.getConnection();
String query = "INSERT INTO bookings(customer_name, movie_name, seats, show_time) VALUES (?, ?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, customerName);
ps.setString(2, movieName);
ps.setString(3, seats);
ps.setString(4, showTime);
ps.executeUpdate();
response.sendRedirect(
"success.jsp"
);
} catch (Exception e) {
System.out.println(e);
}
}
}