import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class OrderFoodServlet
extends HttpServlet {
protected void doPost(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
String customerName =
request.getParameter("customer_name");
String foodItem =
request.getParameter("food_item");
String quantity =
request.getParameter("quantity");
String address =
request.getParameter("address");
try {
Connection connection = DBConnection.getConnection();
String query = "INSERT INTO food_orders(customer_name, food_item, quantity, address) VALUES(?, ?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, customerName);
ps.setString(2, foodItem);
ps.setString(3, quantity);
ps.setString(4, address);
ps.executeUpdate();
response.sendRedirect(
"success.jsp"
);
} catch (Exception e) {
System.out.println(e);
}
}
}