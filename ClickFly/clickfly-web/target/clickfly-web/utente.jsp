<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Area Personale - ClickFly</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<main class="user-page">

    <c:choose>
        <c:when test="${not empty sessionScope.utente}">
            <h1>
                Benvenuto,
                ${sessionScope.utente.nome}
                ${sessionScope.utente.cognome}!
            </h1>

            <section class="user-info">
                <h2>Informazioni account</h2>
                <p><strong>Email:</strong> ${sessionScope.utente.email}</p>
                <p><strong>Telefono:</strong> ${sessionScope.utente.telefono}</p>
                <p><strong>Registrato il:</strong> ${sessionScope.utente.dataRegistrazione}</p>
            </section>

            <section class="user-actions">
                <h2>Azioni</h2>
                <ul>
                    <li><a href="prenotazioni.jsp">Le mie prenotazioni</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                </ul>
            </section>
        </c:when>

        <c:otherwise>
            <p>Accesso non autorizzato.</p>
        </c:otherwise>
    </c:choose>

</main>

<%@ include file="footer.jsp" %>

</body>
</html>
