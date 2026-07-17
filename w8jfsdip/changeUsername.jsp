<!DOCTYPE html>
<html>
<head>
<title>Change Username</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="page page-form">
    <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bg.mp4" type="video/mp4">
      your browser does not support video
    </video>



 <div class="content">
<h2 class="form-title" id="changeUsernameTitle">Change Username</h2>
<form action="ChangeUsernameServlet" method="POST" class="app-form" id="changeUsernameForm">
<input type="text"
name="new_username"
placeholder="New Username"
class="form-input"
id="newUsernameInput">
<br><br>
<button type="submit" class="btn btn-primary" id="changeUsernameBtn">
Change Username
</button>
</form>
</div></div>
</body>
</html>
