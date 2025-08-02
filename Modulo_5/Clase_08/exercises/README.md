# [Ejercicio MongoDB en Java](src/main/java/com/mongodb/EjercicioMongoDB.java)

Este proyecto te guía para crear una aplicación Java conectada a MongoDB Atlas y realizar operaciones básicas (CRUD) sobre una colección de libros.

## Requisitos

- Java 8+
- MongoDB Java Driver
- Cuenta en [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)

## Instrucciones

1. Crea una nueva clase Java, por ejemplo: `EjercicioMongoDB`.
2. Dentro de la clase, establece la conexión a tu servidor de MongoDB y selecciona una base de datos (por ejemplo, `ejercicios`) y una colección (por ejemplo, `libros`).  
   > ⚠️ Si la base de datos o la colección no existen, MongoDB las creará automáticamente al insertar el primer documento.
3. Implementa métodos para realizar las siguientes tareas:

---

## ✅ Ejercicio 1: Insertar Documentos

Crea un método que inserte los siguientes documentos en la colección `libros`:

```json
[
  { "titulo": "El Señor de los Anillos", "autor": "J.R.R. Tolkien", "anio": 1954, "genero": "Fantasía" },
  { "titulo": "Cien años de soledad", "autor": "Gabriel García Márquez", "anio": 1967, "genero": "Realismo Mágico" },
  { "titulo": "1984", "autor": "George Orwell", "anio": 1949, "genero": "Ciencia Ficción" },
  { "titulo": "Orgullo y prejuicio", "autor": "Jane Austen", "anio": 1813, "genero": "Romance" }
]
```


* Muestra en la consola la cantidad de libros insertados.

## 🔍 Ejercicio 2: Consultar Documentos
Crea métodos para:

- Mostrar todos los libros de la colección.
- Mostrar los libros del género "Fantasía".
- Mostrar los libros publicados después del año 1950.
- Mostrar el libro con el título "Cien años de soledad".

## ✏️ Ejercicio 3: Actualizar Documentos
Crea métodos para:

- Actualizar el año de publicación del libro "El Señor de los Anillos" a 1955.
- Muestra en consola la cantidad de documentos modificados.
- Añadir un nuevo campo "idioma": "Inglés" a todos los libros de Jane Austen.
- Muestra en consola la cantidad de documentos modificados.

## 🗑️ Ejercicio 4: Eliminar Documentos
Crea métodos para:
- Eliminar el libro con el título "1984".
- Muestra en consola la cantidad de documentos eliminados.
- Eliminar todos los libros publicados antes del año 1900.
- Muestra en consola la cantidad de documentos eliminados.

**Pistas:**

* Utiliza las clases `MongoClient`, `MongoDatabase`, `MongoCollection` y `Document` del driver de MongoDB para Java.
* Para insertar múltiples documentos, utiliza `insertMany()`.
* Para consultas, utiliza `find()` y `Filters`. Recuerda iterar sobre el `MongoCursor` para acceder a los resultados.
* Para actualizaciones, utiliza `updateOne()` o `updateMany()` junto con `Filters` y `Updates`.
* Para eliminaciones, utiliza `deleteOne()` o `deleteMany()` junto con `Filters`.
* No olvides cerrar el `MongoClient` al finalizar.
* Puedes crear métodos separados para cada ejercicio para mantener el código organizado.
* Imprime mensajes informativos en la consola para verificar los resultados de cada operación.