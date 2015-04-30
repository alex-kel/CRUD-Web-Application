CREATE TABLE Users (
  UserId    INT PRIMARY KEY,
  UserName  VARCHAR(20) UNIQUE NOT NULL,
  Password  VARCHAR(20),
  FirstName VARCHAR(20),
  LastName  VARCHAR(20)
);

CREATE TABLE Role (
  RoleId   INT PRIMARY KEY,
  RoleName VARCHAR(20) NOT NULL
);

CREATE TABLE UserRole (
  UserId INT,
  RoleId INT,
  PRIMARY KEY (UserId, RoleId)
);

INSERT INTO users VALUES (10, 'JBOND', '1', 'James', 'Bond');
INSERT INTO users VALUES (20, 'JSMIT', '1', 'John', 'Smitt');
INSERT INTO users VALUES (30, 'IKOZH', '1', 'Ivan', 'Kozhemyaka');

INSERT INTO Role VALUES (10, 'User');
INSERT INTO Role VALUES (20, 'Advanced');

INSERT INTO UserRole VALUES (10, 10);
INSERT INTO UserRole VALUES (10, 20);
INSERT INTO UserRole VALUES (20, 10);
INSERT INTO UserRole VALUES (30, 20);

