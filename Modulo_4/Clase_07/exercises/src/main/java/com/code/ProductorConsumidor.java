package com.code;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ProductorConsumidor {

    public static void main(String[] args) {
        var arrayBQueue = new ArrayBlockingQueue<String>(5);

        var productor = new Thread(() -> {
            List<String> products = List.of(
                "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5",
                "Elemento 6", "Elemento 7", "Elemento 8", "Elemento 9", "Elemento 10"
            );
            for (String product : products) {
                try {
                    Thread.sleep(2000);
                    arrayBQueue.put(product);
                    System.out.printf("%nProductor agregó: %s", product);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var consumidor = new Thread(() -> {
            try {
                while (true) {
                    String product = arrayBQueue.take();  // Espera automáticamente si está vacía
                    System.out.printf("%nConsumidor procesó: %s", product);
                    Thread.sleep(6000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // ¡Importante iniciar los hilos!
        productor.start();
        consumidor.start();
    }
}
