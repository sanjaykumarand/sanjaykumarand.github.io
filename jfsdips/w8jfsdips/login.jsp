<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="page page-auth">
    <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bga.mp4" type="video/mp4">
      your browser does not support video
    </video>
 <div class="content">
<h2 class="form-title" id="loginTitle">User Login</h2>
<form action="LoginServlet" method="POST" class="auth-form" id="loginForm">
<input type="email"
name="email"
placeholder="Email"
class="form-input"
id="loginEmail">
<br><br>
<input type="password"
name="password"
placeholder="Password"
class="form-input"
id="loginPassword">
<br><br>
<button type="submit" class="btn btn-primary" id="loginSubmitBtn">
Login
</button>
</form>
</div></div>
</body>
</html>