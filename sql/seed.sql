CREATE TABLE if not exists users (
  id int PRIMARY KEY AUTO_INCREMENT,
  nome varchar(75),
  cognome varchar(75),
  data_nascita date,
  email varchar(50),
  password varchar(50),
  ruolo enum('cliente', 'amministratore')
);

CREATE TABLE if not exists stato (
  id int PRIMARY KEY AUTO_INCREMENT,
  indirizzo varchar(255),
  gps varchar(50),
  disponibilita boolean
);

CREATE TABLE if not exists prenotazioni (
  id int PRIMARY KEY AUTO_INCREMENT,
  veicolo_id int,
  utente_id int,
  data_prenotazione date,
  status enum('in prenotazione','terminata')
);



CREATE TABLE if not exists veicoli (
  id int PRIMARY KEY AUTO_INCREMENT,
  modello varchar(20),
  marca varchar(20),
  categoria enum('auto','monopattino','bicicletta','motoveicolo'),
  alimentazione enum('diesel','benzina','elettrica','ibrida', 'muscolare'),
  immagine varchar(255),
  trazione enum('anteriore','posteriore','integrale'),
  stato_id int
);


ALTER TABLE veicoli ADD FOREIGN KEY (`stato_id`) REFERENCES `stato` (`id`);

ALTER TABLE prenotazioni ADD FOREIGN KEY (`utente_id`) REFERENCES `users` (`id`);

ALTER TABLE prenotazioni ADD FOREIGN KEY (`veicolo_id`) REFERENCES `veicoli` (`id`);


