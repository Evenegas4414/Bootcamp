-- Para crear una nueva bases de datos en ORACLE usamos 
-- CREATE DATABASE pruebadb ...
-- O usamos el "Asistente de configuracion de Bases de Datos" incluido en Oracle.

-- Creamos un nuevo usuario (esquema) y una nueva conexión
-- CREATE USER c##pruebadb IDENTIFIED BY prueba;
-- GRANT ALL PRIVILEGES TO ##pruebadb;
-- DISCONNECT;
-- CONNECT ##pruebadb/prueba;

/*
DROP TABLE COMPRAS;
DROP TABLE ORDENES;
DROP TABLE PRODUCTOS;
DROP TABLE EMPLEADOS;
DROP TABLE PROVEEDORES;
DROP TABLE CATEGORIAS;
DROP TABLE DESPACHADORES;
DROP TABLE CLIENTES;

DROP SEQUENCE COMPRAS_SEQ;
DROP SEQUENCE ORDENES_SEQ;
DROP SEQUENCE PRODUCTOS_SEQ;
DROP SEQUENCE EMPLEADOS_SEQ;
DROP SEQUENCE PROVEEDORES_SEQ;
DROP SEQUENCE CATEGORIAS_SEQ;
DROP SEQUENCE DESPACHADORES_SEQ;
DROP SEQUENCE CLIENTES_SEQ;
*/


