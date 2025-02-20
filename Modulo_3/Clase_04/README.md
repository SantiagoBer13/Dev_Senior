# [📝 Ejercicio: Depuración en Visual Studio Code con Java](src/App.java)

## 🎯 Objetivo:
Practicar técnicas avanzadas de depuración en Visual Studio Code usando Java, identificando y corrigiendo errores lógicos, excepciones y problemas de rendimiento en un programa que gestiona una lista de tareas.  

## 📌 Descripción del Problema:
Tienes un pequeño sistema de gestión de tareas que permite:  
✅ Agregar tareas con un nombre y una descripción.  
✅ Marcar tareas como completadas.  
✅ Listar todas las tareas pendientes.  

El código tiene errores ocultos que debes encontrar y corregir usando las herramientas de depuración en Visual Studio Code, como:  
🔍 Puntos de interrupción (breakpoints).  
🔄 Inspección de variables.  
⏭ Ejecución paso a paso.  
🎯 Evaluación de expresiones.  

## 🛑 Errores que debes encontrar y corregir:
🔴 **Error 1:** Intento de acceder a un índice fuera del rango de la lista (provoca `IndexOutOfBoundsException`).  
🔴 **Error 2:** El método `listarTareasPendientes()` no muestra correctamente las tareas si hay un error previo.  
🔴 **Error 3:** Falta de mensajes de error cuando se intenta acceder a una tarea inexistente.  

💡 **Consejo:** Usa breakpoints en los métodos `marcarTareaComoCompletada()` y `listarTareasPendientes()`.  
