This is a stock portfolio application. It allows a user to view relevant data via the Yahoo Finance API. Stocks can be added or removed from a user created portfolio.


************ Data Base set up instructions **************************

- must use mySQL - 

Start mySQL  - Set the user name to appuser and the password to appuser. Use the defualt localhost port  :3030

Create a new schema and name it stockportfolio

create a new table and name it: portfolio  Name the first column portfolioId and make it the primary key, Not NULL, and Auto Increment. 
Make one more column and name it portfolioName set it to be Unique (UQ) 

Create a new table and name it stock set up the following columns idstock  -set it as Primary Key, Not Null, and Auto Increment. And stockSymbol and set it as unique (UQ)

Create teh last table and name it portfoliostockrelationship with a first column of relationshipId set as Primary Key, Not NUll, and auto increment.

then add four columns that coincide with the other tables. portfolioId portfolioName idstock stockSymbol 

the application will now recognize this database. 
