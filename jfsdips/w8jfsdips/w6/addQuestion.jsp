<!DOCTYPE html>
<html>
<head>
<title>Add Question</title>
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
    <h2 class="section-heading">Add Quiz Question</h2>
    <form action="AddQuestionServlet" method="POST" class="quiz-form">

      <div class="form-group">
        <label class="form-label">Question</label>
        <input type="text"
          name="question"
          placeholder="Question"
          class="form-input">
      </div>

      <hr class="form-divider">

      <div class="form-group">
        <label class="form-label">Option 1</label>
        <input type="text"
          name="option1"
          placeholder="Option 1"
          class="form-input">
      </div>

      <div class="form-group">
        <label class="form-label">Option 2</label>
        <input type="text"
          name="option2"
          placeholder="Option 2"
          class="form-input">
      </div>

      <div class="form-group">
        <label class="form-label">Option 3</label>
        <input type="text"
          name="option3"
          placeholder="Option 3"
          class="form-input">
      </div>

      <div class="form-group">
        <label class="form-label">Option 4</label>
        <input type="text"
          name="option4"
          placeholder="Option 4"
          class="form-input">
      </div>

      <hr class="form-divider">

      <div class="form-group">
        <label class="form-label">Correct Answer</label>
        <input type="text"
          name="correct_answer"
          placeholder="Correct Answer"
          class="form-input">
      </div>

      <button type="submit" class="btn-submit">
        Add Question
      </button>
    </form>
    <div class="card-footer">Online Quiz Examination System</div>
  </div>
</div>
 </div>
 </div> 
</body>
</html>
