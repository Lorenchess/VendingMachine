drop database if exists Hero;

create database Hero;

use Hero;

create table SuperPerson (
superPersonId INT PRIMARY KEY AUTO_INCREMENT,
superPersonName VARCHAR(50) NOT NULL,
isHero Boolean default true, 
superPersonDesc VARCHAR(100) NOT NULL, 
superPower VARCHAR(50) NOT NULL
);

create table Organization (
orgId INT PRIMARY KEY AUTO_INCREMENT,
orgName VARCHAR(50) NOT NULL, 
orgDescription VARCHAR(100) NOT NULL,
orgContactInfo VARCHAR(100) NOT NULL
);

create table Super_Organization(
superPersonId INT NOT NULL,
orgId INT NOT NULL,
PRIMARY KEY (superPersonId, orgId),
FOREIGN KEY (superPersonId) REFERENCES SuperPerson(superPersonId),
FOREIGN KEY (orgId) REFERENCES Organization(orgId)
);

create table Location (
locationId INT PRIMARY KEY AUTO_INCREMENT,
locationName VARCHAR(50) NOT NULL, 
locationDesc VARCHAR(100) NOT NULL,
locationAddress VARCHAR(100) NOT NULL,
locationLatitude VARCHAR(30),
locationLongitude VARCHAR(30)
);


create table Sigthing (
  id INT PRIMARY KEY AUTO_INCREMENT,
  sightDate Date NOT NULL,
  locationId INT NOT NULL,
    FOREIGN KEY (locationId) REFERENCES Location(locationId) 
);
create table SuperPerson_Sighting (
    superPersonId INT NOT NULL,
    sigthingId INT NOT NULL,
    PRIMARY KEY (superPersonId, sigthingId),
    FOREIGN KEY (superPersonId) REFERENCES SuperPerson(superPersonId),
    FOREIGN KEY (sigthingId) REFERENCES Sigthing(id)
);

















