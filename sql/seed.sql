CREATE TABLE if not exists users (
  id int PRIMARY KEY AUTO_INCREMENT,
  nome varchar(75),
  cognome varchar(75),
  data_nascita date,
  email varchar(50),
  password varchar(50),
  ruolo enum('cliente', 'amministratore')
);

CREATE TABLE if not exists veicoli (
  id int PRIMARY KEY AUTO_INCREMENT,
  categoria enum('auto','monopattino','bicicletta','motoveicolo'),
  descrizione_id int,
  alimentazione enum('diesel','benzina','elettrica','ibrida', 'muscolare'),
  indirizzo varchar(255),
  gps varchar(50),
  disponibilita boolean,
  immagine varchar(255),
  status enum('prenotata','disponibile')
);

CREATE TABLE if not exists prenotazioni (
  id int PRIMARY KEY AUTO_INCREMENT,
  veicolo_id int,
  utente_id int,
  data_prenotazione date,
  status enum('in prenotazione','terminata')
);



CREATE TABLE if not exists descrizioni (
  id int PRIMARY KEY AUTO_INCREMENT,
  modello varchar(20),
  marca varchar(20),
  kw tinyint,
  peso smallint,
  cavalli tinyint,
  trazione enum('anteriore','posteriore','integrale')
  cilindrata smallint

);


ALTER TABLE veicoli ADD FOREIGN KEY (`descrizione_id`) REFERENCES `descrizioni` (`id`);

ALTER TABLE prenotazioni ADD FOREIGN KEY (`utente_id`) REFERENCES `users` (`id`);

ALTER TABLE prenotazioni ADD FOREIGN KEY (`veicolo_id`) REFERENCES `veicoli` (`id`);


