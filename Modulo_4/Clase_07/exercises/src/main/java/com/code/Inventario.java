package com.code;

import java.util.concurrent.ConcurrentHashMap;

public class Inventario {
    
    public static void main(String[] args) {
        var cHashMap = new ConcurrentHashMap<String, Integer>();

        // Worker 1
        Thread t1 = new Thread(() -> {
            String[] passifloras = {"GULUPA", "GULUPA WIMPA MILAGROSA", "GULUPA WIMPA KIMBARA"};
            for (String fruta : passifloras) {
                cHashMap.put(fruta, 10);
                System.out.println("WORKER 1 añadió: " + fruta);
            }
        });

        // Worker 2
        Thread t2 = new Thread(() -> {
            String[] passifloras = {"UCHUVA", "UCHUVA CERTIFICADA ORGANICA", "UCHUVA NACIONAL"};
            for (String fruta : passifloras) {
                cHashMap.put(fruta, 10);
                System.out.println("WORKER 2 añadió: " + fruta);
            }
        });

        t1.start();
        t2.start();

        // Esperar a que terminen los hilos
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostrar claves del ConcurrentHashMap
        System.out.println("\n Claves en el inventario:");
        for (String key : cHashMap.keySet()) {
            System.out.println(key);
        }
    }
}
