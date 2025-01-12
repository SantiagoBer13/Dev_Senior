# [Clase 5 Ejercicio Adicional](src/App.java):
## Gestión de Restaurante (Composición)
### Objetivo
Implementar un sistema donde un Restaurante tenga varios componentes utilizando composición.
### Definición:
1. Define las siguientes clases:
    -	Cocina: Método prepararPlato() que imprime "Plato preparado".   
    -	Mesero: Método servir() que imprime "El mesero está sirviendo el plato.".
    -	Caja: Método procesarPago() que imprime "Pago procesado".
    -   Crea la clase Restaurante con atributos:
        -	Cocina cocina
        -	Mesero mesero
        -	Caja caja
        -   En Restaurante, implementa un método operarRestaurante() que llame a los métodos de Cocina, Mesero, y Caja.
    -   En la clase principal, crea una instancia de Restaurante y realiza una operación completa.
