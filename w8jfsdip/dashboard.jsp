<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
<link rel="stylesheet" href="style.css">
</head>
<style>
    .content{
        min-width: 1000px;
        width: 1000px;
    }
</style>
<body class="page page-dashboard">
    <div class="video-container">
    <video autoplay muted loop id="bg-video">
      <source src="themes/bg.mp4" type="video/mp4">
      your browser does not support video
    </video>
 <div class="content">
<div class="topbar" id="topbar">
<div class="profile-menu" id="profileMenu">
<button style="margin: -150px 0px 0px 200px;" type="button" class="user-info" id="userInfo" onclick="document.getElementById('profileDropdown').classList.toggle('open')">
<svg class="user-icon" id="userIcon" viewBox="0 0 24 24" width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
<circle cx="12" cy="8" r="4" stroke="currentColor" stroke-width="2"/>
<path d="M4 20c0-4 3.5-6 8-6s8 2 8 6" stroke="currentColor" stroke-width="2" stroke-linecap="round"/>
</svg>
<span class="user-name" id="userName"><%
String username = (String) session.getAttribute("username");
if (username != null) {
out.print(username);
} else {
out.print("Guest");
}
%></span>
</button>
<div class="profile-dropdown" id="profileDropdown">
<a href="changeUsername.jsp" class="profile-dropdown-item" id="changeUsernameLink">Change Username</a>
<a href="changeEmail.jsp" class="profile-dropdown-item" id="changeEmailLink">Change Email</a>
<a href="changePassword.jsp" class="profile-dropdown-item" id="changePasswordLink">Change Password</a>
<a href="LogoutServlet" class="profile-dropdown-item profile-dropdown-logout" id="logoutLink">Logout</a>
</div>
</div>
</div>
<h1 class="dashboard-title" id="dashboardTitle">Admin Dashboard</h1>
<center>
<a href="addProduct.jsp" class="dashboard-link" id="addProductLink">
Add Product
</a>
<br><br>
<a href="addOrder.jsp" class="dashboard-link" id="addOrderLink">
Add Order
</a>
<br><br>
<a href="ViewProductsServlet" class="dashboard-link" id="viewProductsLink">
View Products
</a>
<br><br>
<a href="ViewOrdersServlet" class="dashboard-link" id="viewOrdersLink">
View Orders
</a></center>
</div></div>
</body>
</html>