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

            <section class="user-wallet">
                <h2>💰 Portafoglio</h2>
                <p><strong>Saldo attuale:</strong> € ${sessionScope.utente.saldo}</p>

                <form action="${pageContext.request.contextPath}/ricarica-saldo" method="post">
                    <label for="importo">Importo da ricaricare:</label>
                    <input type="number" name="importo" step="0.01" min="1" required>
                    <button type="submit" class="cta-btn">Ricarica</button>
                </form>
            </section>

            <section class="user-actions">
                <h2>Azioni</h2>
                <ul>
                    <a href="${pageContext.request.contextPath}/prenotazioni">Le mie prenotazioni</a>
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
