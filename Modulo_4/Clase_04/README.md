# Ejercicios

## [Ejercicio 1 - Generador de ID para los empleados (Intermedio)](exercises/src/test/java/TestExercise1.java)
La empresa ABCD tiene hasta 100 empleados. La compañía decide crear un número de identificación único UID para cada uno de sus empleados. La compañía le ha asignado la tarea de validar los UIDs generados aleatoriamente.  
Un UID válido debe cumplir con las siguientes reglas:
- Debe contener por lo menos dos letras mayúsculas en el alfabeto inglés.
- Debe tener por lo menos 3 dígitos.
- Contener únicamente dígitos alfanuméricos.
- No tener repeticiones.
- Contener exactamente 10 caracteres.

El dato de entrada es una lista con los UID que desea validar. Por ejemplo:
```Java
List<String> uids = Arrays.asList(
    "B1CD102354",
    "B1CDEF2354"
);
```
Y las salidas deberían ser:
```
B1CD102354 - Inválido
B1CDEF2354 - Válido
```

## Ejercicio 2 - Control de Calidad en una Fábrica de Electrónica (Avanzado)
Eres el analista de calidad en una fábrica de productos electrónicos. La fábrica produce distintos tipos de dispositivos, y cada lote de producción pasa por varias inspecciones de calidad para asegurar que cumple con los estándares. La información sobre los dispositivos y los resultados de las inspecciones está organizada en listas separadas, y tu tarea es realizar un análisis que ayude a mejorar la eficiencia y a identificar problemas de calidad.

### Datos de Entrada
1. **Lista de Productos**: Cada entrada en esta lista contiene el nombre del producto, el número de lote, y el nivel de complejidad en una escala del 1 al 10. El nivel de complejidad afecta la probabilidad de fallos en el producto final. Formato: `"nombre_producto,lote,complejidad"`.
```Java
List<String> productos = Arrays.asList(
    "TabletX,LoteA,8",
    "SmartphoneY,LoteB,7",
    "SmartwatchZ,LoteC,6",
    "LaptopW,LoteD,9",
    "TabletX,LoteE,8"
);
```
2. **Lista de Inspecciones**: Cada entrada en esta lista contiene el número de lote, el tipo de inspección realizada (por ejemplo, “funcionalidad” o “seguridad”), y el porcentaje de muestras aprobadas en dicha inspección. Formato: `"lote,tipo_inspección,porcentaje_aprobación"`.
```Java
List<String> inspecciones = Arrays.asList(
    "LoteA, funcionalidad, 85",
    "LoteB, seguridad, 92",
    "LoteC, funcionalidad, 75",
    "LoteD, seguridad, 60",
    "LoteA, seguridad, 88",
    "LoteC, seguridad, 82",
    "LoteB, funcionalidad, 80"
);
```
3. **Lista de Fallos Detectados**: Esta lista contiene el número de lote, el tipo de fallo detectado (por ejemplo, “sobrecalentamiento”, “falla de pantalla”) y el número de fallos encontrados en el lote. Formato: `"lote,tipo_fallo,cantidad_fallos"`.
```Java
List<String> fallos = Arrays.asList(
    "LoteA, sobrecalentamiento, 3",
    "LoteB, pantalla, 5",
    "LoteC, batería, 2",
    "LoteD, sobrecalentamiento, 7",
    "LoteA, pantalla, 2"
);
```
#### Tareas 
1. **Calcular el Índice de Aprobación por Lote**: Para cada lote, calcula el índice total de aprobación combinando los porcentajes de todas las inspecciones realizadas. Muestra los lotes que tienen un índice de aprobación inferior al 80%, ya que requieren atención inmediata. 
1. **Identificar Lotes con Complejidad Alta y Baja Aprobación**: Filtra y muestra los lotes que tienen un nivel de complejidad superior a 7 y un índice de aprobación inferior al 85%. Estos lotes presentan un mayor riesgo de fallos y deben ser priorizados en el control de calidad. 
1. **Analizar los Tipos de Fallos Frecuentes**: Cuenta la cantidad de cada tipo de fallo en todos los lotes y muestra los fallos más frecuentes (por ejemplo, los que aparecen en al menos 3 lotes). Esto ayuda a identificar problemas comunes en la cadena de producción. 
1. **Obtener el Lote con Mayor Incidencia de Fallos**: Determina cuál es el lote que tiene la mayor cantidad total de fallos detectados. Muestra el nombre del producto y el tipo de fallo más frecuente en dicho lote. 
1. **Evaluar la Calidad Promedio por Tipo de Inspección**: Calcula el promedio de aprobación de cada tipo de inspección (funcionalidad, seguridad, etc.). Identifica cuál tipo de inspección tiene la aprobación promedio más baja y puede necesitar ajustes en los criterios de prueba o procesos de inspección. 
1. **Identificar Lotes con Fallos Críticos en Inspecciones Clave**: Supón que cualquier fallo en la inspección de "seguridad" con una aprobación inferior al 75% es crítico. Encuentra estos lotes y el tipo de fallo asociado para tomar medidas urgentes. 
1. **Simulación de Mejora de Procesos**: Supón que la fábrica implementa una mejora que aumenta un 5% el índice de aprobación en todos los lotes de complejidad mayor a 7. Realiza una simulación y muestra cómo cambiarían los resultados en los índices de aprobación después de esta mejora.