<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="page page-auth">
    <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bga.mp4" type="video/mp4">
      your browser does not support video
    </video>
 <div class="content">
<h2 class="form-title" id="registerTitle">User Registration</h2>
<form action="RegisterServlet" method="POST" class="auth-form" id="registerForm">
<input type="text"
name="username"
placeholder="Username"
class="form-input"
id="registerUsername">
<br><br>
<input type="email"
name="email"
placeholder="Email"
class="form-input"
id="registerEmail">
<br><br>
<input type="password"
name="password"
placeholder="Password"
class="form-input"
id="registerPassword">
<br><br>
<button type="submit" class="btn btn-primary" id="registerSubmitBtn">
Register
</button>
</form>
</div></div>
</body>
</html>
