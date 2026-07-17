import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ViewBooksServlet
extends HttpServlet {
protected void doGet(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
try {
Connection connection =
DBConnection.getConnection();
String query =
"SELECT * FROM books";
PreparedStatement ps =
connection.prepareStatement(query);
ResultSet rs =
ps.executeQuery();
PrintWriter out =
response.getWriter();
while (rs.next()) {
out.println(
rs.getInt("id") + " | " +
rs.getString("book_name") + " | " +
rs.getString("author_name") + " | " +
rs.getString("category")
);
out.println("<br>");
}
} catch (Exception e) {
System.out.println(e);
}
}
}