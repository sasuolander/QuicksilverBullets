/*CREATE DATABASE projekti tämä ei toimi koulun palvelimissa kun ei ole oikeuksia.*/
CREATE TABLE kysely(
kyselyId smallint(6) not null auto_increment PRIMARY KEY,
kyselyName varchar(250) not null,
kyselyDesc varchar(250));

CREATE TABLE kysymys(
kysymysId smallint(6) not null auto_increment PRIMARY KEY, 
kysymys varchar(250) not null, 
kysymysType varchar(250) not null,
kyselyId smallint(6) not null,
FOREIGN KEY (kyselyId) REFERENCES kysely(kyselyId));

CREATE TABLE vastaus(
vastausId smallint(6) auto_increment PRIMARY KEY not null,
vastaus varchar(250) not null,
kysymysId smallint(6) not null,
FOREIGN KEY (kysymysId) REFERENCES kysymys(kysymysId));
