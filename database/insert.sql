INSERT INTO kysely (kyselyId, kyselyName, kyselyDesc)
VALUES
(1,
'Kysely opiskelijoiden pys�k�intimahdollisuuksista Haaga-Helian Pasilan kampuksella.',
'Haluamme t�ll� kyselyll� selvitt��, ovatko opiskelijat tyytyv�isi� Pasilan kampuksen tarjoamiin pys�k�intimahdollisuuksiin ja pit�isik� koulun tarjota parempia pys�k�intipalveluja opiskelijoille.');

INSERT INTO kysymys (kysymysId, kysymys, kysymysType, kyselyId)
VALUES
(1, 'Miten kuljet t�ll� hetkell� Pasilan kampukselle: k�vellen/py�r�ll�, julkisilla vai omalla autolla?', 'radio', 1),
(2, 'Olisiko sinulle hy�dyllist� tulla kouluun k�ytt�en yksityisautoa (esimerkiksi hy�tyisitk� siit� ajallisesti, jos et asu koulun l�hell�)?', 'radio', 1),
(3, 'Miten kuvailisit Haaga-Helian Pasilan kampuksen tarjoamia t�m�nhetkisi� opiskelijoiden pys�k�intimahdollisuuksia?', 'text', 1),
(4, 'Oletko tyytyv�inen n�ihin pys�k�intivaihtoehtoihin?', 'radio', 1),
(5, 'Onko mielest�si Pasilan kampuksen l�heisyydess� tarpeeksi parkkipaikkoja?', 'radio', 1),
(6, 'Mitk� asiat ovat mielest�si haastavia koulun l�helle pys�k�imisess�?', 'text', 1),
(7, 'Miten parantaisit koulun tarjoamia pys�k�intipalveluita?', 'text', 1),
(8, 'Alkaisitko k�ytt�� autoa kouluun tullessa, jos pys�k�inti koulun l�helle olisi helpompaa?', 'radio', 1),
(9, 'Kuinka paljon olisit valmis maksamaan pys�k�innist� kuukausittain?', 'radio', 1);

INSERT INTO valinta (valintaId, valintaName, kysymysId)
VALUES
(1, 'K�vellen tai py�r�ll�', 1),
(2, 'Joukkoliikenteell�', 1),
(3, 'Omalla tai jonkun muun autolla', 1),
(4, 'Siit� olisi v�h�n hy�ty�', 2),
(5, 'Siit� olisi paljon hy�ty�', 2),
(6, 'Siit� ei olisi hy�ty�', 2),
(7, 'Kyll�', 4),
(8, 'Ei', 4),
(9, 'Kyll�', 5),
(10, 'Ei', 5),
(11, 'Kyll�', 8),
(12, 'Ei', 8),
(13, 'Joskus', 8),
(14, '0�', 9),
(15, '1-10�', 9),
(16, '11-20�', 9),
(17, '21-40�', 9),
(18, 'Yli 40�', 9);

INSERT INTO kayttaja (kayttajaId, kayttajaName, kayttajaPassword, kayttajaRole)
VALUES
(1, 'Master', 'salasana', 'Admin');

INSERT INTO kayttajanKysely (kayttajankyselyId, kyselyId, kayttajaId)
VALUES
(1, 1, 1);