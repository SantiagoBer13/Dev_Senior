# Ejercicio de Programación: DAO con JDBC y PostgreSQL usando Maven y JUnit

## Objetivo

Desarrollar una aplicación Java utilizando el patrón **DAO (Data Access Object)** para interactuar con una base de datos PostgreSQL, que contenga las siguientes tablas:

- `regions`
- `countries`
- `locations`
- `departments`
- `jobs`
- `employees`
- `dependents`

El objetivo es practicar:
- Uso de JDBC.
- Aplicación del patrón DAO.
- Pruebas unitarias con JUnit.
- Uso de Maven como gestor de dependencias.

---

## Requisitos

1. Implementar una clase abstracta `BaseDAO` que:
   - Defina los parámetros de conexión a la base de datos.
   - Cree y maneje la conexión usando JDBC.

2. Crear clases DAO concretas para cada entidad de la base de datos:
   - `RegionDAO`
   - `CountryDAO`
   - `LocationDAO`
   - `DepartmentDAO`
   - `JobDAO`
   - `EmployeeDAO`
   - `DependentDAO`

3. Implementar al menos las siguientes operaciones en cada DAO:
   - `findById(int id)` o `findById(String id)` según la clave primaria.
   - `findAll()`
   - `insert(...)`
   - `update(...)`
   - `delete(int id)`

4. Utilizar Maven para gestionar las dependencias del proyecto, incluyendo:
   - PostgreSQL JDBC Driver.
   - JUnit para las pruebas.

5. Crear pruebas unitarias con JUnit para verificar el correcto funcionamiento de al menos uno de los DAOs (se recomienda `RegionDAO` o [`CountryDAO`](src/test/java/CountryDaoTest.java)).

---