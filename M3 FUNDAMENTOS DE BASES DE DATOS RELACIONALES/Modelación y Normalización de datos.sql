-- Para crear una nueva bases de datos en ORACLE usamos 
-- CREATE DATABASE normalizaciondb ...
-- O usamos el "Asistente de configuracion de Bases de Datos" incluido en Oracle.

-- Creamos un nuevo usuario (esquema) y una nueva conexión
-- CREATE USER c##normalizaciondb IDENTIFIED BY nordb;
-- GRANT ALL PRIVILEGES TO c##normalizaciondb;
-- DISCONNECT;
-- CONNECT c##normalizaciondb/nordb;

/*
DROP TABLE DIRECCION_PELICULA;
DROP TABLE OPERACIONES;
DROP TABLE CLIENTE;
DROP TABLE PELICULA;

DROP SEQUENCE DIRECCION_PELICULA_SEQ;
DROP SEQUENCE OPERACIONES_SEQ;
DROP SEQUENCE CLIENTE_SEQ;
*/



--1. Identificar las entidades.

--  Las entidades reconocidas son pelicula, cliente, datos de operaciones.

/*

CREATE TABLE VIDEOCLUB (
codigo_pelicula NUMBER NOT NULL,
titulo VARCHAR2(100) NOT NULL,
director VARCHAR2(100) NOT NULL,
anio NUMBER NOT NULL,
cliente VARCHAR2(100),
fecha DATE
);

*/



--2. Pasar a 1FN.

/*

CREATE TABLE PELICULA (
codigo_pelicula NUMBER NOT NULL,
titulo VARCHAR2(100) NOT NULL,
director VARCHAR2(100) NOT NULL,
anio NUMBER NOT NULL
);

CREATE TABLE CLIENTE (
id NUMBER NOT NULL,
cliente VARCHAR2(100),
fecha DATE,
);

*/



--3. Pasar a 2FN.

/*
CREATE TABLE PELICULA (
codigo_pelicula NUMBER NOT NULL,
titulo VARCHAR2(100) NOT NULL,
id_director NUMBER NOT NULL,
anio NUMBER NOT NULL,
PRIMARY KEY (codigo_pelicula)
);

CREATE TABLE DIRECCION_PELICULA (
id NUMBER NOT NULL,
id_pelicula NUMBER NOT NULL,
director_1 VARCHAR2(100) NOT NULL,
director_2 VARCHAR2(100),
director_3 VARCHAR2(100),
PRIMARY KEY (id),
FOREIGN KEY (id_pelicula) REFERENCES pelicula(codigo_pelicula)
);

CREATE TABLE CLIENTE (
id NUMBER NOT NULL,
cliente VARCHAR2(100),
fecha DATE,
PRIMARY KEY (id)
);

*/
--4. Pasar a 3FN.

CREATE SEQUENCE DIRECCION_PELICULA_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE CLIENTE_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE OPERACIONES_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE PELICULA (
codigo_pelicula NUMBER NOT NULL,
titulo VARCHAR2(100) NOT NULL,
id_director NUMBER NOT NULL,
anio NUMBER NOT NULL,
PRIMARY KEY (codigo_pelicula)
);

CREATE TABLE DIRECCION_PELICULA (
id NUMBER NOT NULL,
id_pelicula NUMBER NOT NULL,
director_1 VARCHAR2(100) NOT NULL,
director_2 VARCHAR2(100),
director_3 VARCHAR2(100),
PRIMARY KEY (id),
FOREIGN KEY (id_pelicula) REFERENCES pelicula(codigo_pelicula)
);

CREATE TABLE CLIENTE (
id NUMBER NOT NULL,
primer_apellido VARCHAR2(100) NOT NULL,
segundo_apellido VARCHAR2(100),
nombre VARCHAR2(100) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE OPERACIONES (
id NUMBER NOT NULL,
id_cliente NUMBER NOT NULL,
id_pelicula NUMBER NOT NULL,
fecha_devolucion DATE,
PRIMARY KEY (id),
FOREIGN KEY (id_cliente) REFERENCES cliente(id),
FOREIGN KEY (id_pelicula) REFERENCES pelicula(codigo_pelicula)
);