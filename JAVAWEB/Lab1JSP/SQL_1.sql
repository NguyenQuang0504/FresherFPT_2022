CREATE DATABASE Lab1JSP;
DROP DATABASE Lab1JSP;
CREATE TABLE [dbo].[User](
    userId INT PRIMARY KEY IDENTITY,
    firstName NVARCHAR(50) NOT NULL,
    lastName NVARCHAR(50) NOT NULL,
    email NVARCHAR(30) NOT NULL,
    userName NVARCHAR(50) NOT NULL,
    password NVARCHAR(50) NOT NULL
);

CREATE TABLE UserRole(
    userRoleId INT PRIMARY KEY ,
    authority NVARCHAR(45),
    userId INT NOT NULL,
    FOREIGN KEY(userId) REFERENCES [dbo].[User](userId)
)
INSERT INTO [User] VALUES(N'', N'Quang', N'quang@gmail.com', N'Quang0504', N'0397111634')
INSERT INTO UserRole VALUES(1, N'Authority1', 1)

CREATE PROC [dbo].[usp_registerUser]
@firstName NVARCHAR(50),
@lastName NVARCHAR(50),
@email NVARCHAR(100),
@userName NVARCHAR(50),
@password NVARCHAR(50)
AS
BEGIN
	INSERT INTO [User] VALUES (@firstName, @lastName, @email, @userName, @password)
END
