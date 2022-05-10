drop database if exists Hero;

create database Hero;

use Hero;

create table Superhero (
superHeroId INT PRIMARY KEY AUTO_INCREMENT,
heroName VARCHAR(50) NOT NULL, 
heroDescription VARCHAR(100) NOT NULL, 
heroSuperPower VARCHAR(50) NOT NULL
);

create table Villain (
villainId INT PRIMARY KEY AUTO_INCREMENT,
villainName VARCHAR(50) NOT NULL, 
villainDescription VARCHAR(100) NOT NULL, 
villainSuperPower VARCHAR(50) NOT NULL
);

create table Hero_Organization (
heroOrgId INT PRIMARY KEY AUTO_INCREMENT,
heroOrgName VARCHAR(50) NOT NULL, 
heroOrgDescription VARCHAR(100) NOT NULL,
heroOrgContactInfo VARCHAR(100) NOT NULL,
superHeroId INT NOT NULL,
    FOREIGN KEY (superHeroId) REFERENCES Superhero(superHeroId) 
);

create table Villains_Organization (
villainOrgId INT PRIMARY KEY AUTO_INCREMENT,
villainOrgName VARCHAR(50) NOT NULL, 
villainOrgDescription VARCHAR(100) NOT NULL,
villainOrgContactInfo VARCHAR(100) NOT NULL,
villainId INT NOT NULL,
    FOREIGN KEY (villainId) REFERENCES Villain(villainId)  
);

create table Locations (
locationId INT PRIMARY KEY AUTO_INCREMENT,
locationName VARCHAR(50) NOT NULL, 
locationDescription VARCHAR(100) NOT NULL,
locationAddress VARCHAR(100) NOT NULL,
locationLatitude VARCHAR(30),
locationLongitude VARCHAR(30)
);

create table Hero_Sighting (
    superHeroId INT NOT NULL,
    locationId INT NOT NULL,
    PRIMARY KEY (superHeroId, locationId),
    sightDate Date NOT NULL
);

create table Villain_Sighting (
    villainId INT NOT NULL,
    locationId INT NOT NULL,
    PRIMARY KEY (villainId, locationId),
    sightDate Date NOT NULL
);

















