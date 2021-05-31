--INSERTING account_type

INSERT INTO account_types (account_type) values('Bruger');
INSERT INTO account_types (account_type) values('Producent');
INSERT INTO account_types (account_type) values('Admin');
INSERT INTO account_types (account_type) values('Forretningsperson');


--INSERTING users

INSERT INTO Users (account_type, name, username, email, password, dato) values(admin, 'admin1', 'admin1', '@admin1@', 'admin1', NOW());
INSERT INTO Users (account_type, name, username, email, password, dato) values(admin, 'admin2', 'admin2', '@admin2@', 'admin2', NOW());
INSERT INTO Users (account_type, name, username, email, password, dato) values(admin, 'admin3', 'admin3', '@admin3@', 'admin3', NOW());
INSERT INTO Users (account_type, name, username, email, password, dato) values(producent, 'prod1', 'prod1', '@prod1@', 'prod1', NOW());
INSERT INTO Users (account_type, name, username, email, password, dato) values(producent, 'prod2', 'prod2', '@prod2@', 'prod2', NOW());
INSERT INTO Users (account_type, name, username, email, password, dato) values(producent, 'prod3', 'prod3', '@prod3@', 'prod3', NOW());
INSERT INTO Users (account_type, name, username, email, password, dato) values(bruger, 'user1', 'user1', '@user1@', 'user1', NOW());
INSERT INTO Users (account_type, name, username, email, password, dato) values(bruger, 'user2', 'user2', '@user2@', 'user2', NOW());
INSERT INTO Users (account_type, name, username, email, password, dato) values(bruger, 'user3', 'user3', '@user3@', 'user3', NOW());

--INSERTING prod_selskab

INSERT INTO prod_selskab (prod_selskab) values('prod_selskab1');
INSERT INTO prod_selskab (prod_selskab) values('prod_selskab2');
INSERT INTO prod_selskab (prod_selskab) values('prod_selskab3');
INSERT INTO prod_selskab (prod_selskab) values('prod_selskab4');
INSERT INTO prod_selskab (prod_selskab) values('prod_selskab5');

--INSERTING producers

	INSERT INTO producers (userID) values(2);
	INSERT INTO producers (userID) values(3);
	INSERT INTO producers (userID) values(4);

--INSERTING TV_program

INSERT INTO TV_program (name, dato, producerIDID) values('programname', NOW(), 4);
INSERT INTO TV_program (name, dato, producerIDID) values('programname', NOW(), 2);
INSERT INTO TV_program (name, dato, producerIDID) values('programname', NOW(), 3);


--INSERTING Program_kategori

INSERT INTO Program_kategori (kategori) values('Gyser');
INSERT INTO Program_kategori (kategori) values('Drama');
INSERT INTO Program_kategori (kategori) values('Komedie');
INSERT INTO Program_kategori (kategori) values('Thriller');



--INSERTING medvirkende


INSERT INTO medvirkende (name, email) values('Simon','Simon@outlook.com');
INSERT INTO medvirkende (name, email) values('Jens','Jens@outlook.com');
INSERT INTO medvirkende (name, email) values('Rasmus','Rasmus@outlook.com');
INSERT INTO medvirkende (name, email) values('Anders','Anders@outlook.com');
INSERT INTO medvirkende (name, email) values('Christoffer','Christoffer@outlook.com');


--INSERTING Tv_rolle


INSERT INTO Tv_rolle (rolle) values('Billedekunstner');
INSERT INTO Tv_rolle (rolle) values('Billede og lydredigering');
INSERT INTO Tv_rolle (rolle) values('Casting');
INSERT INTO Tv_rolle (rolle) values('Color');
INSERT INTO Tv_rolle (rolle) values('Dirigenter');
INSERT INTO Tv_rolle (rolle) values('Drone');
INSERT INTO Tv_rolle (rolle) values('Dukkefører');
INSERT INTO Tv_rolle (rolle) values('Dukkeskaber');
INSERT INTO Tv_rolle (rolle) values('fortæller');
INSERT INTO Tv_rolle (rolle) values('Fotografer');
INSERT INTO Tv_rolle (rolle) values('Forlæg');
INSERT INTO Tv_rolle (rolle) values('Grafiskdesigner');
INSERT INTO Tv_rolle (rolle) values('indtalere');
INSERT INTO Tv_rolle (rolle) values('kapelmester');
INSERT INTO Tv_rolle (rolle) values('klipper');
INSERT INTO Tv_rolle (rolle) values('Koncept/Programkoncept');
INSERT INTO Tv_rolle (rolle) values('konsulent');
