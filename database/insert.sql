INSERT INTO kysely (kyselyId, kyselyName, kyselyDesc)
VALUES
(1,
'Kysely opiskelijoiden pysäköintimahdollisuuksista',
'Haluamme selvittää ovatko opiskelijat tyytyväisiä
Pasilan kampuksen tarjoamiin pysäköintimahdollisuuksiin ja pitäisikö koulun tarjota paremmat pysäköintipalvelut
opiskelijoille.');

INSERT INTO kysymys (kysymysId, kysymys, kysymysType, kyselyId)
VALUES
(1, 'Miten kuvailisit Haaga-Helian Pasilan kampuksen tarjoamia pysäköinti mahdollisuuksia opiskelijoille?', 'text', 1);
(2, 'Miten parantaisit koulun tarjoamia pysäköintipalveluita?', 'text', 1);
(3, 'Mikä on mielestäsi haastavinta koululle/koulun lähelle pysäköimisessä?', 'text', 1);
(4, 'Onko koululle/koulun lähelle pysäköinti vaikeaa?', 'radio', 1);


INSERT INTO vastaus (vastausId, vastaus, kysymysId)
VALUES
(1, 'En tiedä, en autoile', 1);
(2, 'En tiedä, en autoile', 2);
(3, 'Parkkipaikkoja ei ole lähellä, tai ne ovat kalliita', 3);
(4, 'Kyllä', 4);

INSERT INTO valinta (valintaId, valintaName, kysymysId)
VALUES
(1, 'Kyllä', 4);
(2, 'Ei', 4);

INSERT INTO kayttaja (kayttajaId, kayttajaName, kayttajaPassword, kayttajaRole)
VALUES
(1, 'Master', 'salasana', 'Admin');

INSERT INTO kayttajanKysely (kayttajankyselyId, kyselyId, kayttajaId)
VALUES
(1, 1, 1);