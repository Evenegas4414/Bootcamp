DROP TABLE inscripcion;
DROP TABLE forma_pago;
DROP TABLE curso;
DROP SEQUENCE inscripcion_seq;

CREATE SEQUENCE inscripcion_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE TABLE curso (
id_curso VARCHAR2(50) PRIMARY KEY, 
descripcion VARCHAR2(100),
precio NUMBER(22));

CREATE TABLE forma_pago (
id_forma_pago VARCHAR2(50), 
descripcion VARCHAR2(100),
recargo VARCHAR2(100));

CREATE TABLE inscripcion(
id_inscripcion NUMBER(22) PRIMARY KEY,
nombre VARCHAR2(100),
telefono NUMBER(22), 
id_curso VARCHAR2(50),
id_forma_pago VARCHAR2(50),
FOREIGN KEY (id_curso) REFERENCES curso(id_curso));

INSERT INTO curso VALUES('1','Java Enterprice Edition', 800.000);
INSERT INTO curso VALUES('2','Java Standar Edition', 600.000);
INSERT INTO curso VALUES('3','JavaScript ECMA 6', 500.000);

INSERT INTO forma_pago VALUES ('1598','Tarjeta Credito','10%' );
INSERT INTO forma_pago VALUES ('1547','Tarjeta Debito','15%' );
INSERT INTO forma_pago VALUES ('3578','Efectivo','5%' );