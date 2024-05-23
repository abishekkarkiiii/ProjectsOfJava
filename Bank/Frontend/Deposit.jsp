<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Abishek Bank</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #0077b6, #023e8a);
            color: #ffffff;
            overflow-x: hidden; /* Prevent horizontal scroll */
        }

        .container {
            margin-top: 50px;
            max-width: 600px;
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            border-radius: 15px;
            padding: 20px;
            text-align: center;
        }

        .header-title {
            font-size: 3rem;
            margin-bottom: 20px;
            color: #ffffff;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-control {
            border-radius: 50px;
            padding: 10px;
        }

        .btn-primary {
            background-color: #0077b6;
            border-color: #0077b6;
            border-radius: 50px;
            padding: 10px 20px;
            transition: background-color 0.3s, border-color 0.3s, transform 0.3s;
        }

        .btn-primary:hover {
            background-color: #0469a0;
            border-color: #023e8a;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="header-title">Welcome to Abishek Bank</h1>
        <p>We are thrilled that you have chosen to open an account with us!</p>
        <p>To get started, please make your first deposit.</p>
        <form action="FirstAccount" method="post">
            <div class="form-group">
                <label for="initialDeposit">Enter Deposit Amount</label>
                <input type="number" class="form-control" id="initialDeposit" name="initialDeposit" required>
            </div>
            <button type="submit" class="btn btn-primary">Confirm Deposit</button>
        </form>
    </div>
</body>
</html>
