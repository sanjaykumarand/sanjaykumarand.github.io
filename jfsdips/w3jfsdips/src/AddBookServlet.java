import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddBookServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String bookName =
request.getParameter("book_name");
String authorName =
request.getParameter("author_name");
String category =
request.getParameter("category");
try {
Connection connection =
DBConnection.getConnection();
String query =
"INSERT INTO books(book_name, author_name, category) VALUES (?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, bookName);
ps.setString(2, authorName);
ps.setString(3, category);
ps.executeUpdate();
response.sendRedirect(
"success.jsp"
);
} catch (Exception e) {
System.out.println(e);
}
}
}