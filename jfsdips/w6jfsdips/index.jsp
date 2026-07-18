<!DOCTYPE html>
<html>
<head>
  <title>Online Quiz System</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="bv.mp4" type="video/mp4">
      Your browser does not support HTML5 video.
    </video>



 <div class="content">
<div class="page-wrapper">
  <div class="card">
    <h1 class="page-title">Online Quiz Examination System</h1>
    <p class="page-subtitle">Select an option to continue</p>
    <nav class="nav-links">
      <a href="addQuestion.jsp" class="nav-link">Add Questions</a>
      <!-- Goes through servlet first so DB data is loaded before takeQuiz.jsp renders -->
      <a href="ViewQuestionsServlet" class="nav-link primary">Take Quiz</a>
      <br>
      <h4 style="text-align:center; color:#000;">Powered by Sanjay Kumaran Portal</h4>
    </nav>
  </div>
</div>
 </div>
 </div> 
</body>
</html>
