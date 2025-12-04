<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>ClickFly - Home</title>
    <!-- Link CSS corretto -->
    <link rel="stylesheet" type="text/css" href="/clickfly-web/css/style.css">
</head>
<body>
    <%@ include file="header.jsp" %>

    <main class="container">
        <section class="hero">
            <div class="hero-inner">
                <img src="${pageContext.request.contextPath}/images/logo.png" alt="ClickFly" class="nav-logo">
                <h1>Benvenuto su ClickFly</h1>
                <p>Trova le migliori offerte per i tuoi voli. Prenota in pochi click!</p>
                <a class="cta" href="${pageContext.request.contextPath}/search.jsp">Cerca voli</a>
            </div>
        </section>

        <section class="cards">
            <article class="card">
                <h3>Offerte Last Minute</h3>
                <p>Scopri le nostre offerte giornaliere.</p>
            </article>
            <article class="card">
                <h3>Voli Nazionali</h3>
                <p>Comodità e rapidità per i voli interni.</p>
            </article>
            <article class="card">
                <h3>Voli Internazionali</h3>
                <p>Destinazioni in tutto il mondo.</p>
            </article>
        </section>
    </main>

    <%@ include file="footer.jsp" %>
</body>
</html>
