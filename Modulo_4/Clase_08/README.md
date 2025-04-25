# Ejercicio
## Sistema de Recomendación de Películas
Un servicio de streaming necesita implementar un sistema que analice la información de películas y usuarios para generar recomendaciones personalizadas. El sistema debe manejar grandes volúmenes de datos y permitir el acceso concurrente. Además, el análisis debe realizarse de manera eficiente utilizando Streams API y Parallel Streams.

### Requisitos:
1. Datos iniciales:
    - Cada película (`Movie`) tiene los siguientes atributos:
      - `String title`
      - `String genre`
      - `Double rating` (calificación promedio)
      - `Integer votes` (cantidad de usuarios que votaron)
    - Cada usuario tiene una lista de películas vistas y calificadas.
    ```java
    List.of(
            new Movie("Extraction", "Acción", 4.1, 120),
            new Movie("Atomic Blonde", "Acción", 4.0, 180),
            new Movie("The Old Guard", "Acción", 3.9, 95),
            new Movie("Nobody", "Acción", 4.2, 140),
            new Movie("Rambo: Last Blood", "Acción", 3.8, 160),
            new Movie("Angel Has Fallen", "Acción", 4.0, 110),
            new Movie("6 Underground", "Acción", 3.7, 150),
            new Movie("Bloodshot", "Acción", 3.6, 130),
            new Movie("Peppermint", "Acción", 4.3, 200),
            new Movie("Hard Kill", "Acción", 3.5, 90),
            new Movie("Vacation Friends", "Comedia", 4.0, 180),
            new Movie("Game Over, Man!", "Comedia", 3.6, 95),
            new Movie("The Wrong Missy", "Comedia", 3.9, 120),
            new Movie("Murder Mystery", "Comedia", 4.2, 140),
            new Movie("Coffee & Kareem", "Comedia", 3.8, 160),
            new Movie("The Lovebirds", "Comedia", 4.1, 150),
            new Movie("Home Sweet Home Alone", "Comedia", 3.7, 100),
            new Movie("Superintelligence", "Comedia", 3.6, 110),
            new Movie("Jexi", "Comedia", 3.8, 200),
            new Movie("Bad Trip", "Comedia", 4.3, 140),
            new Movie("Pieces of a Woman", "Drama", 4.2, 170),
            new Movie("Hillbilly Elegy", "Drama", 4.1, 200),
            new Movie("The Last Letter from Your Lover", "Drama", 4.0, 140),
            new Movie("The Light Between Oceans", "Drama", 3.9, 150),
            new Movie("Penguin Bloom", "Drama", 4.1, 110),
            new Movie("The Dig", "Drama", 4.3, 190),
            new Movie("The Secret: Dare to Dream", "Drama", 3.8, 120),
            new Movie("Fatherhood", "Drama", 4.2, 200),
            new Movie("Finding You", "Drama", 3.7, 100),
            new Movie("Our Friend", "Drama", 4.0, 90),
            new Movie("Outside the Wire", "Ciencia Ficción", 4.1, 180),
            new Movie("Stowaway", "Ciencia Ficción", 4.0, 120),
            new Movie("Infinite", "Ciencia Ficción", 3.9, 150),
            new Movie("Code 8", "Ciencia Ficción", 4.2, 200),
            new Movie("Synchronic", "Ciencia Ficción", 3.8, 140),
            new Movie("Voyagers", "Ciencia Ficción", 3.7, 160),
            new Movie("Cosmic Sin", "Ciencia Ficción", 3.5, 110),
            new Movie("Archive", "Ciencia Ficción", 4.0, 100),
            new Movie("I Am Mother", "Ciencia Ficción", 4.3, 190),
            new Movie("The Midnight Sky", "Ciencia Ficción", 3.7, 130),
            new Movie("The Rental", "Terror", 4.0, 160),
            new Movie("Host", "Terror", 4.2, 110),
            new Movie("Relic", "Terror", 3.9, 95),
            new Movie("The Dark and the Wicked", "Terror", 4.1, 150),
            new Movie("Run", "Terror", 4.3, 190),
            new Movie("The Beach House", "Terror", 3.7, 100),
            new Movie("Come Play", "Terror", 4.0, 170),
            new Movie("No Escape", "Terror", 3.8, 140),
            new Movie("You Should Have Left", "Terror", 3.9, 200),
            new Movie("Amulet", "Terror", 3.6, 120));
    ```
1. Listar las peliculas existentes agrupadas por género.
1. Imprimir el calculo de la cantidad total de votos para cada género para las películas existentes. Calcular de manera eficiente usando **Parallel Streams**.
1. Imprimir una lista de recomendaciones personalizadas para un usuario en base a las películas que ya vio (evita recomendar películas ya vistas).
    - Que pertenezcan a un género seleccionado.
    - Las que tengan un **rating mayor a 4.0** y al menos **100 votos**.
    - Ordenar las películas por `rating` (de mayor a menor). En caso de empate, por título (alfabéticamente).
