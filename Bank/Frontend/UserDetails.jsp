<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #0077b6 30%, #023e8a 100%);
            color: #ffffff;
            overflow-x: hidden;
        }

        .container {
            margin-top: 50px;
        }

        .card {
            margin-bottom: 20px;
            transition: transform 0.3s, box-shadow 0.3s;
            border: none;
            border-radius: 15px;
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 20px rgba(1, 165, 78, 0.3);
        }

        .card-title {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #ffffff;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
        }

        .card-text {
            color: #ffffff;
            font-size: 1.25rem;
        }

        .amount {
            font-size: 2rem;
            margin-top: 20px;
            color: #ffdd57;
        }

        .btn-back {
            margin-top: 20px;
            background-color: #0077b6;
            border-color: #0077b6;
            border-radius: 50px;
            padding: 10px 20px;
            transition: background-color 0.3s, border-color 0.3s, transform 0.3s;
        }

        .btn-back:hover {
            background-color: #0469a0;
            border-color: #023e8a;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card text-center">
            <div class="card-body">
                <h2 class="card-title">User Details</h2>
                <p class="card-text"><strong>Name:</strong> <%= session.getAttribute("name") %></p>
                <p class="card-text"><strong>Email:</strong> <%= session.getAttribute("email") %></p>
                <p class="card-text"><strong>Amount:</strong> <span class="amount"><%= session.getAttribute("amount") %> RS</span></p>
                <button onclick="history.back()" class="btn btn-primary btn-back">Back</button>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