CREATE SEQUENCE EMPLEADOS_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE CLIENTES_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE DESPACHADORES_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE CATEGORIAS_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE PROVEEDORES_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE PRODUCTOS_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE ORDENES_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE COMPRAS_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
CREATE TABLE EMPLEADOS (
id NUMBER NOT NULL,
nombre VARCHAR2(50) NOT NULL,
apellido VARCHAR2(50) NOT NULL,
fecha_nacimiento DATE NOT NULL,
direccion VARCHAR2(50) NOT NULL,
region VARCHAR2(50) NOT NULL,
ciudad VARCHAR2(50) NOT NULL,
pais VARCHAR2(50) NOT NULL,
telefono VARCHAR2(50) NOT NULL,
cargo VARCHAR2(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE CLIENTES (
id NUMBER NOT NULL,
nombre_empresa VARCHAR2(50) NOT NULL UNIQUE,
nombre_contacto VARCHAR2(50) NOT NULL,
email VARCHAR2(50) NOT NULL UNIQUE,
direccion VARCHAR2(50) NOT NULL,
region VARCHAR2(50) NOT NULL,
ciudad VARCHAR2(50) NOT NULL,
pais VARCHAR2(50) NOT NULL,
codigo_postal VARCHAR2(50) NOT NULL,
telefono VARCHAR2(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE DESPACHADORES (
id NUMBER NOT NULL,
nombre VARCHAR2(50) NOT NULL,
telefono_empresa VARCHAR2(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE CATEGORIAS (
id NUMBER NOT NULL,
nombre VARCHAR2(50) NOT NULL UNIQUE,
PRIMARY KEY (id)
);

CREATE TABLE PROVEEDORES (
id NUMBER NOT NULL,
nombre_empresa VARCHAR2(50) NOT NULL UNIQUE,
nombre_contacto VARCHAR2(50) NOT NULL,
direccion VARCHAR2(50) NOT NULL,
region VARCHAR2(50) NOT NULL,
ciudad VARCHAR2(50) NOT NULL,
telefono VARCHAR2(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE PRODUCTOS (
id NUMBER NOT NULL,
descripcion VARCHAR2(100) NOT NULL,
precio NUMBER NOT NULL CHECK (precio >= 0),
stock NUMBER NOT NULL CHECK (stock >= 0),
descontinuado VARCHAR2(10) NOT NULL CHECK ( descontinuado = 'NO' OR descontinuado='SI'),
categoria_id NUMBER NOT NULL,
proveedor_id NUMBER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (categoria_id) REFERENCES categorias(id),
FOREIGN KEY (proveedor_id) REFERENCES proveedores(id)
);

CREATE TABLE ORDENES (
id NUMBER NOT NULL,
fecha_requerimiento DATE NOT NULL,
fecha_envio DATE NOT NULL,
nombre_destinatario VARCHAR2(50) NOT NULL,
empleado_id NUMBER NOT NULL,
cliente_id NUMBER NOT NULL,
despachador_id NUMBER NOT NULL,
direccion VARCHAR2(50) NOT NULL,
region VARCHAR2(50) NOT NULL,
ciudad VARCHAR2(50) NOT NULL,
pais VARCHAR2(50) NOT NULL,
codigo_postal VARCHAR2(50) NOT NULL,
via_envio VARCHAR2(50) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (empleado_id) REFERENCES empleados(id),
FOREIGN KEY (cliente_id) REFERENCES clientes(id),
FOREIGN KEY (despachador_id) REFERENCES despachadores(id)
);

CREATE TABLE COMPRAS (
id NUMBER NOT NULL,
total NUMBER NOT NULL CHECK (total >= 0),
cantidad NUMBER NOT NULL CHECK (cantidad > 0),
descuento NUMBER NOT NULL CHECK (descuento >= 0),
ordenes_id NUMBER NOT NULL,
productos_id NUMBER NOT NULL,
FOREIGN KEY (ordenes_id) REFERENCES ordenes(id),
FOREIGN KEY (productos_id) REFERENCES productos(id)
);


/* INSERTS */

INSERT INTO empleados (id, nombre, apellido, fecha_nacimiento, direccion, region, ciudad, pais, telefono, cargo) 
VALUES (empleados_seq.nextval, 'Ana', 'Arancibia', TO_DATE('1991/01/21', 'YYYY/MM/DD'), 'Calle A', 'Región A', 'Ciudad A', 'País A', '11-1111-1111', 'Administrador');
INSERT INTO empleados (id, nombre, apellido, fecha_nacimiento, direccion, region, ciudad, pais, telefono, cargo) 
VALUES (empleados_seq.nextval, 'Benito', 'Brown', TO_DATE('1992/02/22', 'YYYY/MM/DD'), 'Calle B', 'Región B', 'Ciudad B', 'País B', '22-2222-2222', 'Bibliotecário');
INSERT INTO empleados (id, nombre, apellido, fecha_nacimiento, direccion, region, ciudad, pais, telefono, cargo) 
VALUES (empleados_seq.nextval, 'Camilo', 'Civich', TO_DATE('1993/03/23', 'YYYY/MM/DD'), 'Calle C', 'Región C', 'Ciudad C', 'País C', '33-3333-3333', 'Consejero');
INSERT INTO empleados (id, nombre, apellido, fecha_nacimiento, direccion, region, ciudad, pais, telefono, cargo) 
VALUES (empleados_seq.nextval, 'Daniela', 'Donose', TO_DATE('1994/04/24', 'YYYY/MM/DD'), 'Calle D', 'Región D', 'Ciudad D', 'País D', '44-4444-4444', 'Director');
INSERT INTO empleados (id, nombre, apellido, fecha_nacimiento, direccion, region, ciudad, pais, telefono, cargo) 
VALUES (empleados_seq.nextval, 'Esmeray', 'Esra', TO_DATE('1995/05/25', 'YYYY/MM/DD'), 'Calle E', 'Región E', 'Ciudad E', 'País E', '55-5555-5555', 'Escritor');

INSERT INTO clientes (id, nombre_empresa, nombre_contacto, email, direccion, region, ciudad, pais, codigo_postal, telefono)
VALUES (clientes_seq.nextval, 'Arenas aridas', 'Antonia Araya', 'arenas.a@gcorreo.com', 'Calle F', 'Región F', 'Ciudad F', 'País F', 'F11-111', '12-1212-1212');
INSERT INTO clientes (id, nombre_empresa, nombre_contacto, email, direccion, region, ciudad, pais, codigo_postal, telefono)
VALUES (clientes_seq.nextval, 'Bario Barato', 'Bella Bulnes', 'bario.barato@hotcorreo.com', 'Calle G', 'Región G', 'Ciudad G', 'País G', 'G22-222', '23-2323-2323');
INSERT INTO clientes (id, nombre_empresa, nombre_contacto, email, direccion, region, ciudad, pais, codigo_postal, telefono)
VALUES (clientes_seq.nextval, 'Casandra Casas', 'Casandra Casal', 'casas.casales@outcorreo.com', 'Calle H', 'Región H', 'Ciudad H', 'País H', 'H33-333', '34-3434-3434');
INSERT INTO clientes (id, nombre_empresa, nombre_contacto, email, direccion, region, ciudad, pais, codigo_postal, telefono)
VALUES (clientes_seq.nextval, 'Diam Diamantes', 'Demian Destello', 'diamantes.dia@yahoocorreo.com', 'Calle I', 'Región I', 'Ciudad I', 'País I', 'I44-444', '45-4545-4545');
INSERT INTO clientes (id, nombre_empresa, nombre_contacto, email, direccion, region, ciudad, pais, codigo_postal, telefono)
VALUES (clientes_seq.nextval, 'Excelentes Equipos', 'Esmeralda Espina', 'equipos.esp@msncorreo.com', 'Calle J', 'Región J', 'Ciudad J', 'País J', 'J55-555', '56-5656-5656');

INSERT INTO despachadores (id, nombre, telefono_empresa) 
VALUES (despachadores_seq.nextval, 'Advento Agil', '15-1234-1234');
INSERT INTO despachadores (id, nombre, telefono_empresa) 
VALUES (despachadores_seq.nextval, 'Bente Beloz', '26-1234-1234');
INSERT INTO despachadores (id, nombre, telefono_empresa) 
VALUES (despachadores_seq.nextval, 'Comito Cumplido', '37-1234-1234');
INSERT INTO despachadores (id, nombre, telefono_empresa) 
VALUES (despachadores_seq.nextval, 'Desviona Desvia', '48-1234-1234');
INSERT INTO despachadores (id, nombre, telefono_empresa) 
VALUES (despachadores_seq.nextval, 'Esperanza Expresa', '59-1234-1234');

INSERT INTO categorias (id, nombre)
VALUES (categorias_seq.nextval, 'Accesorio');
INSERT INTO categorias (id, nombre)
VALUES (categorias_seq.nextval, 'Botanica');
INSERT INTO categorias (id, nombre)
VALUES (categorias_seq.nextval, 'Cosmético');
INSERT INTO categorias (id, nombre)
VALUES (categorias_seq.nextval, 'Dinamita');
INSERT INTO categorias (id, nombre)
VALUES (categorias_seq.nextval, 'Equipos');

INSERT INTO proveedores (id, nombre_empresa, nombre_contacto, direccion, region, ciudad, telefono)
VALUES (proveedores_seq.nextval, 'Accesorios Actuales', 'Acasio Actual', 'Calle K', 'Región K', 'Ciudad K', '98-9898-9898');
INSERT INTO proveedores (id, nombre_empresa, nombre_contacto, direccion, region, ciudad, telefono)
VALUES (proveedores_seq.nextval, 'Botanica Bonita', 'Bentonio Benitez', 'Calle L', 'Región L', 'Ciudad L', '87-8787-8787');
INSERT INTO proveedores (id, nombre_empresa, nombre_contacto, direccion, region, ciudad, telefono)
VALUES (proveedores_seq.nextval, 'Cosmeticos Cosmicos', 'Cosmos Concepto', 'Calle M', 'Región M', 'Ciudad M', '76-7676-7676');
INSERT INTO proveedores (id, nombre_empresa, nombre_contacto, direccion, region, ciudad, telefono)
VALUES (proveedores_seq.nextval, 'Diamantes y dinamitas', 'Dinamo Denota', 'Calle N', 'Región N', 'Ciudad N', '65-6565-6565');
INSERT INTO proveedores (id, nombre_empresa, nombre_contacto, direccion, region, ciudad, telefono)
VALUES (proveedores_seq.nextval, 'Esparta Equipo', 'Emapelota Esalud', 'Calle O', 'Región O', 'Ciudad O', '54-5454-5454');

INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Decorador Baño', 1000, 100, 'NO', 1, 1);
INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Planta Azul', 2000, 80, 'NO', 2, 2);
INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Crema', 3000, 90, 'NO', 3, 3);
INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Dinamita', 4000, 70, 'NO', 4, 4);
INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Pelota', 5000, 30, 'NO', 5, 5 );
INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Decorador Living', 1000, 100, 'NO', 1, 1);
INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Planta Verde', 2000, 80, 'NO', 2, 2);
INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Toallas', 3000, 90, 'NO', 3, 3);
INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Diamantes', 4000, 70, 'NO', 4, 4);
INSERT INTO productos (id, descripcion, precio, stock, descontinuado, categoria_id, proveedor_id)
VALUES (productos_seq.nextval, 'Polera', 5000, 30, 'NO', 5, 5 );

INSERT INTO ordenes (id, fecha_requerimiento, fecha_envio, nombre_destinatario, empleado_id, cliente_id, 
despachador_id, direccion, region, ciudad, pais, codigo_postal, via_envio)
VALUES (ordenes_seq.nextval, TO_DATE('2022/04/15', 'YYYY/MM/DD'), TO_DATE('2022/04/20', 'YYYY/MM/DD'), 'Adrian Andes', 1, 1, 
1, 'Calle P', 'Región P', 'Ciudad P', 'País P', 'P66-666', 'Avión' );
INSERT INTO ordenes (id, fecha_requerimiento, fecha_envio, nombre_destinatario, empleado_id, cliente_id, 
despachador_id, direccion, region, ciudad, pais, codigo_postal, via_envio)
VALUES (ordenes_seq.nextval, TO_DATE('2022/04/16', 'YYYY/MM/DD'), TO_DATE('2022/04/21', 'YYYY/MM/DD'), 'Belinda Beltran', 2, 2, 
3, 'Calle Q', 'Región Q', 'Ciudad Q', 'País Q', 'Q77-777', 'Barco' );
INSERT INTO ordenes (id, fecha_requerimiento, fecha_envio, nombre_destinatario, empleado_id, cliente_id, 
despachador_id, direccion, region, ciudad, pais, codigo_postal, via_envio)
VALUES (ordenes_seq.nextval, TO_DATE('2022/04/17', 'YYYY/MM/DD'), TO_DATE('2022/04/22', 'YYYY/MM/DD'), 'Constanza Cortes', 3, 3, 
3, 'Calle R', 'Región R', 'Ciudad R', 'País R', 'R88-888', 'Camión' );
INSERT INTO ordenes (id, fecha_requerimiento, fecha_envio, nombre_destinatario, empleado_id, cliente_id, 
despachador_id, direccion, region, ciudad, pais, codigo_postal, via_envio)
VALUES (ordenes_seq.nextval, TO_DATE('2022/04/18', 'YYYY/MM/DD'), TO_DATE('2022/04/23', 'YYYY/MM/DD'), 'Danilo Dan', 4, 4, 
5, 'Calle S', 'Región S', 'Ciudad S', 'País S', 'S99-999', 'DeLorean' );
INSERT INTO ordenes (id, fecha_requerimiento, fecha_envio, nombre_destinatario, empleado_id, cliente_id, 
despachador_id, direccion, region, ciudad, pais, codigo_postal, via_envio)
VALUES (ordenes_seq.nextval, TO_DATE('2022/04/19', 'YYYY/MM/DD'), TO_DATE('2022/04/24', 'YYYY/MM/DD'), 'Emerson Emiratos', 5, 5, 
5, 'Calle T', 'Región T', 'Ciudad T', 'País T', 'T00-000', 'Esquino' );

INSERT INTO compras (id, total, cantidad, descuento, ordenes_id, productos_id) 
VALUES (compras_seq.nextval, 900, 1, 100, 1, 1);
INSERT INTO compras (id, total, cantidad, descuento, ordenes_id, productos_id) 
VALUES (compras_seq.nextval, 3800, 2, 200, 2, 2);
INSERT INTO compras (id, total, cantidad, descuento, ordenes_id, productos_id) 
VALUES (compras_seq.nextval, 8700, 3, 300, 3, 3);
INSERT INTO compras (id, total, cantidad, descuento, ordenes_id, productos_id) 
VALUES (compras_seq.nextval, 15600, 4, 400, 4, 4);
INSERT INTO compras (id, total, cantidad, descuento, ordenes_id, productos_id) 
VALUES (compras_seq.nextval, 24500, 5, 500, 5, 5);

/*
INSERT INTO compras (id, total, cantidad, descuento, ordenes_id, productos_id) 
VALUES (compras_seq.nextval, 24500, 5, 500, 3, 3);
INSERT INTO compras (id, total, cantidad, descuento, ordenes_id, productos_id) 
VALUES (compras_seq.nextval, 24500, 5, 500, 4, 2);
*/

-- a. Determinar cuál o cuáles son los clientes con las compras más altas y a qué
-- ciudad corresponden los mismos. Esto permitirá en un futuro que VendeTodo
-- SPA pueda buscar convenios con algunas empresas despachadoras.

SELECT cli.id id_cliente, cli.nombre_empresa nombre_cliente, ord.ciudad, com.total 
FROM ((clientes cli 
INNER JOIN ordenes ord ON cli.id = ord.cliente_id) 
INNER JOIN compras com ON ord.id = com.ordenes_id)
WHERE com.total = (SELECT MAX(total) FROM compras);

-- b. Se necesita saber los nombre de los distribuidores de los productos más
-- vendidos, esto permitirá evaluar comprar por volumen. Solo es necesario que
-- se listen los nombres de todos los registros que cumplan con la solicitud
SELECT prov.nombre_empresa nombre_distribuidor, prod.descripcion nombre_producto, comp.cantidad 
FROM ((proveedores prov 
INNER JOIN productos prod ON prov.id = prod.proveedor_id)
INNER JOIN compras comp ON prod.id = comp.productos_id)
WHERE cantidad = (SELECT MAX(cantidad)FROM compras);