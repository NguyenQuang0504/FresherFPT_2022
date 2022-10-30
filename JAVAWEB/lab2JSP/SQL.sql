CREATE DATABASE Lab2JSP 
GO
CREATE TABLE Employee(
    employeeId INT PRIMARY KEY IDENTITY,
    employeeName NVARCHAR(50),
    employeeGender BIT,
    employeeDateOfBirth DATE,
    departmentId INT NOT NULL,
    FOREIGN KEY(departmentId) REFERENCES Department(departmentId)
);

CREATE TABLE [dbo].[Department](
    departmentId INT PRIMARY KEY IDENTITY,
    departmentName NVARCHAR(50)
);

CREATE TABLE [dbo].[User](
    userId INT PRIMARY KEY IDENTITY,
    firstName NVARCHAR(50),
    lastName NVARCHAR(50),
    email NVARCHAR(50),
    userName NVARCHAR(50),
    password NVARCHAR(50)
);

CREATE PROC [dbo].[usp_registerUser]
@firstName NVARCHAR(50),
@lastName NVARCHAR(50),
@email NVARCHAR(100),
@userName NVARCHAR(50),
@password NVARCHAR(50)
AS
BEGIN
	INSERT INTO [dbo].[User] VALUES (@firstName, @lastName, @email, @userName, @password)
END

CREATE PROC [dbo].[usp_login]
@userName VARCHAR(50),
@password VARCHAR(50),
@numberRecord INT OUTPUT
AS
BEGIN
	SELECT @numberRecord = COUNT(*) FROM [User] WHERE userName = @userName AND password = @password
END
GO

INSERT INTO Department VALUES(N'GAM'),
(N'FA')