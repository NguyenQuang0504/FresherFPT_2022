CREATE DATABASE EMS
-- Create table Employee, Status = 1: are working
CREATE TABLE [dbo].[Employee](
	[EmpNo] [int] NOT NULL
,	[EmpName] [nchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[BirthDay] [datetime] NOT NULL
,	[DeptNo] [int] NOT NULL
, 	[MgrNo] [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[StartDate] [datetime] NOT NULL
,	[Salary] [money] NOT NULL
,	[Status] [int] NOT NULL
,	[Note] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
,	[Level] [int] NOT NULL
) ON [PRIMARY]

GO

ALTER TABLE Employee 
ADD CONSTRAINT PK_Emp PRIMARY KEY (EmpNo)
GO

ALTER TABLE [dbo].[Employee]  
ADD  CONSTRAINT [chk_Level] 
	CHECK  (([Level]=(7) OR [Level]=(6) OR [Level]=(5) OR [Level]=(4) OR [Level]=(3) OR [Level]=(2) OR [Level]=(1)))
GO
ALTER TABLE [dbo].[Employee]  
ADD  CONSTRAINT [chk_Status] 
	CHECK  (([Status]=(2) OR [Status]=(1) OR [Status]=(0)))

GO
ALTER TABLE [dbo].[Employee]
ADD Email NCHAR(30) 
GO

ALTER TABLE [dbo].[Employee]
ADD CONSTRAINT chk_Email CHECK (Email IS NOT NULL)
GO

ALTER TABLE [dbo].[Employee] 
ADD CONSTRAINT chk_Email1 UNIQUE(Email)

GO
ALTER TABLE Employee
ADD CONSTRAINT DF_EmpNo DEFAULT 0 FOR EmpNo

GO
ALTER TABLE Employee
ADD CONSTRAINT DF_Status DEFAULT 0 FOR Status

GO
CREATE TABLE [dbo].[Skill](
	[SkillNo] [int] IDENTITY(1,1) NOT NULL
,	[SkillName] [nchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[Note] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]

GO
ALTER TABLE Skill
ADD CONSTRAINT PK_Skill PRIMARY KEY (SkillNo)

GO
CREATE TABLE [dbo].[Department](
	[DeptNo] [int] IDENTITY(1,1) NOT NULL
,	[DeptName] [nchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[Note] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]

GO
ALTER TABLE Department
ADD CONSTRAINT PK_Dept PRIMARY KEY (DeptNo)

GO
CREATE TABLE [dbo].[Emp_Skill](
	[SkillNo] [int] NOT NULL
,	[EmpNo] [int] NOT NULL
,	[SkillLevel] [int] NOT NULL
,	[RegDate] [datetime] NOT NULL
,	[Description] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]

GO
ALTER TABLE Emp_Skill
ADD CONSTRAINT PK_Emp_Skill PRIMARY KEY (SkillNo, EmpNo)
GO

ALTER TABLE Employee  
ADD  CONSTRAINT [FK_1] FOREIGN KEY([DeptNo])
REFERENCES Department (DeptNo)

GO
ALTER TABLE Emp_Skill
ADD CONSTRAINT [FK_2] FOREIGN KEY ([EmpNo])
REFERENCES Employee([EmpNo])

GO
ALTER TABLE Emp_Skill
ADD CONSTRAINT [FK_3] FOREIGN KEY ([SkillNo])
REFERENCES Skill([SkillNo])

GO

--Question 1 Add 8 record
INSERT Department(DeptName, Note) VALUES
(N'Nh??n s???', null),
(N'H??nh ch??nh', null),
(N'K??? to??n', null),
(N'T??i ch??nh', null),
(N'ANDROI', null),
(N'BIGDATA', null),
(N'CLOUND', null),
(N'IoT', null)

INSERT Skill(SkillName, Note) VALUES
(N'C++', null),
(N'C', null),
(N'C#', null),
(N'Java', null),
(N'.Net', null),
(N'PHP', null),
(N'Python', null),
(N'Ruby', null)

INSERT Employee(EmpNo, EmpName, BirthDay, DeptNo, StartDate, Salary, [Level], [Status], Note, Email, MgrNo) VALUES
(1, N'Nguy???n V??n Quang', '20010504', 1,'20220504', 900.5, 1, 0,N'T???t', 'quang11a3@gmail.com',N'NV01'),
(2, N'Nguy???n Minh H??ng', '20020504', 2,'20220504', 700.5, 4, 0,N'T???t', 'quang12a3@gmail.com',N'NV02'),
(3, N'Phan V??n Kh??nh', '20020309', 3,'20110406', 40.5, 5, 2, N'T???t', 'quang13a3@gmail.com',N'NV03'),
(4, N'Nguy???n V??n Minh', '20090507', 4,'20220309', 300.5, 3, 1, N'T???t', 'quang14a3@gmail.com',N'NV04'),
(5, N'D????ng Th??? Th??y', '20000204', 5,'20220708', 400.5, 2, 1, null, 'quang15a3@gmail.com',N'NV05'),
(6, N'Cao Ti???n Lu???t', '20011004', 1,'20220604', 900.5, 1, 0, N'T???t', 'quang16a3@gmail.com',N'NV06'),
(7, N'L????ng Duy Th???ch', '20020504', 2,'20200504', 700.5, 4, 0, N'T???t', 'quang17a3@gmail.com',N'NV07'),
(8, N'Ph???m Ng???c', '20020309', 3,'20191010', 40.5, 5, 2, N'T???t', 'quang18a3@gmail.com',N'NV08'),
(9, N'Ti???u My', '20090507', 4,'20210304', 300.5, 3, 1, N'T???t', 'quang19a3@gmail.com',N'NV09')
GO

INSERT Emp_Skill(SkillNo, EmpNo, SkillLevel, RegDate, [Description]) VALUES
(1, 2, 5, '20221003', null),
(1, 3, 2, '20210103', null),
(2, 1, 5, '20190203', null),
(3, 1, 5, '20011003', null),
(4, 4, 5, '20190528', null),
(5, 5, 5, '20221101', null),
(2, 6, 5, '20210303', null),
(7, 7, 5, '20211003', null),
(1, 8, 5, '20021203', null),
(3, 8, 5, '20221012', null),
(8, 6, 5, '20211012', null),
(3, 3, 5, '20221003', null)
GO

-- Question 1 L???y t??n, email v?? b??? ph???n c???a nh??n vi??n l??m ??t nh???t 6 th??ng
SELECT Employee.EmpName, Employee.Email, Department.DeptName, Employee.StartDate FROM Employee INNER JOIN Department ON Employee.DeptNo = Department.DeptNo WHERE DATEDIFF(month, Employee.StartDate, GETDATE()) >= 6

-- Question 2 Select t??n nh??n vi??n c?? k??? n??ng C++ ho???c .Net
SELECT Employee.EmpName, SkillName FROM Employee INNER JOIN Emp_Skill ON Emp_Skill.EmpNo = Employee.EmpNo INNER JOIN Skill ON Emp_Skill.SkillNo = Skill.SkillNo WHERE SkillName = N'C++' OR SkillName = '.Net'

--Question 4 Ch??? ?????nh c??c ph??ng ban c??> = 2 nh??n vi??n, in ra danh s??ch nh??n vi??n c???a c??c ph??ng ban ngay sau m???i ph??ng ban.
SELECT Department.DeptName, Employee.EmpName FROM Employee INNER JOIN Department ON Employee.DeptNo = Department.DeptNo AND Department.DeptName IN (
SELECT Department.DeptName FROM Employee INNER JOIN Department ON Employee.DeptNo = Department.DeptNo GROUP BY DeptName HAVING  COUNT(EmpName) >=2
) ORDER BY DeptName

-- Question 5 Li???t k?? t???t c??? t??n, email v?? s??? k??? n??ng c???a nh??n vi??n v?? s???p x???p th??? t??? t??ng d???n theo t??n c???a nh??n vi??n.
SELECT Employee.EmpName, Employee.Email, COUNT(Emp_Skill.SkillNo) AS NumSkill FROM Employee INNER JOIN Emp_Skill ON Emp_Skill.EmpNo = Employee.EmpNo INNER JOIN Skill ON Skill.SkillNo =Emp_Skill.SkillNo GROUP BY Employee.Email, EmpName ORDER BY EmpName 
--c2
SELECT EmpName, COUNT(Emp_Skill.SkillNo) FROM Employee INNER JOIN Emp_Skill ON Emp_Skill.EmpNo = Employee.EmpNo GROUP BY Employee.EmpName

-- Question 6 T???o khung nh??n ????? li???t k?? t???t c??? nh??n vi??n ??ang l??m vi???c (bao g???m: t??n nh??n vi??n v?? t??n k??? n??ng, t??n b??? ph???n).
CREATE VIEW EmployeeWork AS
SELECT Employee.EmpName, Skill.SkillName, Department.DeptName FROM Employee INNER JOIN Emp_Skill ON Employee.EmpNo = Emp_Skill.EmpNo INNER JOIN Department ON Employee.DeptNo = Department.DeptNo INNER JOIN Skill ON Skill.SkillNo = Emp_Skill.SkillNo
