# [Clase 3 Ejercicio Adicional](src/App.java)
## Gestión de Pagos
### Objetivo
Implementar un sistema extensible que gestione múltiples métodos de pago mediante el uso de una interfaz en Java. El sistema debe soportar diferentes características para cada método de pago, como validación de montos, procesamiento de pagos y la obtención de detalles específicos.
### Definición
1.	Interfaz MetodoPago:
    -	Define los métodos abstractos comunes para los métodos de pago:
        -	void procesarPago(double monto): Procesa un pago y proporciona información sobre cómo se realiza.
        -	String obtenerDetalles(): Devuelve detalles específicos del método de pago.
        -	boolean validarMonto(double monto): Valida si un monto es aceptable según las reglas del método de pago.
2.	Clases que implementan la interfaz:
    -	Cada clase representa un método de pago distinto, implementando los métodos de la interfaz con sus propias reglas y características:
        -	TarjetaCredito: Procesa pagos con tarjeta de crédito.
        -	PayPal: Procesa pagos mediante la plataforma PayPal.
        -	TransferenciaBancaria: Procesa pagos mediante transferencias bancarias.
        -	Bitcoin: Procesa pagos en criptomonedas.
        -	TarjetaRegalo: Procesa pagos con tarjetas de regalo.
3.	Clase principal (Main):
    -	Simula el uso del sistema, creando una lista de diferentes métodos de pago y procesando pagos con cada uno de ellos.
    -	Valida montos antes de procesar un pago.
    -	Imprime los detalles de cada método y el resultado de los pagos.


### Información adicional a tener en cuenta:
#### Interfaz MetodoPago:
-	Todos los métodos de pago deben implementar los tres métodos definidos en la interfaz.
Validación de montos:
    -	Cada clase define reglas específicas para validar montos:
        -	TarjetaCredito: El monto debe ser mayor que 0.
        -	PayPal: El monto debe estar entre 1 y 10,000.
        -	TransferenciaBancaria: El monto debe ser mayor o igual a 10.
        -	Bitcoin: El monto debe ser mayor o igual a 0.001 BTC.
        -	TarjetaRegalo: El monto debe ser mayor que 0 y menor o igual a 500.
    -   Procesamiento de pagos:
        -	Solo los montos válidos son procesados.
        -	Cada método imprime un mensaje indicando cómo se realiza el pago.