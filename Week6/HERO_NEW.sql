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

create table Super_Organization (
orgId INT PRIMARY KEY AUTO_INCREMENT,
orgName VARCHAR(50) NOT NULL, 
orgDescription VARCHAR(100) NOT NULL,
orgContactInfo VARCHAR(100) NOT NULL,
superPersonId INT NOT NULL,
    FOREIGN KEY (superPersonId) REFERENCES SuperPerson(superPersonId) 
);

create table Location (
locationId INT PRIMARY KEY AUTO_INCREMENT,
locationName VARCHAR(50) NOT NULL, 
locationDesc VARCHAR(100) NOT NULL,
locationAddress VARCHAR(100) NOT NULL,
locationLatitude VARCHAR(30),
locationLongitude VARCHAR(30)
);

create table SuperPerson_Sighting (
    superPersonId INT NOT NULL,
    locationId INT NOT NULL,
    PRIMARY KEY (superPersonId, locationId),
    sightDate Date NOT NULL
);