<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Ticket</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
 <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="bvtb.mp4" type="video/mp4">
      Your browser does not support HTML5 video.
    </video>



 <div class="content">
<div id="form-wrapper">
  <div id="ticket-card">
    <div id="ticket-top">
      <span id="ticket-icon">&#9646;&#9646;</span>
      <h2 id="form-title">Movie Ticket Booking Form</h2>
    </div>
    <div id="ticket-divider">
      <span class="circle-left"></span>
      <span class="dashed-line"></span>
      <span class="circle-right"></span>
    </div>
    <form action="BookTicketServlet" method="POST" id="booking-form">
      <div class="form-group">
        <label class="form-label">Customer Name</label>
        <input type="text" name="customer_name" placeholder="Enter your name" class="form-input">
      </div>
      <div class="form-group">
        <label class="form-label">Movie Name</label>
        <input type="text" name="movie_name" placeholder="Enter movie name" class="form-input">
      </div>
      <div class="form-group">
        <label class="form-label">Number of Seats</label>
        <input type="text" name="seats" placeholder="e.g. 2" class="form-input">
      </div>
      <div class="form-group">
        <label class="form-label">Show Time</label>
        <input type="text" name="show_time" placeholder="e.g. 7:00 PM" class="form-input">
      </div>
      <button type="submit" id="submit-btn">
        Book Ticket
      </button>
    </form>
  </div>
  <a href="index.jsp" id="back-link">&#8592; Back to Home</a>
</div>
<br><br>
<footer id="footer">
  Made from <a href="index.jsp" id="footer-link">SANJAY KUMARAN</a> Portal
</footer>
</body>
</html>
