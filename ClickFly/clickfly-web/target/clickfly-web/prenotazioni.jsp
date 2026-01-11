<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="it">
<head>
    <title>Le mie prenotazioni</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<main class="container">

<h1 style="text-align:center; margin-bottom: 30px;">Le mie prenotazioni</h1>

<c:choose>

    <c:when test="${empty prenotazioni}">
        <p style="text-align:center;">Non hai ancora effettuato nessuna prenotazione.</p>
    </c:when>

    <c:otherwise>
        <div class="cards-grid">
            <c:forEach var="p" items="${prenotazioni}">
                <div class="card">
                    <div class="card-body">

                        <p style="font-size: 13px; color: #777;">
                            Codice prenotazione: <strong>#${p.id}</strong>
                        </p>

                        <h3>${p.cittaPartenza} → ${p.cittaArrivo}</h3>

                        <p><strong>Compagnia:</strong> ${p.compagnia}</p>
                        <p><strong>Data prenotazione:</strong> ${p.dataPrenotazione}</p>
                        <p><strong>Posti:</strong> ${p.numeroPasseggeri}</p>
                        <p><strong>Totale:</strong> €${p.prezzoTotale}</p>

                    </div>
                </div>
            </c:forEach>
        </div>
    </c:otherwise>

</c:choose>

</main>

<%@ include file="footer.jsp" %>

</body>
</html>
