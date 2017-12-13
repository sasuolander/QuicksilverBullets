CREATE DATABASE projekti /*tämä kohta ei toimi koulun palvelimissa koska ei ole oikeuksia luoda uutta tietokantaa.*/
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

CREATE TABLE valinta(
valintaId smallint(6) auto_increment PRIMARY KEY not null,
valintaName varchar(250) not null,
kysymysId smallint(6) not null,
FOREIGN KEY (kysymysId) REFERENCES kysymys(kysymysId));

CREATE TABLE kayttaja(
kayttajaId smallint(6) auto_increment PRIMARY KEY not null,
kayttajaName varchar(250) not null,
kayttajaPassword varchar(250) not null,
kayttajaRole varchar(250) not null);

CREATE TABLE kayttajanKysely(
kayttajanKyselyId smallint(6) auto_increment PRIMARY KEY not null,
kyselyId smallint(6) not null,
kayttajaId smallint(6) not null,
FOREIGN KEY (kyselyId) REFERENCES kysely(kyselyId),
FOREIGN KEY (kayttajaId) REFERENCES kayttaja(kayttajaId));