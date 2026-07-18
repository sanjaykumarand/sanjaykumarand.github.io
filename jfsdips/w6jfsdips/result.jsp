<!DOCTYPE html>
<html>
<head>
  <title>Quiz Result</title>
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
  <a href="index.jsp" class="back-link">&#8592; Back to Home</a>
  <div class="card">
    <div class="result-wrapper">
      <h2 class="result-label">Your Quiz Score</h2>
      <h1 class="result-score">
        <%= request.getAttribute("score") %> / <%= request.getAttribute("total") %>
      </h1>
      <p class="result-caption">Thank you for taking the quiz.</p>
    </div>
    <div class="card-footer">Online Quiz Examination System</div>
  </div>
</div>
 </div>
 </div> 
</body>
</html>
