<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="header.jsp" %>

<main class="results-page">
    <div class="results-container">

        <h1 class="title">Risultati della ricerca</h1>

        <p class="subtitle">
            Voli da <strong>${from}</strong> a <strong>${to}</strong> il 
            <strong>${date}</strong> per <strong>${passengers}</strong> passeggeri.
        </p>

        <div class="results-list">

            <!-- Risultati MOCK finché non facciamo il DB -->
            <div class="result-card">
                <h3>ClickAir 402</h3>
                <p>Partenza: 09:20</p>
                <p>Arrivo: 11:05</p>
                <p>Prezzo: <strong>89€</strong></p>
            </div>

            <div class="result-card">
                <h3>SkyJet 119</h3>
                <p>Partenza: 13:45</p>
                <p>Arrivo: 15:30</p>
                <p>Prezzo: <strong>102€</strong></p>
            </div>

            <div class="result-card">
                <h3>FlyGo 55</h3>
                <p>Partenza: 18:10</p>
                <p>Arrivo: 20:00</p>
                <p>Prezzo: <strong>120€</strong></p>
            </div>

        </div>

    </div>
</main>

<%@ include file="footer.jsp" %>
