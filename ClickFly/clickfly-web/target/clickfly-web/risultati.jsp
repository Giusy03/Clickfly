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
                    <table class="results-table">
                        <thead>
                            <tr>
                                <th>Partenza</th>
                                <th>Arrivo</th>
                                <th>Data</th>
                                <th>Ora Partenza</th>
                                <th>Ora Arrivo</th>
                                <th>Prezzo</th>
                                <th>Compagnia</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="volo" items="${voli}">
                                <tr>
                                    <td>${volo.cittaPartenza}</td>
                                    <td>${volo.cittaArrivo}</td>
                                    <td>${volo.data}</td>
                                    <td>${volo.oraPartenza}</td>
                                    <td>${volo.oraArrivo}</td>
                                    <td>€${volo.prezzo}</td>
                                    <td>${volo.compagnia}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </section>
    </main>

    <%@ include file="footer.jsp" %>

</body>
</html>
