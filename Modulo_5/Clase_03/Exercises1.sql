// Link: https://github.com/cesardiaz-utp/DevSeniorCode-Java-2024/blob/main/clase35/assets/SQL.pdf

// Exercise 1
CREATE TABLE DEPT (
	id NUMERIC(7) PRIMARY KEY,
	name VARCHAR(25) NOT NULL
)

// Exercise 2
CREATE TABLE EMP(
	id  NUMERIC(7) NOT NULL,
	last_name VARCHAR(25) NOT NULL,
	firstname VARCHAR(25) NOT NULL,
	dept_id NUMERIC(7) NOT NULL,
	CONSTRAINT pk_emp PRIMARY KEY (id),
	CONSTRAINT fk_emp_dept FOREIGN KEY (dept_id) REFERENCES DEPT(id)
)

// Exercise 3
DROP TABLE DEPT
// a. Pudo Realizarse el Borrado?
// NO
// b. Cual fue la razon de este comportamiento?
// no se puede eliminar tabla dept porque otros objetos dependen de él
// restricción «fk_emp_dept» en tabla emp depende de tabla dept 

DROP TABLE EMP
// a. Pudo Realizarse el Borrado?
// SI
// b. Cual fue la razon de este comportamiento?
// No tiene ninguna restriccion de llaves foraneas, las otras tablas del esquema no dependen de esta.

SELECT firstname || last_name AS nombre_cmpleto from EMP