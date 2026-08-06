import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;
public class ViewOrdersServlet
extends HttpServlet {
protected void doGet(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
List<Order> orderList = new ArrayList<Order>();
try {
Connection connection =
DBConnection.getConnection();
String query =
"SELECT * FROM orders";
PreparedStatement ps =
connection.prepareStatement(query);
ResultSet rs =
ps.executeQuery();
while(rs.next()) {
Order order = new Order();
order.id = rs.getInt("id");
order.customerName = rs.getString("customer_name");
order.productName = rs.getString("product_name");
order.quantity = rs.getString("quantity");
orderList.add(order);
}
} catch (Exception e) {
System.out.println(e);
}
request.setAttribute("orderList", orderList);
request.getRequestDispatcher("orders.jsp").forward(request, response);
}
}
