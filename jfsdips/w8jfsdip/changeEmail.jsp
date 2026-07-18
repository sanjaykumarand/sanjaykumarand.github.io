<!DOCTYPE html>
<html>
<head>
<title>Change Email</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="page page-form">
    <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bg.mp4" type="video/mp4">
      your browser does not support video
    </video>



 <div class="content">
<h2 class="form-title" id="changeEmailTitle">Change Email</h2>
<form action="ChangeEmailServlet" method="POST" class="app-form" id="changeEmailForm">
<input type="email"
name="new_email"
placeholder="New Email"
class="form-input"
id="newEmailInput">
<br><br>
<button type="submit" class="btn btn-primary" id="changeEmailBtn">
Change Email
</button>
</form>
</div></div>
</body>
</html>
