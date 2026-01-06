<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="site-header">
  <div class="nav-container">

    <div class="logo-wrap">
      <img src="${pageContext.request.contextPath}/images/logo.png" class="nav-logo" alt="ClickFly">
      <span class="brand">ClickFly</span>
    </div>

    <nav class="main-nav">
      <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/search.jsp">Cerca voli</a></li>

        <c:choose>
          <c:when test="${empty sessionScope.utente}">
            <li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/registrati.jsp">Registrati</a></li>
          </c:when>

          <c:otherwise>
            <li><a href="${pageContext.request.contextPath}/carrello.jsp">Carrello</a></li>
            <li>
              <a href="${pageContext.request.contextPath}/utente.jsp">
                ${sessionScope.utente.nome}
              </a>
            </li>
          </c:otherwise>
        </c:choose>

      </ul>
    </nav>
  </div>
</header>
