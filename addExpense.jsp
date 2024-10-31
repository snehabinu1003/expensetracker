<!DOCTYPE html>
<html>
<head>
    <title>Add Expense</title>
</head>
<body>
    <h2>Add New Expense</h2>
    <form action="AddExpenseServlet" method="post">
        Amount: <input type="text" name="amount" required><br>
        Date: <input type="date" name="date" required><br>
        Category: 
        <select name="category" required>
            <option value="Food">Food</option>
            <option value="Transport">Transport</option>
            <option value="Entertainment">Entertainment</option>
            <option value="Health">Health</option>
            <option value="Other">Other</option>
        </select><br>
        <input type="submit" value="Add Expense">
    </form>
    <p><a href="home.jsp">Go Back to Home</a></p>
</body>
</html>
