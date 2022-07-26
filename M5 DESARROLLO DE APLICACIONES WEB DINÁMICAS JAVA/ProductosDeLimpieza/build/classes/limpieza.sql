DROP TABLE producto;
DROP TABLE categoria;
DROP SEQUENCE categoria_seq;
DROP SEQUENCE producto_seq;

CREATE TABLE categoria(
id_categoria int primary key,
nombre_categoria varchar(50)
);

CREATE SEQUENCE categoria_seq
 START WITH 1
 INCREMENT BY 1
 NOCACHE
 NOCYCLE;
 
CREATE TABLE producto(
id_producto int primary key,
nombre_producto varchar(75),
precio_producto int,
descripcion_producto varchar(200),
id_categoria int,
foreign key (id_categoria) references categoria(id_categoria)
);

CREATE SEQUENCE producto_seq
 START WITH 1
 INCREMENT BY 1
 NOCACHE
 NOCYCLE;

INSERT INTO categoria(id_categoria, nombre_categoria)
VALUES (categoria_seq.nextval, 'Detergente líquido');

INSERT INTO categoria(id_categoria, nombre_categoria)
VALUES (categoria_seq.nextval, 'Detergente en polvo');

INSERT INTO producto(id_producto, nombre_producto, precio_producto, descripcion_producto, id_categoria)
VALUES (producto_seq.nextval, 'Omo', 3500, 'Quita manchas', 1);

INSERT INTO producto(id_producto, nombre_producto, precio_producto, descripcion_producto, id_categoria)
VALUES (producto_seq.nextval, 'Ariel', 4400, 'Quita manchas', 2);
