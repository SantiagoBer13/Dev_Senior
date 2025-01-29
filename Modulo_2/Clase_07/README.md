# [Ejercicio: Clases Internas en Java](src/Exercise_1/App.java)

## Enunciado

En este ejercicio, practicarás el uso de clases internas (también conocidas como clases anidadas no estáticas) en Java. Deberás crear una clase principal que represente un automóvil y dos clases internas que representen componentes específicos del automóvil: `Motor` y `Rueda`.

### Requisitos

1. **Clase Principal `Automovil`**:
   - Debe tener los siguientes atributos:
     - `String marca`: la marca del automóvil.
     - `int año`: el año de fabricación del automóvil.
   - Debe tener un constructor que inicialice estos atributos.
   - Debe tener un método `void arrancar()` que imprima "El automóvil ha arrancado.".

2. **Clase Interna `Motor`**:
   - Debe tener un método `void encender()` que imprima "El motor está encendido.".
   - Debe tener un método `void apagar()` que imprima "El motor está apagado.".

3. **Clase Interna `Rueda`**:
   - Debe tener un método `void inflar()` que imprima "La rueda ha sido inflada.".
   - Debe tener un método `void desinflar()` que imprima "La rueda ha sido desinflada.".

4. **Clase `Main`**:
   - En el método `main`, crea una instancia de `Automovil`.
   - Crea instancias de las clases internas `Motor` y `Rueda` utilizando la instancia de `Automovil`.
   - Llama a los métodos `encender()` y `apagar()` de la clase `Motor`.
   - Llama a los métodos `inflar()` y `desinflar()` de la clase `Rueda`.
   - Llama al método `arrancar()` de la clase `Automovil`.

### Ejemplo de Salida Esperada

```plaintext
El motor está encendido.
El motor está apagado.
La rueda ha sido inflada.
La rueda ha sido desinflada.
El automóvil ha arrancado.
```

# Ejercicio: Uso de Clases Internas Anónimas en Java

## Descripción

En este ejercicio, aplicarás **clases internas anónimas** para simplificar la implementación de un sistema de monitoreo.

Supón que tienes un sistema que necesita monitorear diferentes aspectos de una aplicación en ejecución. Se requiere crear tres módulos de monitoreo:

1. **Monitoreo de Rendimiento**: Se encarga de registrar estadísticas de uso de CPU y memoria.
2. **Monitoreo de Errores**: Se encarga de registrar cualquier error que ocurra en el sistema.
3. **Monitoreo de Seguridad**: Se encarga de registrar intentos de acceso no autorizado.

El sistema debe usar la siguiente interfaz:

```java
public interface MonitoringSystem {
    void startMonitoring();
}

