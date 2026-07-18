<!DOCTYPE html>
<html>
<head>
<title>Order Food</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div id="page-wrapper">
  <div class="card">
    <h2 class="section-title">Food Order Form</h2>
    <form id="order-form" action="OrderFoodServlet" method="POST">
      <input class="form-input" type="text"
        name="customer_name"
        placeholder="Customer Name">
      <input class="form-input" type="text"
        name="food_item"
        placeholder="Food Item">
      <input class="form-input" type="text"
        name="quantity"
        placeholder="Quantity">
      <textarea class="form-input"
        name="address"
        placeholder="Delivery Address">
      </textarea>
      <button id="submit-btn" type="submit">Place Order</button>
    </form>
  </div>
</div>
</body>
</html>
