<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Account</title>
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
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .confirmation-card {
            width: 100%;
            max-width: 400px;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.3);
        }

        .confirmation-card h2 {
            margin-bottom: 30px;
            font-weight: 700;
            color: #ffffff;
            font-size: 24px;
            text-align: center;
        }

        .form-group label {
            font-weight: 500;
            color: #ffffff;
        }

        .form-control {
            background: rgba(255, 255, 255, 0.1);
            color: #ffffff;
            border: 1px solid rgba(255, 255, 255, 0.3);
            backdrop-filter: blur(5px);
            -webkit-backdrop-filter: blur(5px);
            transition: background 0.3s, color 0.3s;
        }

        .form-control:focus {
            background: rgba(255, 255, 255, 0.2);
            color: #000000;
        }

        .form-control::placeholder {
            color: rgba(255, 255, 255, 0.6);
        }

        .btn-danger {
            background-color: #e63946;
            border-color: #e63946;
            transition: background-color 0.3s, border-color 0.3s, transform 0.3s;
        }

        .btn-danger:hover {
            background-color: #d62828;
            border-color: #d62828;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="confirmation-card">
        <h2>Delete Account</h2>
        <form action="delete" method="POST">
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit" class="btn btn-danger btn-block">Delete Account</button>
        </form>
        <button class="btn btn-primary btn-block mt-3" onclick="goBack()">Back</button>
    </div>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
