import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddProductServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String productName =
request.getParameter("product_name");
String productPrice =
request.getParameter("product_price");
String productCategory =
request.getParameter("product_category");
try {
Connection connection =
DBConnection.getConnection();
String query =
"INSERT INTO products(product_name, product_price, product_category) VALUES (?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, productName);
ps.setString(2, productPrice);
ps.setString(3, productCategory);
ps.executeUpdate();
response.sendRedirect(
"success.jsp"
);
} catch (Exception e) {
System.out.println(e);
}
}
}