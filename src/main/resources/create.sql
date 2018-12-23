
-- create database for the timeWastingService
CREATE DATABASE async_db;

-- create user for the timeWastingService
CREATE USER async_service WITH PASSWORD 'async_password';

-- create audit trail table
CREATE TABLE async_audit_trail (
   id VARCHAR(64) NOT NULL,
   firstname VARCHAR(12) NOT NULL,
   surname VARCHAR(12) NOT NULL
);

-- grant permissions on the db
GRANT ALL PRIVILEGES ON TABLE "async_audit_trail" to async_service;

-- insert data
INSERT INTO async_audit_trail (id, firstname, surname) VALUES ('cfdfaa7e-ea7e-3eb4-89bd-a63fb33441b1', 'XMMOWKGNKBUG', 'XMMOWKGNKBUG');