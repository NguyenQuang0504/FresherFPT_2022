SELECT TOP (1000) [customerId]
      ,[customerName]
      ,[customerBirthDay]
      ,[customerEmail]
  FROM [Customer].[dbo].[Customer]
  DELETE FROM Customer WHERE customerId = 4;