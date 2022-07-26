DROP SEQUENCE seq_producto;
DROP TABLE producto;

CREATE TABLE producto
(
id_producto NUMBER(18) PRIMARY KEY,
codigo VARCHAR2(20),
nombre VARCHAR2(200),
precio NUMBER(20),
stock NUMBER(20)
);

CREATE SEQUENCE seq_producto MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;

INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'ABC101', 'Ejemplo A1', 111000, 111);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'DEF201', 'Examplo D1', 212000, 211);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'KLM0301', 'Ejemplo K1', 313000, 311);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'OPQ401', 'Ejemplo O1', 414000, 411);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'XYZ501', 'Ejemplo X1', 515000, 511);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'ABC111', 'Ejemplo A2', 111000, 111);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'DEF211', 'Examplo D2', 212000, 211);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'KLM0311', 'Ejemplo K2', 313000, 311);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'OPQ411', 'Ejemplo O2', 414000, 411);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'XYZ511', 'Ejemplo X2', 515000, 511);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'ABC121', 'Ejemplo A3', 111000, 111);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'DEF221', 'Examplo D3', 212000, 211);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'KLM0321', 'Ejemplo K3', 313000, 311);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'OPQ421', 'Ejemplo O3', 414000, 411);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'XYZ521', 'Ejemplo X3', 515000, 511);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'ABC131', 'Ejemplo A4', 111000, 111);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'DEF231', 'Examplo D4', 212000, 211);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'KLM0331', 'Ejemplo K4', 313000, 311);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'OPQ431', 'Ejemplo O4', 414000, 411);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'XYZ541', 'Ejemplo X4', 515000, 511);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'ABC141', 'Ejemplo A5', 111000, 111);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'DEF241', 'Examplo D5', 212000, 211);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'KLM0341', 'Ejemplo K5', 313000, 311);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'OPQ441', 'Ejemplo O5', 414000, 411);
INSERT INTO producto VALUES (seq_producto.NEXTVAL, 'XYZ541', 'Ejemplo X5', 515000, 511);



SELECT * FROM producto;