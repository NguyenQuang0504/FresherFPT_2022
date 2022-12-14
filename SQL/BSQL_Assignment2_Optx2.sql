-- BSQL- Assignment2_Opt2

-- EMPLOYEE:
-- EmpNo: employee code, primary key.
-- EmpName: employee name.
-- BirthDay: birth day of the employee.
-- DeptNo: department code of the employee.
-- MgrNo: manager code, not null.
-- StartDate: starting date of work.
-- Salary: salary of the employee, data type is money (VND).
-- Level: level of the employee (accepts value range from 1 to 7 only).
-- Status: status of the employee (0: working, 1: unpaid leave, 2: out)
-- Note:  some note about employee, free text.

-- EMP_SKILL:
-- SkillNo: skill code, foreign key.
-- EmpNo: employee code, foreign key.
-- SkillLevel: skill level of the employee (accepts value range from 1 to 3 only).
-- RegDate: registration date.
-- Description: skill description, free text.
-- 	Primary key (SkillNo, EmpNo)

-- SKILL:
-- SkillNo: skill code, primary key, auto increment.
-- SkillName: name of skill.
-- Note: some note about skill, free text.

-- DEPARTMENT:
-- DeptNo: department code, primary key, auto increment.
-- DeptName: department name.
-- Note: some note about department, free text.

CREATE DATABASE Assignment2_Opt2
GO

DROP DATABASE Assignment2_Opt2

-- Create Employee
CREATE TABLE Employee (
    EmpNo VARCHAR(20) NOT NULL PRIMARY KEY,
    EmpName NVARCHAR(25) NOT NULL,
    BirthDay Date NOT NULL,
    DeptNo SMALLINT NOT NULL,
    MgrNo SMALLINT NOT NULL,
    StartDate DATE NOT NULL,
    Salary MONEY NOT NULL,
    Level SMALLINT NOT NULL CHECK(Level <=7 and Level >=1),
    Status SMALLINT NOT NULL CHECK(Status = 0 OR Status = 1 OR Status = 2),
    Note NTEXT
)
GO

-- Create EMP_SKILL
CREATE TABLE Emp_Skill
(
    SkillNo SMALLINT NOT NULL FOREIGN KEY REFERENCES Skill(SkillNo),
    EmpNo VARCHAR(20) NOT NULL FOREIGN KEY REFERENCES Employee(EmpNo),
    SkillLevel SMALLINT CHECK( SkillLevel >=1 AND SkillLevel <=3),
    RegDate Date NOT NULL,
    Description NTEXT
    CONSTRAINT PK_EmpSkill PRIMARY KEY(SkillNo, EmpNo)
)
GO

-- Create SKILL
CREATE TABLE Skill
(
    SkillNo SMALLINT NOT NULL PRIMARY KEY IDENTITY,
    SkillName NVARCHAR(50) NOT NULL,
    Note NTEXT
)
GO

-- Create Department
CREATE TABLE Department
(
    DeptNo SMALLINT NOT NULL PRIMARY KEY IDENTITY,
    DeptName NVARCHAR(50) NOT NULL,
    Note NTEXT
)

-- Q2
-- Th??m c???t email r??ng bu???c kh??ng cho ph??p tr??ng l???p
ALTER TABLE Employee ADD Email VARCHAR(30) UNIQUE NOT NULL
-- Th??m r??ng bu???c Default = 0 cho c???t MgrNo
ALTER TABLE Employee ADD CONSTRAINT MgrNoDefault DEFAULT(0) FOR MgrNo;
GO

-- Q3
ALTER TABLE Employee ADD FOREIGN KEY(DeptNo) REFERENCES Department(DeptNo)
GO

--Q4
INSERT Employee(EmpNo, EmpName, BirthDay, DeptNo, StartDate, Salary, [Level], [Status], Note, Email) VALUES
('NV001', N'Nguy???n V??n Quang', '20010504', 1,'20220504', 900.5, 1, 0,'T???t', 'quang11a3@gmail.com'),
('NV002', N'Nguy???n V??n H??ng', '20020504', 2,'20220504', 700.5, 4, 0,'T???t', 'quang12a3@gmail.com'),
('NV003', N'Nguy???n V??n Nam', '20020304', 3,'20220504', 40.5, 5, 2,'T???t', 'quang13a3@gmail.com'),
('NV004', N'Nguy???n V??n Minh', '20090504', 4,'20220504', 300.5, 3, 1,'T???t', 'quang14a3@gmail.com'),
('NV005', N'Nguy???n V??n Ho??ng', '20000504', 5,'20220504', 400.5, 2, 1, null, 'quang15a3@gmail.com')
GO

INSERT Department(DeptName, Note) VALUES 
(N'H??nh ch??nh', 'Thi???u tr?????ng ph??ng'),
(N'Gi??o v???', 'Thi???u tr?????ng ph??ng'),
(N'Nh??n s???', 'Thi???u tr?????ng ph??ng'),
(N'K??? to??n', 'Thi???u tr?????ng ph??ng'),
(N'D???ch v???', 'Thi???u tr?????ng ph??ng')
GO

INSERT Skill(SkillName, Note) VALUES
(N'Java', 'T???t'),
(N'PHP', 'T???t'),
(N'SQL', 'T???t'),
(N'HTML', 'T???t'),
(N'Agular', 'T???t')
GO

INSERT Emp_Skill(EmpNo, SkillNo, SkillLevel, RegDate, [Description]) VALUES
('NV001', 2, 2, '20221010', N'Kh??ng'),
('NV002', 4, 3, '20221010', N'Kh??ng'),
('NV003', 1, 1, '20221010', N'Kh??ng'),
('NV004', 3, 2, '20221010', N'Kh??ng'),
('NV005', 5, 1, '20221010', N'Kh??ng')

CREATE VIEW Employee_Tracking AS
SELECT EmpNo, EmpName, Level FROM Employee WHERE [Level] BETWEEN 3 AND 5

SELECT * FROM Employee_Tracking