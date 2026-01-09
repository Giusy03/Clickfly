<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
      <div class="card empty-state">
        <div class="card-body">
          <h2>Il carrello è vuoto</h2>
          <p>Aggiungi un viaggio dal catalogo per continuare.</p>
          <div class="actions-row">
            <a class="cta-btn" href="${pageContext.request.contextPath}/search.jsp">Cerca voli</a>
          </div>
        </div>
      </div>
    </c:when>

    <c:otherwise>
      <c:set var="totale" value="0" scope="page"/>
      <div class="cards-grid">
        <c:forEach var="v" items="${sessionScope.carrello}">
          <div class="card">
            <div class="card-body">
              <h3>${v.descrizione}</h3>
              <p><strong>Compagnia:</strong> ${v.compagnia}</p>
              <p><strong>Prezzo unitario:</strong> €<fmt:formatNumber value="${v.prezzo}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
              <p><strong>Quantità:</strong> ${v.quantita}</p>
              <p><strong>Totale volo:</strong> €<fmt:formatNumber value="${v.prezzo * v.quantita}" type="number" minFractionDigits="2" maxFractionDigits="2"/></p>
              <c:set var="totale" value="${totale + (v.prezzo * v.quantita)}" scope="page"/>
              <div class="actions-row">
                <form action="${pageContext.request.contextPath}/rimuovi-dal-carrello" method="get" style="display:inline;">
                  <input type="hidden" name="id" value="${v.voloId}">
                  <button type="submit" class="btn btn-danger">Rimuovi</button>
                </form>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>

      <div class="cart-total" style="margin-top: 20px; font-size: 1.2em; font-weight: bold;">
        Totale carrello: €<fmt:formatNumber value="${totale}" type="number" minFractionDigits="2" maxFractionDigits="2"/>
      </div>

      <div class="actions-row" style="margin-top: 20px;">
        <a class="btn" href="${pageContext.request.contextPath}/search.jsp">Continua a cercare</a>
        <a class="cta-btn" href="${pageContext.request.contextPath}/checkout.jsp">Procedi al checkout</a>
      </div>
    </c:otherwise>
  </c:choose>

</main>

<%@ include file="footer.jsp" %>
</body>
</html>
