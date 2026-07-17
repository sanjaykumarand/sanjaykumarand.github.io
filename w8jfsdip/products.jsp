<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<!DOCTYPE html>
<html>
<head>
   <title>View Products</title>
   <link rel="stylesheet" href="style.css">
</head>
<body class="page page-table">
<div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bg.mp4" type="video/mp4">
     your browser does not support video
    </video>
 <div class="content">
<h2 class="table-title" id="productsTitle">Product List</h2>

<table border="1" cellpadding="8" cellspacing="0" class="data-table" id="productsTable">
<tr class="table-header-row">
<th>ID</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Category</th>
</tr>

<%
List<Product> productList = (List<Product>) request.getAttribute("productList");
if (productList != null) {
for (Product product : productList) {
%>
<tr class="table-row">
<td><%= product.id %></td>
<td><%= product.productName %></td>
<td><%= product.productPrice %></td>
<td><%= product.productCategory %></td>
</tr>
<%
}
}
%>

</table>

<br><br>

<a href="dashboard.jsp" class="btn btn-secondary" id="dashboardLink">
Go To Dashboard
</a>
</div></div>
</body>
</html>
