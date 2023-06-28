CREATE TABLE `persons` (
  `PersonId` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) not NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  PRIMARY KEY (`PersonId`)
);

insert into persons (FirstName,LastName,Age) values ("Mihkel","Tiganik",33);
insert into persons (FirstName,LastName,Age) values ("Anny","Suurmänd",19);
insert into persons (FirstName,LastName,Age) values ("Doby","Laiõlg",22);
insert into persons (FirstName,LastName,Age) values ("Manni","Mihklipoeg",13);

CREATE TABLE `posts` (
    `PostId` int NOT NULL AUTO_INCREMENT,
    `PersonId` int NOT NULL,
    `Post` varchar(255) NOT NULL,
    `ts` TIMESTAMP null default CURRENT_TIMESTAMP,
    PRIMARY KEY (PostId),
    FOREIGN Key (PersonId) REFERENCES persons(PersonId)
);

insert into posts (Post, PersonId) values ("Tere kõigile, kas saame homme kokku",1);
insert into posts (Post, PersonId) values ("Võime küll jaa, aga mida me teeme",2);
insert into posts (Post, PersonId) values ("Lähme kohvikusse, aga mis kell",3);
insert into posts (Post, PersonId) values ("Mulle sobib pealelõunal",1);
insert into posts (Post, PersonId) values ("Pealelõunat hea aeg. Lähme jaa",4);