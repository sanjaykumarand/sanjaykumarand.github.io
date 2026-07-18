import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ViewBookingsServlet
extends HttpServlet {
protected void doGet(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
try {
Connection connection =
DBConnection.getConnection();
String query =
"SELECT * FROM bookings";
PreparedStatement ps =
connection.prepareStatement(query);
ResultSet rs =
ps.executeQuery();
PrintWriter out =
response.getWriter();
while (rs.next()) {
out.println(
    rs.getInt("id") + " | " +
rs.getString("customer_name") + " | " +
rs.getString("movie_name") + " | " +
rs.getString("seats") + " | " +
rs.getString("show_time")
);
out.println("<br>");
}
} catch (Exception e) {
System.out.println(e);
}
}
}