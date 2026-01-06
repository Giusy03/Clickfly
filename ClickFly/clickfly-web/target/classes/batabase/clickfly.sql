CREATE DATABASE clickfly;
USE clickfly;

CREATE TABLE utenti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    data_registrazione DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE voli (
    id INT AUTO_INCREMENT PRIMARY KEY,
    citta_partenza VARCHAR(50) NOT NULL,
    citta_arrivo VARCHAR(50) NOT NULL,
    data DATE NOT NULL,
    ora_partenza TIME NOT NULL,
    ora_arrivo TIME NOT NULL,
    prezzo DECIMAL(10,2) NOT NULL,
    compagnia VARCHAR(50) NOT NULL,
    posti_disponibili INT NOT NULL DEFAULT 100
);

CREATE TABLE prenotazioni (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_utente INT NOT NULL,
    id_volo INT NOT NULL,
    data_prenotazione DATETIME DEFAULT CURRENT_TIMESTAMP,
    numero_passeggeri INT NOT NULL,
    prezzo_totale DECIMAL(10,2) NOT NULL,
    
    FOREIGN KEY (id_utente) REFERENCES utenti(id) ON DELETE CASCADE,
    FOREIGN KEY (id_volo) REFERENCES voli(id) ON DELETE CASCADE
);

CREATE TABLE carrello (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_utente INT NOT NULL UNIQUE,
    data_creazione DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (id_utente) REFERENCES utenti(id) ON DELETE CASCADE
);

CREATE TABLE carrello_voci (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_carrello INT NOT NULL,
    id_volo INT NOT NULL,
    numero_passeggeri INT NOT NULL DEFAULT 1,
    
    FOREIGN KEY (id_carrello) REFERENCES carrello(id) ON DELETE CASCADE,
    FOREIGN KEY (id_volo) REFERENCES voli(id) ON DELETE CASCADE
);

INSERT INTO voli (citta_partenza, citta_arrivo, data, ora_partenza, ora_arrivo, prezzo, compagnia)
VALUES
('Roma', 'Milano', '2025-02-03', '09:00', '10:10', 49.99, 'ITA Airways'),
('Roma', 'Milano', '2025-02-03', '12:20', '13:30', 29.99, 'Ryanair'),
('Napoli', 'Torino', '2025-02-03', '08:15', '10:00', 59.90, 'WizzAir'),
('Bari', 'Roma', '2025-02-04', '14:00', '15:10', 42.50, 'ITA Airways'),
('Palermo', 'Venezia', '2025-02-04', '18:00', '20:00', 85.00, 'Volotea');
