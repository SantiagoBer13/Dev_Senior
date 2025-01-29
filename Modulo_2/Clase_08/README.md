# [Ejercicio: Proyecto Práctico de Aplicación de POO](src/Main.java)

## 📌 Descripción:
Desarrolla un sistema de gestión de clientes con soporte para facturación y estrategias de descuento, aplicando los principios de Programación Orientada a Objetos (POO) y los patrones de diseño **Singleton, Factory, Observer** y **Strategy**.

## 🎯 Requisitos del Proyecto

### 🔹 1. Gestión de Clientes
- Debe existir una clase `Cliente` con atributos como `id`, `nombre`, `email`, y `tipoCliente` (Regular, VIP, etc.).
- Se debe almacenar y administrar una lista de clientes utilizando un **Singleton**.

### 🔹 2. Facturación
- Cada cliente puede realizar compras y recibir facturas.
- Las facturas deben registrarse con un número único y un monto total.

### 🔹 3. Aplicación de Patrones de Diseño
- **Singleton:** Para gestionar la única instancia de la base de datos de clientes y facturas.
- **Factory Method:** Para la creación de diferentes tipos de clientes.
- **Observer:** Para notificar cuando una factura ha sido generada (por ejemplo, enviar un email).
- **Strategy:** Para definir diferentes estrategias de descuento según el tipo de cliente (Ejemplo: Regular = 5%, VIP = 10%).

## 🚀 Reglas de Implementación

1. Implementa la clase `Cliente` con sus atributos y métodos.
2. Crea la clase `GestorClientes` utilizando el patrón **Singleton** para almacenar y administrar los clientes.
3. Aplica el patrón **Factory Method** para crear diferentes tipos de clientes (`ClienteRegular`, `ClienteVIP`).
4. Crea la clase `Factura` con atributos como `numero`, `cliente`, `montoTotal`.
5. Usa **Observer** para notificar eventos como la generación de una nueva factura.
6. Implementa **Strategy** para aplicar diferentes estrategias de descuento.
