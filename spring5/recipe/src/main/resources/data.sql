-- #####################################
--  Initial DB data-set for Spring JDBC
-- #####################################
-- ** This is a SPRING feature **
-- This script will only be executed if the 'DDL-AUTO' property is set to 'create' or 'create-drop'
--

-- !! You must NOT use Hibernate 'import.sql' with Spring JDBC generators 'data.sql' or 'schema*.sql'. It is either HIBERNATE or SPRING, not both !!

-- Script properties
-- Author: Guillaume Diaz
-- Version: 1.0 -2018-04-06
--

INSERT INTO category (name) VALUES ('American');
INSERT INTO category (name) VALUES ('Italian');
INSERT INTO category (name) VALUES ('Mexican');
INSERT INTO category (name) VALUES ('French');
INSERT INTO category (name) VALUES ('Chinese');

INSERT INTO unit_measure (unit) VALUES ('Teaspoon');
INSERT INTO unit_measure (unit) VALUES ('Tablespoon');
INSERT INTO unit_measure (unit) VALUES ('Cup');
INSERT INTO unit_measure (unit) VALUES ('Pinch');
INSERT INTO unit_measure (unit) VALUES ('Ounce');
INSERT INTO unit_measure (unit) VALUES ('Liter');
INSERT INTO unit_measure (unit) VALUES ('Gram');
