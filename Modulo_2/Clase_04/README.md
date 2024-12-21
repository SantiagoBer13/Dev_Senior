# [Clase 4 Ejercicio Adicional](src/App.java)
## Gestión de Notificaciones (Factory)
### Objetivo
Crear un sistema de notificaciones que envíe mensajes a través de diferentes canales (correo, SMS, push).
### Definición
1.  Crea implementaciones concretas:
    -	CorreoNotificacion: Imprime "Enviando correo: [mensaje]".
    -	SMSNotificacion: Imprime "Enviando SMS: [mensaje]".
    -	PushNotificacion: Imprime "Enviando notificación push: [mensaje]".
- Recuerden que el mensaje es una variable que llega como parámetro
2. Implementa una clase Factory           
    - NotificacionFactory que devuelva el canal adecuado según un parámetro.
