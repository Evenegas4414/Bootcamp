DROP SEQUENCE sq_libro;
DROP TABLE libro;

CREATE TABLE libro
(
id_libro NUMBER(18) PRIMARY KEY,
anio NUMBER(4),
titulo VARCHAR2(200),
autor VARCHAR2(80),
imprenta VARCHAR2(200),
disponible NUMBER(1)
);

CREATE SEQUENCE sq_libro MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;

INSERT INTO libro (id_libro, anio, titulo, autor, imprenta, disponible)
VALUES (sq_libro.NEXTVAL, 2021, 'La reina de los condenados', 'Anne Rice', 'imprimetodo',1);


SELECT * FROM libro;
SELECT * FROM libro WHERE id_libro = 1;

--UPDATE libro SET  anio=2021, titulo='ENTREVISTA CON EL VAMPIRO', autor='Anne Rice', imprenta='imprimetodo', disponible=1
--WHERE id_libro=3;