<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Welcome, ${sessionScope.username}</h2>
    <ul>
        <li><a href="addExpense.jsp">Add Expense</a></li>
        <li><a href="ViewExpensesServlet">View Recent Expenses</a></li>
        <li><a href="LogoutServlet">Logout</a></li>
    </ul>
</body>
</html>
