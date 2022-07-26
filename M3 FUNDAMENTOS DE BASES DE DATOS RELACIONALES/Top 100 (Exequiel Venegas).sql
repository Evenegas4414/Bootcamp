-- 1. Crear usuario llamado pel�culas y asignar todos los permisos.

-- ALTER SESSION SET "_ORACLE_SCRIPT"= true;
-- CREATE USER peliculas IDENTIFIED BY pelis;
-- GRANT ALL PRIVILEGES TO peliculas;

-- DISCONNECT;
-- CONNECT peliculas;
-- Ingresar contrase�a.

-- 2. Cargar archivos (pel�culas.csv y reparto.csv) a su tabla correspondiente.

CREATE TABLE peliculas (
id NUMBER(5), 
pelicula VARCHAR2(100), 
estreno NUMBER(10), 
director VARCHAR2(30),
PRIMARY KEY (id)
);

CREATE TABLE reparto (
id_pelicula NUMBER(5), 
actor VARCHAR2(30),
FOREIGN KEY (id_pelicula) REFERENCES peliculas(id)
);
-- Se cargan los archivos por Data Import.

-- 3. Obtener el ID de la pel�cula �Titanic�

SELECT id, pelicula FROM peliculas WHERE pelicula='Titanic';

-- 4. Listar a todos los actores que aparecen en la pel�cula "Titanic".

SELECT actor FROM reparto WHERE id_pelicula=2;

-- 5. Consultar en cu�ntas pel�culas del top 100 participa Harrison Ford.
SELECT COUNT(actor) AS peliculas_ford FROM reparto WHERE actor='Harrison Ford';

-- 6. Indicar las pel�culas estrenadas entre los a�os 1990 y 1999 ordenadas 
-- por t�tulo de manera ascendente.

SELECT pelicula, estreno FROM peliculas WHERE estreno BETWEEN 1990 AND 1999
ORDER BY pelicula ASC;

-- 7. Hacer una consulta SQL que agrupe los t�tulos con su longitud, 
-- la longitud debe ser nombrado para la consulta como �longitud_titulo�.

SELECT pelicula, LENGTH(pelicula) AS longitud_titulo FROM peliculas 
ORDER BY longitud_titulo ASC;
-- 8. Consultar cual es la longitud m�s grande entre todos los t�tulos de las pel�culas.
SELECT MAX(LENGTH(pelicula)) FROM peliculas;

-- Pelicula con titulo mas largo, acompa�ado de id, titulo.
--SELECT id, pelicula, LENGTH(pelicula) AS longitud_titulo
--FROM peliculas ORDER BY LENGTH(pelicula) DESC
--FETCH  FIRST 1 ROWS ONLY;