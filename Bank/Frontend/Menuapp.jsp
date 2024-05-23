<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Home</title>
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
            overflow-x: hidden; /* Prevent horizontal scroll */
        }

        .navbar {
            background-color: #023e8a;
            padding: 10px 20px;
        }

        .navbar-brand {
            color: #ffffff;
            font-size: 1.5rem;
        }

        .navbar-nav .nav-link {
            color: #ffffff;
            transition: color 0.3s;
        }

        .navbar-nav .nav-link:hover {
            color: #ffdd57;
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
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 20px rgba(1, 165, 78, 0.3);
        }

        .card i {
            font-size: 4rem;
            margin-bottom: 15px;
            color: #ffffff;
            transition: color 0.3s;
        }

        .card:hover i {
            color: #00b312;
        }

        .card-title {
            font-size: 1.75rem;
            margin-bottom: 20px;
            color: #ffffff;
            transition: color 0.3s;
        }

        .card:hover .card-title {
            color: #00b327;
        }

        .card-text {
            color: #ffffff;
        }

        .btn {
            border-radius: 50px;
            padding: 10px 20px;
            transition: background-color 0.3s, border-color 0.3s, transform 0.3s;
        }

        .btn-primary {
            background-color: #0077b6;
            border-color: #0077b6;
        }

        .btn-primary:hover {
            background-color: #0469a0;
            border-color: #023e8a;
            transform: scale(1.05);
        }

        .header-title {
            font-size: 3rem;
            margin-bottom: 30px;
            color: #ffffff;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
        }

        .amount {
            font-size: 2rem;
            margin-top: 20px;
            color: #ffdd57;
        }

        @media (max-width: 768px) {
            .header-title {
                font-size: 2rem;
            }

            .card i {
                font-size: 3rem;
            }

            .card-title {
                font-size: 1.5rem;
            }
        }

        .sidebar {
            position: fixed;
            right: -250px; /* Hidden by default */
            top: 0;
            height: 100%;
            width: 250px;
            background-color: rgba(0, 123, 182, 0.8);
            padding: 20px;
            box-shadow: -2px 0 5px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            transition: right 0.3s ease-in-out;
            overflow-y: auto;
        }

        .sidebar h3 {
            margin-top: 20px;
            color: #ffffff;
        }

        .sidebar a {
            display: block;
            padding: 10px 0;
            color: #ffffff;
            text-decoration: none;
            transition: color 0.3s, transform 0.3s;
        }

        .sidebar a:hover {
            color: #00b327;
            transform: translateX(5px);
        }

        .sidebar-open {
            right: 0; /* Show the sidebar */
        }

        .sidebar-toggle {
            position: fixed;
            top: 20px;
            right: 20px;
            background-color: #0077b6;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
            border-radius: 5px;
            z-index: 1000; /* Ensure the button is on top */
            transition: background-color 0.3s, transform 0.3s;
        }

        .sidebar-toggle:hover {
            background-color: #0469a0;
            transform: scale(1.1);
        }

        .del {
            margin-top: 20px;
            display: block;
            width: 100%;
            text-align: center;
            color: white;
            background-color: red;
            border: none;
            padding: 10px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.3s;
        }

        .del:hover {
            background-color: darkred;
            transform: scale(1.05);
        }

        .row {
            display: flex;
            justify-content: center;
            align-items: stretch;
            gap: 20px;
        }

        .card {
            flex: 1;
            min-width: 280px; /* Ensure minimum card width */
            max-width: 300px; /* Ensure maximum card width */
            margin: 0 10px; /* Provide some margin between cards */
        }
        
        .card-body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .modal-content {
            background: rgba(255, 255, 255, 0.8);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            border-radius: 10px;
            padding: 20px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg">
        <div class="container">
        <a class="navbar-brand" href="#">Abishek Bank</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<button class="sidebar-toggle" id="sidebarToggle"><i class="fas fa-bars"></i></button>
<div class="container text-center main-content">
    <h1 class="header-title">Welcome to Abishek Bank</h1>
    
    <% 
        Integer totalAmount = (Integer) session.getAttribute("TotalAmount");
        if (totalAmount != null && totalAmount >= 0) {
    %>
        <div class="amount">Deposit Successful</div>
       
    <%  totalAmount=null;} %>
     <% 
        String TransferMessage = (String)session.getAttribute("tranfermessage");
        if (TransferMessage != null ) {
    %>
        <div class="amount"><%=TransferMessage%></div>
    <% TransferMessage="";} %>
    <div class="row">
        <div class="card text-center" id="depositCard">
            <div class="card-body">
                <i class="fas fa-money-check-alt"></i>
                <h2 class="card-title">Deposit</h2>
                <p class="card-text">Deposit money into your account easily.</p>
                <!-- Deposit Form -->
                <form action="Menu" method="post" id="depositForm" style="display: none;">
                    <div class="form-group">
                        <label for="depositAmount">Enter Deposit Amount</label>
                        <input type="number" class="form-control" id="depositAmount" name="depositAmount" required>
                    </div>
                    <button type="submit" class="btn btn-primary" value="deposit" name="action">Confirm Deposit</button>
                </form>
                <!-- End of Deposit Form -->
            </div>
        </div>
        <div class="card text-center">
            <div class="card-body">
                <i class="fas fa-exchange-alt"></i>
                <h2 class="card-title">Transfer</h2>
                <p class="card-text">Transfer money to other accounts quickly.</p>
                <a href="Transfer.jsp" class="btn btn-primary">Go to Transfer</a>
            </div>
        </div>
        <div class="card text-center">
            <div class="card-body">
                <i class="fas fa-balance-scale"></i>
                <h2 class="card-title">Check Balance</h2>
                <p class="card-text">Check your account balance at any time.</p>
                <form action="Menu" method="post">
                    <input type="hidden" name="action" value="showdata">
                    <button type="submit" class="btn btn-primary">Check Balance</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Sidebar -->
<div class="sidebar" id="sidebar">
    <h3>Options</h3>
    <ul class="nav flex-column">

    </ul>
    <form action="Menu" method="post">
        <button type="submit" value="logout" name="action" class="btn btn-primary btn-block">Log out</button>
    </form>
    <a href="Delete.jsp" class="del">Delete</a>
</div>
<!-- End of Sidebar -->

<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    document.getElementById('sidebarToggle').addEventListener('click', function() {
        document.getElementById('sidebar').classList.toggle('sidebar-open');
    });
    
    // Show deposit form when hovering over deposit card
    document.getElementById('depositCard').addEventListener('mouseenter', function() {
        document.getElementById('depositForm').style.display = 'block';
    });
    
    // Hide deposit form when mouse leaves deposit card
    document.getElementById('depositCard').addEventListener('mouseleave', function() {
        document.getElementById('depositForm').style.display = 'none';
    });
</script>
<!-- End of Scripts -->
</body>
</html>
