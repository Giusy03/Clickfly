<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="header.jsp"/>

<main class="container mt-5 profile-page">

    <div class="page-head">
        <h2 class="page-title">Area personale</h2>
        <p class="page-subtitle">Qui puoi visualizzare i tuoi dati e gestire le sezioni principali di ClickFly.</p>
    </div>

    <c:choose>

        <!-- NON autenticato -->
        <c:when test="${empty sessionScope.utente}">
            <div class="profile-empty">
                <div class="alert alert-warning mt-4">
                    <strong>Accesso non effettuato.</strong>
                    Per continuare, effettua il login.
                </div>

                <div class="mt-3 d-flex gap-2">
                    <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-primary">
                        🔐 Vai al Login
                    </a>
                    <a href="${pageContext.request.contextPath}/registrati.jsp" class="btn btn-outline-secondary">
                        ✍️ Registrati
                    </a>
                </div>
            </div>
        </c:when>

        <!-- autenticato -->
        <c:otherwise>

            <c:set var="username" value="${sessionScope.utente.username}" />
            <c:set var="email" value="${sessionScope.utente.email}" />

            <div class="row g-4 mt-3">

                <!-- CARD PROFILO -->
                <div class="col-12 col-lg-7">
                    <div class="card profile-card shadow-sm">
                        <div class="card-body">

                            <div class="d-flex align-items-center gap-3">
                                <!-- Avatar con iniziale -->
                                <div class="profile-avatar">
                                    <c:choose>
                                        <c:when test="${not empty username}">
                                            ${fn:toUpperCase(fn:substring(username,0,1))}
                                        </c:when>
                                        <c:otherwise>U</c:otherwise>
                                    </c:choose>
                                </div>

                                <div class="profile-headings">
                                    <h3 class="card-title mb-1">
                                        <c:choose>
                                            <c:when test="${not empty username}">${username}</c:when>
                                            <c:otherwise>Utente</c:otherwise>
                                        </c:choose>
                                    </h3>
                                    <p class="text-muted mb-0">
                                        <c:choose>
                                            <c:when test="${not empty email}">${email}</c:when>
                                            <c:otherwise>Email non disponibile</c:otherwise>
                                        </c:choose>
                                    </p>
                                </div>
                            </div>

                            <hr class="my-4"/>

                            <div class="profile-info">
                                <p class="mb-2"><strong>Username:</strong>
                                    <c:choose>
                                        <c:when test="${not empty username}">${username}</c:when>
                                        <c:otherwise>Non disponibile</c:otherwise>
                                    </c:choose>
                                </p>

                                <p class="mb-0"><strong>Email:</strong>
                                    <c:choose>
                                        <c:when test="${not empty email}">${email}</c:when>
                                        <c:otherwise>Non disponibile</c:otherwise>
                                    </c:choose>
                                </p>
                            </div>

                        </div>
                    </div>
                </div>

                <!-- AZIONI RAPIDE -->
                <div class="col-12 col-lg-5">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h4 class="mb-3">Azioni rapide</h4>

                            <div class="d-grid gap-2">
                                <a href="${pageContext.request.contextPath}/carrello.jsp" class="btn btn-success">
                                    🧳 Vai al Carrello
                                </a>

                                <a href="${pageContext.request.contextPath}/search.jsp" class="btn btn-outline-primary">
                                    🔎 Cerca voli
                                </a>

                                <!-- se hai prenotazioni.jsp, lascialo; altrimenti elimina questo bottone -->
                                <a href="${pageContext.request.contextPath}/prenotazioni.jsp" class="btn btn-outline-secondary">
                                    📄 Le mie prenotazioni
                                </a>

                                <a href="${pageContext.request.contextPath}/LogoutServlet" class="btn btn-danger">
                                    🚪 Logout
                                </a>
                            </div>

                            <p class="text-muted mt-3 mb-0" style="font-size: 0.95rem;">
                                Suggerimento: usa “Cerca voli” per aggiungere un viaggio al carrello in pochi secondi.
                            </p>
                        </div>
                    </div>
                </div>

            </div>

        </c:otherwise>

    </c:choose>

</main>

<jsp:include page="footer.jsp"/>
