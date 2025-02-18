# 📌 Ejercicios de Logging en Java

Practica lo aprendido sobre logs y depuración con estos ejercicios.

---

## [📝 Ejercicio 1: Configuración de Log4j 2](exercise_1/src/main/java/com/code/LoggerExample.java)

**Objetivo:**  
Configurar Log4j 2 en un proyecto Java y generar diferentes tipos de logs.

### 🔹 Instrucciones:
1. Crea un nuevo proyecto Java.
2. Agrega las dependencias necesarias en el archivo `pom.xml` si usas Maven o en `build.gradle` si usas Gradle.
3. Configura un archivo `log4j2.xml` para definir los niveles de logging y el formato de salida.
4. Implementa una clase `LoggerExample.java` que registre mensajes en diferentes niveles (`DEBUG`, `INFO`, `WARN`, `ERROR`, `FATAL`).
5. Ejecuta el programa y verifica los logs generados.


## [📝 Ejercicio 2: Implementación de SLF4J con Log4j 2](exercise_2/src/main/java/com/code/SLF4JExample.java)

**Objetivo:** 
Usar SLF4J como fachada de logging con Log4j 2 como backend.

### 🔹 Instrucciones:
1. Agrega las dependencias de SLF4J y Log4j 2 en pom.xml o build.gradle.
2. Configura el archivo log4j2.xml.
3. Implementa una clase SLF4JExample.java que registre logs en diferentes niveles (TRACE, DEBUG, INFO, WARN, ERROR).
4. Ejecuta el programa y revisa los logs generados.


##  [📝 Ejercicio 3: Simulación de un Error y su Registro en Log](exercise_3/src/main/java/com/code/ErrorLoggingExample.java)

**Objetivo:** 
Capturar una excepción en un bloque try-catch y registrarla en los logs.

### 🔹 Instrucciones:
1. Implementa una clase ErrorLoggingExample.java.
2. Simula una operación que genere una excepción (por ejemplo, dividir por cero o acceder a un índice inválido de un array).
3. Usa un bloque try-catch para capturar la excepción y registrarla usando Log4j 2 o SLF4J.
4. Ejecuta el programa y analiza la salida del log.