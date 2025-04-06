# Ejercicios

## [Ejercicio 1 - Análisis de Ventas de una Tienda](demo/src/test/java/TestAnalisisVentas.java)
Eres un analista de datos en una tienda de comercio electrónico. La tienda tiene un registro de todas las ventas realizadas durante el último mes. Cada venta está representada por una cadena de texto que contiene el nombre del producto, la cantidad vendida y el precio unitario, separados por comas. Tu tarea es procesar estos datos para obtener información útil.

Los datos de entrada son una lista de cadenas de texto, donde cada cadena representa una venta en el formato: `"producto,cantidad,precio_unitario"`. Por ejemplo:
```Java
List<String> ventas = Arrays.asList(
    "camisa,2,20.00",
    "pantalón,1,35.50",
    "zapatos,3,50.00",
    "camisa,1,20.00",
    "pantalón,2,35.50"
);
```
### Tareas
1. **Calcular el Ingreso Total**: Calcula el ingreso total generado por todas las ventas.
1. **Contar Ventas por Producto**: Cuenta cuántas veces se vendió cada producto.
1. **Filtrar Ventas Mayores a un Monto Específico**: Filtra y muestra las ventas cuyo ingreso total (cantidad * precio_unitario) sea mayor a un monto específico.
1. **Obtener el Producto Más Vendido**: Determina cuál fue el producto más vendido en términos de cantidad total.

## [Ejercicio 2 - Análisis de Calificaciones de Estudiantes](demo/src/test/java/TestAnalisisCalificacionesEstudiantes.java)
Eres un analista de datos en una escuela y tienes un registro de las calificaciones de los estudiantes en diferentes materias. Cada registro está representado por una cadena de texto que contiene el nombre del estudiante, la materia y la calificación, separados por comas. Tu tarea es procesar estos datos para obtener información útil.

Los datos de entrada son una lista de cadenas de texto, donde cada cadena representa una calificación en el formato: `"estudiante,materia,calificación"`. Por ejemplo:
```Java
List<String> calificaciones = Arrays.asList(
    "Juan,Matemáticas,85",
    "Ana,Historia,90",
    "Pedro,Matemáticas,70",
    "Juan,Historia,75",
    "Ana,Matemáticas,95",
    "Pedro,Historia,80"
);
```
### Tareas
1. **Calcular el Promedio de Calificaciones por Estudiante**: Calcula el promedio de calificaciones para cada estudiante.
1. **Contar Estudiantes por Materia**: Cuenta cuántos estudiantes tienen calificaciones en cada materia.
1. **Filtrar Calificaciones Mayores a un Valor Específico**: Filtra y muestra las calificaciones que son mayores a un valor específico.
1. **Obtener la Materia con el Promedio Más Alto**: Determina cuál es la materia con el promedio de calificaciones más alto.

## [Ejercicio 3 - Análisis de Facturas de una Empresa](demo/src/test/java/TestAnalisisFacturasEmpresa.java)
Trabajas como analista de datos en una empresa y tienes un registro de todas las facturas emitidas durante el último trimestre. Cada factura está representada por una cadena de texto que contiene el número de factura, el nombre del cliente, el monto total de la factura y el porcentaje de IVA aplicado, separados por comas. Tu tarea es procesar estos datos para obtener información útil.

Los datos de entrada son una lista de cadenas de texto, donde cada cadena representa una factura en el formato: `"numero_factura,cliente,monto_total,iva"`. Por ejemplo:
```Java
List<String> facturas = Arrays.asList(
    "F001,ClienteA,1000.00,19",
    "F002,ClienteB,1500.00,19",
    "F003,ClienteA,2000.00,19",
    "F004,ClienteC,2500.00,19",
    "F005,ClienteB,3000.00,19"
);
```
#### Tareas
1. **Calcular el Monto Total con IVA**: Calcula el monto total de cada factura incluyendo el IVA.
1. **Calcular el Ingreso Total por Cliente**: Calcula el ingreso total generado por cada cliente.
1. **Filtrar Facturas Mayores a un Valor Específico**: Filtra y muestra las facturas cuyo monto total (sin IVA) sea mayor a un valor específico.
1. **Obtener el Cliente con el Mayor Ingreso Total**: Determina cuál fue el cliente que generó el mayor ingreso total.