<!DOCTYPE html>
<html>
<head>
<title>Add Product</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="page page-form">
    <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bg.mp4" type="video/mp4">
      your browser does not support video
    </video>



 <div class="content">
<h2 class="form-title" id="addProductTitle">Add Product</h2>
<form action="AddProductServlet" method="POST" class="app-form" id="addProductForm">
<input type="text"
name="product_name"
placeholder="Product Name"
class="form-input"
id="productNameInput">
<br><br>
<input type="text"
name="product_price"
placeholder="Product Price"
class="form-input"
id="productPriceInput">
<br><br>
<input type="text"
name="product_category"
placeholder="Product Category"
class="form-input"
id="productCategoryInput">
<br><br>
<button type="submit" class="btn btn-primary" id="addProductBtn">
Add Product
</button>
</form>
</div></div>
</body>
</html>