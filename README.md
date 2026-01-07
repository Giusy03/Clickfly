CLICKFLY — Piattaforma di Prenotazione Voli

ClickFly è una web application Java sviluppata con Servlet, JSP e JDBC che simula una piattaforma completa di ricerca, selezione e prenotazione di voli aerei.

L’applicazione permette agli utenti di:
- Cercare voli per tratta e data
- Visualizzare i risultati in modo chiaro e ordinato
- Aggiungere voli al carrello
- Gestire il carrello (aggiunta / rimozione voli)
- Effettuare il login/logout
- Procedere al checkout e alla prenotazione

Il progetto è stato realizzato con una architettura MVC, separando chiaramente:
- Logica di business
- Accesso ai dati
- Interfaccia utente

ARCHITETTURA DEL PROGETTO

Il progetto segue il pattern MVC (Model-View-Controller):
Model
  Contiene le classi che rappresentano le entità del dominio:
    Volo → rappresenta un volo
    CarrelloItem → rappresenta un elemento nel carrello
    Utente → rappresenta un utente loggato
DAO (Data Access Object)
  VoloDAO → accesso al database per la ricerca e recupero dei voli
  (eventuali altri DAO per utenti, prenotazioni, ecc.)

Tutto l’accesso al database avviene tramite JDBC usando PreparedStatement per sicurezza e performance.

Controller (Servlet)
Gestiscono tutta la logica applicativa:
- CercaVoliServlet → gestisce la ricerca voli
- AggiungiAlCarrelloServlet → aggiunge un volo al carrello in sessione
- RimuoviDalCarrelloServlet → rimuove un volo dal carrello
- LoginServlet → autenticazione utente
- LogoutServlet → invalidazione sessione
- CheckoutServlet → gestione prenotazione

View (JSP)
- index.jsp → home page
- search.jsp → ricerca voli
- risultati.jsp → risultati della ricerca
- carrello.jsp → gestione carrello
- login.jsp → login utente
- areaUtente.jsp → area personale

Le JSP usano:
- JSTL
- Expression Language (EL)
- Componenti riutilizzabili (header.jsp, footer.jsp)

Gestione Carrello
Il carrello è gestito in sessione:
  List<CarrelloItem> carrello = (List<CarrelloItem>) session.getAttribute("carrello");

Ogni elemento contiene:
- ID volo
- Descrizione
- Compagnia
- Prezzo
- Quantità
- Funzionalità:
  - Aggiunta voli
  - Incremento quantità se il volo è già presente
  - Rimozione singolo volo
  - Visualizzazione con layout a card

Database: MySQL
Tabelle principali:
- utenti
- voli
- prenotazioni
- carrello
- carrello_voci

Relazioni:
- Un utente può avere più prenotazioni
- Un carrello è associato a un utente
- Un carrello contiene più voli

Autenticazione e Sessione
- Login tramite email e password
- L’utente viene salvato in sessione: session.setAttribute("utente", utente);

Le pagine protette controllano:

<c:if test="${empty sessionScope.utente}">
    redirect al login
</c:if>


Logout:
session.invalidate();

Interfaccia Grafica
- Layout moderno a cards
- Tabelle responsive
- Pulsanti stilizzati
- UI coerente tra risultati ricerca e carrello
- CSS personalizzato

Tecnologie Utilizzate
- Java 8+
- JSP
- Servlet
- JSTL
- JDBC
- MySQL
- Apache Tomcat 9
- HTML5 / CSS3

Come eseguire il progetto
- Clonare il repository
- Importare il progetto in IntelliJ / Eclipse
- Configurare il database MySQL
- Eseguire lo script SQL incluso
- Configurare il datasource o DBManager
- Avviare il progetto su Tomcat 9
- Aprire: http://localhost:8080/ClickFly
