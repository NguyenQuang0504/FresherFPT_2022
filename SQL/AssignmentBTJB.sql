CREATE DATABASE AssignmentBTJB;
GO
CREATE TABLE Fresher(
    candidateId CHAR(5) NOT NULL PRIMARY KEY,
    fullName NVARCHAR(30) NOT NULL,
    birthDay DATE NOT NULL,
    email NVARCHAR(30) NOT NULL,
    candidateType int NOT NULL CHECK(candidateType = 1),
    graduationDate DATE NOT NULL,
    graduationRank NVARCHAR(30) NOT NULL,
    education NVARCHAR(50) NOT NULL,
    certificateds NVARCHAR (200)
);
GO
CREATE TABLE Intern(
    candidateId CHAR(5) NOT NULL PRIMARY KEY,
    fullName NVARCHAR(30) NOT NULL,
    birthDay DATE NOT NULL,
    email NVARCHAR(30) NOT NULL,
    candidateType int NOT NULL CHECK(candidateType = 2),
    majors NVARCHAR(30) NOT NULL,
    semester NVARCHAR(30) NOT NULL,
    universityName NVARCHAR(50) NOT NULL,
    certificateds NVARCHAR (200)
);
GO
CREATE TABLE Experience(
    candidateId CHAR(5) NOT NULL PRIMARY KEY,
    fullName NVARCHAR(30) NOT NULL,
    birthDay DATE NOT NULL,
    email NVARCHAR(30) NOT NULL,
    candidateType int NOT NULL CHECK(candidateType = 0),
    expInYear int NOT NULL,
    proSkill NVARCHAR(30) NOT NULL,
    certificateds NVARCHAR (200)
)
GO
CREATE TABLE Certificated(
    certificatedID NCHAR(10) PRIMARY KEY,
    certificatedName NVARCHAR(50) NOT NULL,
    certificatedRank NVARCHAR(30) NOT NULL,
    certificatedDate DATE NOT NULL
)
DROP TABLE Certificated;
-- INSERT Fresher(candidateId, fullName, birthDay, email, candidateType,graduationDate, graduationRank, education)
