<!DOCTYPE html>
<html>
<head>
<title>Add Order</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="page page-form">
    <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bg.mp4" type="video/mp4">
      your browser does not support video
    </video>



 <div class="content">
<h2 class="form-title" id="addOrderTitle">Add Order</h2>
<form action="OrderProductServlet" method="POST" class="app-form" id="addOrderForm">
<input type="text"
name="customer_name"
placeholder="Customer Name"
class="form-input"
id="customerNameInput">
<br><br>
<input type="text"
name="product_name"
placeholder="Product Name"
class="form-input"
id="orderProductNameInput">
<br><br>
<input type="text"
name="quantity"
placeholder="Quantity"
class="form-input"
id="quantityInput">
<br><br>
<button type="submit" class="btn btn-primary" id="addOrderBtn">
Add Order
</button>
</form>
</div></div>
</body>
</html>
