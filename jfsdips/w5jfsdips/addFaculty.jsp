<!DOCTYPE html>
<html>
<head>
<title>Add Faculty</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-wrapper">
<div class="page-header">
<h2>Add Faculty</h2>
</div>
<div class="form-section">
<form action="AddFacultyServlet" method="POST">
<div class="form-group">
<input class="form-input" type="text"
name="faculty_name"
placeholder="Faculty Name">
</div>
<div class="form-group">
<input class="form-input" type="text"
name="subject_name"
placeholder="Subject Name">
</div>
<div class="form-group">
<input class="form-input" type="email"
name="email"
placeholder="Email">
</div>
<button class="btn-submit" type="submit">
Add Faculty
</button>
</form>
</div>
</div>
</body>
</html>
