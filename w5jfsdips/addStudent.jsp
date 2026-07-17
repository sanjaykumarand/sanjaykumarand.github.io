<!DOCTYPE html>
<html>
<head>
<title>Add Student</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-wrapper">
<div class="page-header">
<h2>Add Student</h2>
</div>
<div class="form-section">
<form action="AddStudentServlet" method="POST">
<div class="form-group">
<input class="form-input" type="text"
name="student_name"
placeholder="Student Name">
</div>
<div class="form-group">
<input class="form-input" type="text"
name="department"
placeholder="Department">
</div>
<div class="form-group">
<input class="form-input" type="email"
name="email"
placeholder="Email">
</div>
<button class="btn-submit" type="submit">
Add Student
</button>
</form>
</div>
</div>
</body>
</html>
