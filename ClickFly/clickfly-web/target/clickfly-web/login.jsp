<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Login - ClickFly</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <%@ include file="header.jsp" %>

    <main class="login-page">
        <h1>Login</h1>
        <form action="login" method="post" class="login-form">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="cta-btn">Accedi</button>
        </form>
        <p>Non hai un account? <a href="register.jsp">Registrati</a></p>
    </main>

    <%@ include file="footer.jsp" %>
</body>
</html>
