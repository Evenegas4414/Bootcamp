-- Para crear una nueva bases de datos en ORACLE usamos 
-- CREATE DATABASE desafioconsultorio ...
-- O usamos el "Asistente de configuracion de Bases de Datos" incluido en Oracle.

-- Creamos un nuevo usuario (esquema) y una nueva conexión
-- CREATE USER ##desafioconsultorio IDENTIFIED BY consultorio;
-- GRANT ALL PRIVILEGES TO ##desafioconsultorio;
-- DISCONNECT;
-- CONNECT ##desafioconsultorio/consultorio;

/*
DROP TABLE LICENCIA;
DROP TABLE CONSULTA;
DROP TABLE PACIENTE;
DROP TABLE MEDICO;
DROP TABLE ESPECIALIDAD;
*/


CREATE TABLE ESPECIALIDAD (
id NUMBER(10) NOT NULL,
codigo VARCHAR(10) NOT NULL UNIQUE,
descripcion VARCHAR2(200) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE MEDICO (
id NUMBER(10) NOT NULL,
rut VARCHAR2(15) NOT NULL UNIQUE,
nombre VARCHAR2(50) NOT NULL,
especialidad_id NUMBER(10) NOT NULL,
direccion VARCHAR2(100) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (especialidad_id) REFERENCES especialidad(id) 
);

CREATE TABLE PACIENTE (
id NUMBER(10) NOT NULL,
nombre VARCHAR2(50)NOT NULL,
rut VARCHAR2(15) NOT NULL UNIQUE,
direccion VARCHAR2(100) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE CONSULTA (
id NUMBER(10) NOT NULL,
fecha DATE NOT NULL,
hora_atencion TIMESTAMP NOT NULL,
medico_id NUMBER(10) NOT NULL,
paciente_id NUMBER(10) NOT NULL,
numero_box NUMBER(10) CHECK (numero_box > 0) NOT NULL ,
PRIMARY KEY (id),
FOREIGN KEY (medico_id) REFERENCES medico(id),
FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE LICENCIA (
id NUMBER(10) NOT NULL,
medico_id NUMBER(10) NOT NULL,
paciente_id NUMBER(10) NOT NULL,
diagnostico VARCHAR2(500) NOT NULL,
fecha_inicio DATE NOT NULL,
fecha_termino DATE NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (medico_id) REFERENCES medico(id),
FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

/*
Requerimientos
L? Un médico tiene una especialidad.
L? El médico tiene un nombre, RUT y dirección.
L? La especialidad tiene un código y una descripción.
? El médico realiza consultas a distintos pacientes.
? Un paciente agenda una o muchas consultas.
L? La consulta tiene fecha, hora de atención y número de box (consultorio).
L? El paciente tiene un nombre, rut y dirección.
? Un médico puede o no entregar una licencia a un paciente.
L? La licencia tiene un código, un diagnóstico, una fecha de inicio y una fecha de
término.
*/