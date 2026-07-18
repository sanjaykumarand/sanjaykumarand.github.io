import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class OrderProductServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String customerName =
request.getParameter("customer_name");
String productName =
request.getParameter("product_name");
String quantity =
request.getParameter("quantity");
try {
Connection connection =
DBConnection.getConnection();
String query =
"INSERT INTO orders(customer_name, product_name, quantity) VALUES (?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, customerName);
ps.setString(2, productName);
ps.setString(3, quantity);
ps.executeUpdate();
response.sendRedirect(
"success.jsp"
);
} catch (Exception e) {
System.out.println(e);
}
}
}