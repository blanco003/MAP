-- prima di avviare DbAccess bisogna creare il db sulla propria macchina nel terminale mysql se non già presente

DROP DATABASE IF EXISTS  MapDB ;
DROP USER IF EXISTS MapUser@localhost;
CREATE DATABASE MapDB;
CREATE USER 'MapUser'@'localhost' IDENTIFIED BY 'map';
GRANT SELECT ON MapDB.* TO 'MapUser'@'localhost';

USE MapDB;

CREATE TABLE peoplecsv (
    id INT AUTO_INCREMENT PRIMARY KEY,
    FIRST VARCHAR(50),
    LAST VARCHAR(50),
    EMAIL VARCHAR(100)
);

INSERT INTO peoplecsv (FIRST,LAST,EMAIL) VALUES ('Mario', 'Rossi', 'mario.rossi@example.com');
INSERT INTO peoplecsv (FIRST,LAST,EMAIL) VALUES ('Giuseppe', 'Map', 'giuseppe.map@example.com');
INSERT INTO peoplecsv (FIRST,LAST,EMAIL) VALUES ('Alice', 'Gialli', 'alice.gialli@example.com');
INSERT INTO peoplecsv (FIRST,LAST,EMAIL) VALUES ('Marco', 'Map', 'marco.map@example.com');