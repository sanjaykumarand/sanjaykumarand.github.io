<!DOCTYPE html>
<html>
<head>
<title>Change Password</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="page page-form">
    <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bg.mp4" type="video/mp4">
      your browser does not support video
    </video>



 <div class="content">
<h2 class="form-title" id="changePasswordTitle">Change Password</h2>
<form action="ChangePasswordServlet" method="POST" class="app-form" id="changePasswordForm">
<input type="password"
name="new_password"
placeholder="New Password"
class="form-input"
id="newPasswordInput">
<br><br>
<button type="submit" class="btn btn-primary" id="changePasswordBtn">
Change Password
</button>
</form>
</div></div>
</body>
</html>
