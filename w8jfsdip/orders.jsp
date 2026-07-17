<%@ page import="java.util.List" %>
<%@ page import="model.Order" %>
<!DOCTYPE html>
<html>
<head>
   <title>View Orders</title>
   <link rel="stylesheet" href="style.css">
</head>
<body class="page page-table">
<div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bg.mp4" type="video/mp4">
      your browser does not support video
    </video>



 <div class="content">
<h2 class="table-title" id="ordersTitle">Order List</h2>

<table border="1" cellpadding="8" cellspacing="0" class="data-table" id="ordersTable">
<tr class="table-header-row">
<th>ID</th>
<th>Customer Name</th>
<th>Product Name</th>
<th>Quantity</th>
</tr>

<%
List<Order> orderList = (List<Order>) request.getAttribute("orderList");
if (orderList != null) {
for (Order order : orderList) {
%>
<tr class="table-row">
<td><%= order.id %></td>
<td><%= order.customerName %></td>
<td><%= order.productName %></td>
<td><%= order.quantity %></td>
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
