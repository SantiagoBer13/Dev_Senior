# [📝 Taller: Implementación de Manejo de Errores y Logging en un Sistema de Gestión de Usuarios](exercise/src/main/java/com/code/Main.java)  

## 🎯 Objetivo  
Desarrollar un sistema de gestión de usuarios que implemente un mecanismo robusto de manejo de errores y registro de eventos mediante un sistema de logging. Se espera que el programa capture y registre errores de manera estructurada, diferenciando eventos informativos, advertencias y errores críticos.  

---  

## 🔹 Descripción del Problema  
Una empresa de tecnología está desarrollando un módulo de gestión de usuarios para su plataforma interna. Como parte de los requisitos, necesitan un sistema que:  

- Permita agregar, buscar y eliminar usuarios.  
- Maneje errores de manera adecuada cuando se presenten situaciones inesperadas.  
- Implemente un sistema de logging para registrar eventos y errores de ejecución.  

Como desarrollador, tu tarea es diseñar este módulo asegurando que las excepciones sean manejadas correctamente y que cada evento relevante quede registrado en un archivo de log.  

---  

## 🛠 Instrucciones Paso a Paso  

### 1️⃣ Crear la Clase `UserManager`  
Define una clase llamada `UserManager` que gestione una base de datos simulada de usuarios utilizando un diccionario o lista. Debe contar con los siguientes métodos:  

- `add_user(name)`: Agrega un usuario.  
- `get_user(user_id)`: Retorna la información de un usuario si existe.  
- `delete_user(user_id)`: Elimina un usuario si está registrado.  

### 2️⃣ Implementar el Manejo de Excepciones  
Cada método debe manejar errores y lanzar excepciones cuando se presenten los siguientes casos:  

- Intentar agregar información vacia al crear el usuario.  
- Buscar un usuario que no se encuentre en la base de datos.  
- Intentar eliminar un usuario inexistente.  

Los mensajes de error deben ser descriptivos y fáciles de entender.  

### 3️⃣ Integrar un Sistema de Logging  
Implementa un sistema de registro de eventos utilizando una librería de logging como **Log4j 2** (Java), **SLF4J** (Java), **logging** (Python) o alguna equivalente en tu lenguaje de elección.  

El sistema debe registrar eventos en diferentes niveles de severidad:  
✅ **INFO:** Para acciones exitosas, como agregar o eliminar un usuario.  
⚠️ **WARNING:** Para situaciones inesperadas, como intentar eliminar un usuario que no existe.  
❌ **ERROR:** Para excepciones críticas que interrumpen la ejecución del programa.  

El log debe almacenarse en un archivo llamado `app.log` con un formato estructurado que incluya:  

- **Fecha y hora del evento.**  
- **Nivel de severidad (INFO, WARNING, ERROR).**  
- **Mensaje descriptivo del evento o error.**  
- **(Opcional) Módulo o método donde ocurrió el error.**  

### 4️⃣ Probar el Código con Casos de Uso  
Después de implementar la lógica, ejecuta los siguientes casos de prueba y verifica que el sistema de logging funcione correctamente:  

1. Agregar un usuario con parametros correctos.  
2. Intentar agregar un usuario con parametros incorrectos.  
3. Buscar un usuario que existe en el sistema.  
4. Buscar un usuario que no está registrado.  
5. Eliminar un usuario existente.  
6. Intentar eliminar un usuario que no existe.  

---  

## 📌 Criterios de Evaluación  
✅ El código implementa correctamente el manejo de errores y captura excepciones relevantes.  
✅ Los logs contienen información detallada y están correctamente clasificados por nivel de severidad.  
✅ Se han implementado pruebas para validar el comportamiento del sistema.  
✅ Se sigue una estructura clara y modular en el código.  

💡 **Consejo:** Usa mensajes de log bien estructurados para facilitar la depuración en caso de errores.  
