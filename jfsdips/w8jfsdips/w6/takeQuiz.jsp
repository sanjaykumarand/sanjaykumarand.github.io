<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Take Quiz</title>
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
    <h2 class="section-heading">Java Quiz</h2>

    <%
      List<String[]> questionList = (List<String[]>) request.getAttribute("questionList");
      if (questionList == null || questionList.isEmpty()) {
    %>
      <p style="color:#888; font-style:italic; text-align:center;">
        No questions available. Please add questions first.
      </p>
    <% } else { %>

    <form action="SubmitQuizServlet" method="POST" class="quiz-form">
      <%
        int n = 1;
        for (String[] q : questionList) {
          String qId = q[0];
          String qText = q[1];
          String op1 = q[2];
          String op2 = q[3];
          String op3 = q[4];
          String op4 = q[5];
      %>
      <div class="quiz-question-block">
        <p class="question-text"><%= n %>. <%= qText %></p>
        <div class="options-group">

          <% if (op1 != null && !op1.trim().isEmpty()) { %>
          <label class="option-label">
            <input type="radio" name="q<%= qId %>" value="<%= op1 %>" class="option-radio" required>
            <%= op1 %>
          </label>
          <% } %>

          <% if (op2 != null && !op2.trim().isEmpty()) { %>
          <label class="option-label">
            <input type="radio" name="q<%= qId %>" value="<%= op2 %>" class="option-radio">
            <%= op2 %>
          </label>
          <% } %>

          <% if (op3 != null && !op3.trim().isEmpty()) { %>
          <label class="option-label">
            <input type="radio" name="q<%= qId %>" value="<%= op3 %>" class="option-radio">
            <%= op3 %>
          </label>
          <% } %>

          <% if (op4 != null && !op4.trim().isEmpty()) { %>
          <label class="option-label">
            <input type="radio" name="q<%= qId %>" value="<%= op4 %>" class="option-radio">
            <%= op4 %>
          </label>
          <% } %>

        </div>
        <input type="hidden" name="questionIds" value="<%= qId %>">
      </div>
      <%
          n++;
        }
      %>
      <button type="submit" class="btn-submit">Submit Quiz</button>
    </form>

    <% } %>

    <div class="card-footer">Online Quiz Examination System</div>
  </div>
</div>
 </div>
 </div> 
</body>
</html>
