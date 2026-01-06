<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>ClickFly - Risultati della ricerca</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<main class="results-page">
    <section class="results-container">
        <h1>Risultati della ricerca</h1>

        <c:choose>
            <c:when test="${empty voli}">
                <p>Nessun volo trovato.</p>
            </c:when>
            <c:otherwise>
                <div class="flights-grid">
                    <c:forEach var="volo" items="${voli}">
                        <div class="flight-card">
                            <div class="flight-info">
                                <p><strong>Da:</strong> ${volo.cittaPartenza}</p>
                                <p><strong>A:</strong> ${volo.cittaArrivo}</p>
                                <p><strong>Data:</strong> ${volo.data}</p>
                                <p><strong>Ora partenza:</strong> ${volo.oraPartenza}</p>
                                <p><strong>Ora arrivo:</strong> ${volo.oraArrivo}</p>
                                <p><strong>Compagnia:</strong> ${volo.compagnia}</p>
                                <p><strong>Prezzo:</strong> €${volo.prezzo}</p>
                            </div>
                            <form method="post" action="${pageContext.request.contextPath}/aggiungi-al-carrello">
                                <input type="hidden" name="idVolo" value="${volo.id}">
                                <button type="submit" class="btn-cta">Aggiungi al carrello</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

    </section>
</main>

<%@ include file="footer.jsp" %>

</body>
</html>
