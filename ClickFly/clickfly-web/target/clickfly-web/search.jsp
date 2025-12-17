<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Cerca Voli</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <%@ include file="header.jsp" %>

    <main class="search-page">
        <section class="search-container">
            <h1 class="title">Cerca il tuo volo</h1>
            <p class="subtitle">Trova le migliori offerte in tempo reale</p>

            <form action="${pageContext.request.contextPath}/search" method="get" class="search-form">

                <div class="form-group">
                    <label for="from">Da</label>
                    <input type="text" id="from" name="from" placeholder="Città di partenza" required>
                </div>

                <div class="form-group">
                    <label for="to">A</label>
                    <input type="text" id="to" name="to" placeholder="Città di arrivo" required>
                </div>

                <div class="form-group">
                    <label for="date">Data</label>
                    <input type="date" id="date" name="date" required>
                </div>

                <div class="form-group">
                    <label for="passengers">Passeggeri</label>
                    <select id="passengers" name="passengers">
                        <option value="1">1 Adulto</option>
                        <option value="2">2 Adulti</option>
                        <option value="3">3 Adulti</option>
                        <option value="4">4 Adulti</option>
                    </select>
                </div>

                <button type="submit" class="cta-btn">Cerca volo</button>
            </form>
        </section>
    </main>

    <%@ include file="footer.jsp" %>

</body>
</html>
