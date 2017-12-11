INSERT INTO kysely (kyselyId, kyselyName, kyselyDesc)
VALUES
(1,
'Kysely opiskelijoiden pysäköintimahdollisuuksista Haaga-Helian Pasilan kampuksella.',
'Haluamme tällä kyselyllä selvittää, ovatko opiskelijat tyytyväisiä Pasilan kampuksen tarjoamiin pysäköintimahdollisuuksiin ja pitäisikö koulun tarjota parempia pysäköintipalveluja opiskelijoille.');

INSERT INTO kysymys (kysymysId, kysymys, kysymysType, kyselyId)
VALUES
(1, 'Miten kuljet tällä hetkellä Pasilan kampukselle: kävellen/pyörällä, julkisilla vai omalla autolla?', 'radio', 1),
(2, 'Olisiko sinulle hyödyllistä tulla kouluun käyttäen yksityisautoa (esimerkiksi hyötyisitkö siitä ajallisesti, jos et asu koulun lähellä)?', 'radio', 1),
(3, 'Miten kuvailisit Haaga-Helian Pasilan kampuksen tarjoamia tämänhetkisiä opiskelijoiden pysäköintimahdollisuuksia?', 'text', 1),
(4, 'Oletko tyytyväinen näihin pysäköintivaihtoehtoihin?', 'radio', 1),
(5, 'Onko mielestäsi Pasilan kampuksen läheisyydessä tarpeeksi parkkipaikkoja?', 'radio', 1),
(6, 'Mitkä asiat ovat mielestäsi haastavia koulun lähelle pysäköimisessä?', 'text', 1),
(7, 'Miten parantaisit koulun tarjoamia pysäköintipalveluita?', 'text', 1),
(8, 'Alkaisitko käyttää autoa kouluun tullessa, jos pysäköinti koulun lähelle olisi helpompaa?', 'radio', 1),
(9, 'Kuinka paljon olisit valmis maksamaan pysäköinnistä kuukausittain?', 'radio', 1);

INSERT INTO valinta (valintaId, valintaName, kysymysId)
VALUES
(1, 'Kävellen tai pyörällä', 1),
(2, 'Joukkoliikenteellä', 1),
(3, 'Omalla tai jonkun muun autolla', 1),
(4, 'Siitä olisi vähän hyötyä', 2),
(5, 'Siitä olisi paljon hyötyä', 2),
(6, 'Siitä ei olisi hyötyä', 2),
(7, 'Kyllä', 4),
(8, 'Ei', 4),
(9, 'Kyllä', 5),
(10, 'Ei', 5),
(11, 'Kyllä', 8),
(12, 'Ei', 8),
(13, 'Joskus', 8),
(14, '0€', 9),
(15, '1-10€', 9),
(16, '11-20€', 9),
(17, '21-40€', 9),
(18, 'Yli 40€', 9);

INSERT INTO kayttaja (kayttajaId, kayttajaName, kayttajaPassword, kayttajaRole)
VALUES
(1, 'Master', 'salasana', 'Admin');

INSERT INTO kayttajanKysely (kayttajankyselyId, kyselyId, kayttajaId)
VALUES
(1, 1, 1);