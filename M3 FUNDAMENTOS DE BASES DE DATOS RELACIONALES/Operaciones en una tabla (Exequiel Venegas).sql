-- PARTE 1 ---------

--1. CREAR UN USUARIO CON NOMBRE “POSTS”.
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
CREATE USER post IDENTIFIED BY pass1234;
GRANT ALL PRIVILEGES TO post;

-- DISCONNECT system;
-- CONNECT post;
-- Ingresar contraseña.

--2. Crear una tabla “post”, con los atributos id, nombre de usuario, 
--   fecha de creación, contenido y descripción.
DROP TABLE comentarios;
DROP TABLE post;

CREATE TABLE post (
id number(5,0), 
nombre_usuario varchar2(20), 
fecha_crecion DATE,

contenido VARCHAR2(500), 
descripcion VARCHAR2(300),
PRIMARY KEY (id)
);

--3. Insertar 3 post, 2 para el usuario "Pamela" y uno para "Carlos".
INSERT INTO post VALUES (1, 'Pamela', TO_DATE('2022-03-01', 'YYYY/MM/DD'), 
'Contenido para el post 1', 'Descripcion para el post 1');

INSERT INTO post VALUES (2, 'Pamela', TO_DATE('2022-03-01', 'YYYY/MM/DD'), 
'Contenido para el post 2', 'Descripcion para el post 2');

INSERT INTO post VALUES (3, 'Carlos', TO_DATE('2022-03-03', 'YYYY/MM/DD'), 
'Contenido para el post 3', 'Descripcion para el post 3');

--4. Modificar la tabla post, agregando la columna título.
ALTER TABLE post ADD titulo VARCHAR2(50);

--5. Agregar título a las publicaciones ya ingresadas.
UPDATE post SET titulo = 'Conociendo las BB.DD.' 
WHERE nombre_usuario = 'Pamela' AND id=1;

UPDATE post SET titulo = 'Conociendo BB.DD.' 
WHERE nombre_usuario = 'Pamela' AND id=2;

UPDATE post SET titulo = 'Confusión con las BB.DD.' 
WHERE nombre_usuario = 'Carlos' AND id=3;

--6. Insertar 2 post para el usuario "Pedro".
INSERT INTO post VALUES (4, 'Pedro', TO_DATE('2022-03-04', 'YYYY/MM/DD'), 
'Contenido para el post 4', 'Descripcion para el post 5', 
'Oracle es complicado Parte 1');

INSERT INTO post VALUES (5, 'Pedro', TO_DATE('2022-03-04', 'YYYY/MM/DD'), 
'Contenido para el post 5', 'Descripcion para el post 5', 
'Oracle es complicado Parte 2');

--7. Eliminar el post de Carlos.
DELETE FROM post WHERE nombre_usuario = 'Carlos';

--8.Ingresar un nuevo post para el usuario "Carlos".
INSERT INTO post VALUES (6, 'Carlos', TO_DATE('2022-03-05', 'YYYY/MM/DD'), 
'Contenido para el post 6', 'Descripcion para el post 6', 
'Mucho tiempo');



-- PARTE 2 -------



--1. Crear una nueva tabla llamada “comentarios”, con los atributos id, fecha,
--   hora de creación y contenido, que se relacione con la tabla posts.
CREATE TABLE comentarios (
id NUMBER(5,0),
fecha DATE,
contenido VARCHAR2(500),
id_post NUMBER(5,0),
FOREIGN KEY (id_post) REFERENCES post(id)
);

--2. Crear 2 comentarios para el post de "Pamela" y 4 para "Carlos".
INSERT INTO comentarios VALUES(1, TO_DATE('2022-03-07', 'YYYY-MM-DD'), 
'Contenido del comentario 1', 1);

INSERT INTO comentarios VALUES(2, TO_DATE('2022-03-08', 'YYYY-MM-DD'), 
'Contenido del comentario 2', 1);


INSERT INTO comentarios VALUES(3, TO_DATE('2022-03-08', 'YYYY-MM-DD'), 
'Contenido del comentario 1', 6);

INSERT INTO comentarios VALUES(4, TO_DATE('2022-03-08', 'YYYY-MM-DD'), 
'Contenido del comentario 2', 6);

INSERT INTO comentarios VALUES(5, TO_DATE('2022-03-08', 'YYYY-MM-DD'), 
'Contenido del comentario 3', 6);

INSERT INTO comentarios VALUES(6, TO_DATE('2022-03-09', 'YYYY-MM-DD'), 
'Contenido del comentario 4', 6);

--3. Crear un nuevo post para "Margarita"
INSERT INTO post VALUES (7, 'Margarita', TO_DATE('2022-03-10', 'YYYY/MM/DD'), 
'Contenido para el post 7', 'Descripcion para el post 7', 
'Como cocinar con Java');

--4. Ingresar 5 comentarios para el post de Margarita.
INSERT INTO comentarios VALUES(7, TO_DATE('2022-03-12', 'YYYY-MM-DD'), 
'Contenido del comentario 1', 7);

INSERT INTO comentarios VALUES(8, TO_DATE('2022-03-12', 'YYYY-MM-DD'), 
'Contenido del comentario 2', 7);

INSERT INTO comentarios VALUES(9, TO_DATE('2022-03-12', 'YYYY-MM-DD'), 
'Contenido del comentario 3', 7);

INSERT INTO comentarios VALUES(10, TO_DATE('2022-03-12', 'YYYY-MM-DD'), 
'Contenido del comentario 4', 7);

INSERT INTO comentarios VALUES(11, TO_DATE('2022-03-12', 'YYYY-MM-DD'), 
'Contenido del comentario 5', 7);



