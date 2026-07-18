<!DOCTYPE html>
<html>
<head>
<title>Add Book</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div id="page-wrapper">
<div class="card">
<h2 class="section-title">Add Book</h2>
<form id="add-book-form" action="AddBookServlet" method="POST">
<input class="form-input" type="text"
name="book_name"
placeholder="Book Name">
<input class="form-input" type="text"
name="author_name"
placeholder="Author Name">
<input class="form-input" type="text"
name="category"
placeholder="Category">
<button id="submit-btn" type="submit">
Add Book
</button>
</form>
</div>
</div>
</body>
</html>
