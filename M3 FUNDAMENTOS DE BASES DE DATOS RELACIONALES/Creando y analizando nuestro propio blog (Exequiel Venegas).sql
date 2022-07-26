-- 1. Crear usuario blog y asignar todos los permisos.
-- ALTER SESSION SET "_ORACLE_SCRIPT"=true;
-- CREATE USER blog IDENTIFIED BY blog;
-- GRANT ALL PRIVILEGES TO blog;

-- DISCONNECT;
-- CONNECT blog;

-- 2. Crear las tablas indicadas de acuerdo al modelo de datos.

DROP TABLE comentario;
DROP TABLE post;
DROP TABLE usuario;


CREATE TABLE usuario (
    id NUMBER(10),
    mail VARCHAR2(25),
    PRIMARY KEY (ID)
)

CREATE TABLE post (
    id NUMBER(10),
    usuario_id NUMBER(10),
    titulo VARCHAR2(100),
    fecha DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
) 

CREATE TABLE comentario (
    id NUMBER(10),
    usuario_id NUMBER(10),
    post_id NUMBER(10),    
    texto VARCHAR2(100),
    fecha DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (post_id) REFERENCES post(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
)

-- 3. Insertar los siguientes registros.

INSERT INTO usuario VALUES (1, 'usuario01@hotmail.com'); 
INSERT INTO usuario VALUES (2, 'usuario02@gmail.com');
INSERT INTO usuario VALUES (3, 'usuario03@gmail.com');
INSERT INTO usuario VALUES (4, 'usuario04@hotmail.com');
INSERT INTO usuario VALUES (5, 'usuario05@yahoo.com');
INSERT INTO usuario VALUES (6, 'usuario06@hotmail.com');
INSERT INTO usuario VALUES (7, 'usuario07@yahoo.com');
INSERT INTO usuario VALUES (8, 'usuario08@yahoo.com');
INSERT INTO usuario VALUES (9, 'usuario09@yahoo.com');

INSERT INTO post VALUES ( 1, 1, 'Post 1: Esto es malo', TO_DATE('2020-06-29', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 2, 5, 'Post 2: Esto es malo', TO_DATE('2020-06-20', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 3, 1, 'Post 3: Esto es excelente', TO_DATE('2020-05-30', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 4, 9, 'Post 4: Esto es bueno', TO_DATE('2020-05-09', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 5, 7, 'Post 5: Esto es bueno', TO_DATE('2020-07-10', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 6, 5, 'Post 6: Esto es excelente', TO_DATE('2020-07-18', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 7, 8, 'Post 7: Esto es excelente', TO_DATE('2020-07-07', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 8, 5, 'Post 8: Esto es excelente', TO_DATE('2020-05-14', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 9, 2, 'Post 9: Esto es bueno', TO_DATE('2020-05-08', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 10, 6, 'Post 10: Esto es bueno', TO_DATE('2020-06-02', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 11, 4, 'Post 11: Esto es bueno', TO_DATE('2020-05-05', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 12, 9, 'Post 12: Esto es malo', TO_DATE('2020-07-23', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 13, 5, 'Post 13: Esto es excelente', TO_DATE('2020-05-30', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 14, 8, 'Post 14: Esto es excelente', TO_DATE('2020-05-01', 'yyyy-mm-dd'));
INSERT INTO post VALUES ( 15, 7, 'Post 15: Esto es malo', TO_DATE('2020-06-17', 'yyyy-mm-dd'));

INSERT INTO comentario VALUES ( 1, 3, 1, 'Este es el comentario 1', TO_DATE('2020-07-08', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 2, 4, 2, 'Este es el comentario 2', TO_DATE('2020-06-07', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 3, 6, 3, 'Este es el comentario 3', TO_DATE('2020-06-16', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 4, 2, 4, 'Este es el comentario 4', TO_DATE('2020-06-15', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 5, 6, 5, 'Este es el comentario 5', TO_DATE('2020-05-14', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 6, 3, 6, 'Este es el comentario 6', TO_DATE('2020-07-08', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 7, 6, 7, 'Este es el comentario 7', TO_DATE('2020-05-22', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 8, 6, 8, 'Este es el comentario 8', TO_DATE('2020-07-09', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 9, 8, 9, 'Este es el comentario 9', TO_DATE('2020-06-30', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 10, 8, 10, 'Este es el comentario 10', TO_DATE('2020-06-19', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 11, 5, 11, 'Este es el comentario 11', TO_DATE('2020-05-09', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 12, 8, 12, 'Este es el comentario 12', TO_DATE('2020-06-17', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 13, 1, 13, 'Este es el comentario 13', TO_DATE('2020-05-01', 'yyyy-mm-dd'));
INSERT INTO comentario VALUES ( 14, 2, 14, 'Este es el comentario 14', TO_DATE('2020-05-31', 'yyyy-mm-dd'));

-- 4. Seleccionar el correo, id y título de todos los post publicados por el usuario.

SELECT u.mail, p.id, p.titulo FROM post p INNER JOIN usuario u
    ON p.usuario_id = u.id ORDER BY p.id;

-- 5. Listar el correo, id y el detalle de todos los comentarios que no hayan sido realizados
--    por el usuario con email usuario06@hotmail.com.

SELECT u.mail, c.id, c.texto FROM comentario c INNER JOIN usuario u
    ON c.usuario_id = u.id WHERE u.mail != 'usuario06@hotmail.com' ORDER BY c.id;

-- 6. Listar los usuarios que no han publicado ningún post.

SELECT u.id, u.mail FROM post p RIGHT JOIN usuario u
    ON p.usuario_id = u.id WHERE p.usuario_id is null;

-- 7. Listar todos los post con sus comentarios (incluyendo aquellos que no poseen comentarios).
SELECT p.id, p.titulo, c.texto FROM post p FULL JOIN comentario c ON p.id = c.post_id;
-- TODOS LOS POST TIENEN AL MENOS UN COMENTARIO, NO MOSTRARÁ NINGUNO NULL

-- 8. Listar todos los usuarios que hayan publicado un post en Junio.
SELECT u.mail, p.fecha FROM post p INNER JOIN usuario u ON p.usuario_id = u.id  WHERE fecha BETWEEN TO_DATE('2020-06-01', 'yyyy/mm/dd') 
    AND TO_DATE('2020-06-30', 'yyyy/mm/dd');
