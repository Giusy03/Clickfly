<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="it">
<head>
  <meta charset="UTF-8">
  <title>Carrello - ClickFly</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<main class="container">
  <section class="page-header">
    <h1>Carrello</h1>
    <p class="muted">Rivedi i viaggi selezionati e procedi al checkout.</p>
  </section>

  <c:choose>
    <c:when test="${empty sessionScope.carrello}">
      <div class="empty-state">
        <h2>Il carrello è vuoto</h2>
        <p>Aggiungi un viaggio dal catalogo per continuare.</p>
        <a class="cta-btn" href="${pageContext.request.contextPath}/search.jsp">Cerca voli</a>
      </div>
    </c:when>

    <c:otherwise>
      <div class="card">
        <div class="card-body">
          <table class="results-table">
            <thead>
              <tr>
                <th>Destinazione</th>
                <th>Compagnia</th>
                <th>Prezzo</th>
                <th>Posti</th>
                <th>Azioni</th>
              </tr>
            </thead>

            <tbody>
              <c:forEach var="v" items="${sessionScope.carrello}">
                <tr>
                  <td>${v.destinazione}</td>
                  <td>${v.compagniaAerea}</td>
                  <td>€${v.prezzo}</td>
                  <td>${v.postiSelezionati}</td>
                  <td class="actions">
                    <a class="btn btn-danger"
                       href="${pageContext.request.contextPath}/RimuoviDalCarrelloServlet?id=${v.id}">
                       Rimuovi
                    </a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>

          <div class="actions-row">
            <a class="btn" href="${pageContext.request.contextPath}/search.jsp">Continua a cercare</a>
            <a class="cta-btn" href="${pageContext.request.contextPath}/checkout.jsp">Procedi al checkout</a>
          </div>
        </div>
      </div>
    </c:otherwise>
  </c:choose>
</main>

<%@ include file="footer.jsp" %>
</body>
</html>
