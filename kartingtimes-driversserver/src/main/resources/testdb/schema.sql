DROP TABLE T_DRIVER IF EXISTS;

CREATE TABLE T_DRIVER (
  ID         BIGINT IDENTITY PRIMARY KEY,
  FIRST_NAME VARCHAR(30) NOT NULL,
  SURNAME    VARCHAR(30) NOT NULL
);

