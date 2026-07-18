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
import model.Product;
public class ViewProductsServlet
extends HttpServlet {
protected void doGet(
HttpServletRequest request,
HttpServletResponse response
) throws ServletException, IOException {
List<Product> productList = new ArrayList<Product>();
try {
Connection connection =
DBConnection.getConnection();
String query =
"SELECT * FROM products";
PreparedStatement ps =
connection.prepareStatement(query);
ResultSet rs =
ps.executeQuery();
while(rs.next()) {
Product product = new Product();
product.id = rs.getInt("id");
product.productName = rs.getString("product_name");
product.productPrice = rs.getString("product_price");
product.productCategory = rs.getString("product_category");
productList.add(product);
}
} catch (Exception e) {
System.out.println(e);
}
request.setAttribute("productList", productList);
request.getRequestDispatcher("products.jsp").forward(request, response);
}
}
