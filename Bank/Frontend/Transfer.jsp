<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transfer Funds</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <div class="container-fluid d-flex justify-content-center align-items-center min-vh-100 login-background">
        <div class="card login-card">
            <div class="card-body position-relative">
                <h1 class="card-title text-center">Transfer Funds</h1>
                <form id="transferForm" action="Menu" method="post">
                    <div class="form-group">
                        <label for="toUserId">Receiver User ID</label>
                        <input type="number" class="form-control" id="toUserId" name="UserId" required>
                    </div>
                    <div class="form-group">
                        <label for="amount">Amount</label>
                        <input type="number" class="form-control" id="amount" name="amount" required>
                    </div>
                    <!-- Hidden input field to store the action value -->
                    <input type="hidden" id="action" name="action" value="">
                    <input type="hidden" id="cornfirm" name="cornfirm" value="">
                    <!-- Styled Go Back button -->
                    <button onclick="goBack()" type="button" class="btn btn-primary btn-block mb-3">Go Back</button>
                    <button type="button" class="btn btn-primary btn-block" onclick="showModal()">Transfer</button>
                </form>
                <div class="logo-background">Abishek</div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="confirmModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Confirm Transfer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to transfer the following amount?</p>
                    <p><strong>Receiver User ID:</strong> <span id="confirmToUserId"></span></p>
                    <p><strong>Amount:</strong> Rs<span id="confirmAmount"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary" onclick="submitForm()">Confirm</button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        function showModal() {
            const toUserId = document.getElementById('toUserId').value;
            const amount = document.getElementById('amount').value;

            document.getElementById('confirmToUserId').textContent = toUserId;
            document.getElementById('confirmAmount').textContent = amount;

            // Set the value of the hidden input field
            document.getElementById('action').value = 'transfer';
            document.getElementById('cornfirm').value = 1;
            $('#confirmModal').modal('show');
        }

        function submitForm() {
            document.getElementById('transferForm').submit();
        }
        
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
