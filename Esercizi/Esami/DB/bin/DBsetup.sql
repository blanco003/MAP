-- esegui questo su mysql se non è già presente 

DROP DATABASE IF EXISTS  esempioDB ;
DROP USER IF EXISTS root@localhost;
CREATE DATABASE esempioDB;
CREATE USER 'root'@'localhost' IDENTIFIED BY 'admin';
GRANT SELECT, INSERT ON esempioDB.* TO 'root'@'localhost';

USE esempioDB;

CREATE TABLE clienti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    NOME varchar(30),
    COGNOME varchar(30),
    CF varchar(30),
    REDDITO int
);

INSERT INTO clienti (NOME,COGNOME,CF,REDDITO) VALUES ('Mario', 'Rossi', 'MRDFMASDKAS31',100);
INSERT INTO clienti (NOME,COGNOME,CF,REDDITO) VALUES ('Giuseppe', 'Verdi','VDRDFDMASDK31',1200);
INSERT INTO clienti (NOME,COGNOME,CF,REDDITO) VALUES ('Giovanni', 'Rossi','GCAAASDDKAS31',1300);
INSERT INTO clienti (NOME,COGNOME,CF,REDDITO) VALUES ('Marco', 'Blui', 'MRDFMASDKAS31',400);

