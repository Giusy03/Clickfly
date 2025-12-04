<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header class="site-header">
    <div class="nav-container">
        <div class="logo-wrap">
            <a href="${pageContext.request.contextPath}/">
                <img src="${pageContext.request.contextPath}/images/logo.png" alt="ClickFly" class="nav-logo">
            </a>
            <span class="brand">ClickFly</span>
        </div>

        <nav class="main-nav">
            <ul>
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/search.jsp">Cerca Voli</a></li>
                <li><a href="${pageContext.request.contextPath}/offers.jsp">Offerte</a></li>
                <li><a href="${pageContext.request.contextPath}/cart.jsp">Carrello</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
                <li><a href="${pageContext.request.contextPath}/register.jsp">Registrati</a></li>
                <li><a href="${pageContext.request.contextPath}/contact.jsp">Contatti</a></li>
            </ul>
        </nav>
    </div>
</header>

