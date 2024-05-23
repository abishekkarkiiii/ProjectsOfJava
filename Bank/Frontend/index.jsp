<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="login.css">
    <style>
 
    .error-message {
        color: red;
        margin-top: 10px;
        margin-left: 24%;
    }
    /* Corrected the style block */
    .errormessage2 {
        color: red;
        margin-top: 10px;
        margin-left: 27%;
        /* Add additional styling as needed */
    }
</style>
 
        
    
</head>
<body>
    <div class="container-fluid d-flex justify-content-center align-items-center min-vh-100 login-background">
        <div class="card login-card">
            <div class="card-body position-relative">
                <h1 class="card-title text-center">Bank Account Login</h1>
                <form action="login" method="post">
                    <div class="form-group">
                        <label for="userId">User ID</label>
                        <input type="number" class="form-control" id="userId" name="userId" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Login</button>
                </form>
                <% 
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if (errorMessage != null) {
                %>
                    <div class="error-message"><%= errorMessage %></div>
                <% } %>
               <% 
                   String Message2 = (String) session.getAttribute("userexist");
                   if (Message2 != null) {
                %>
                   
                  <div class="errormessage2"><%= Message2 %></div>
                <% } %>
               
                <div class="create-account-btn">
                    <a href="CreateAccount.jsp">Create Account</a>
                </div>
                <div class="logo-background">Abishek</div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
