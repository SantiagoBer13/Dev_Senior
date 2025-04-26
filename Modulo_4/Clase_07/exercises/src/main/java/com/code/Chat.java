package com.code;

import java.util.concurrent.CopyOnWriteArrayList;

public class Chat {

    public static void main(String[] args) {
        var cList = new CopyOnWriteArrayList<String>();

        Thread uJoining = new Thread(() -> {
            String[] users = {"Jorge", "Santiago", "Martin", "Sandra", "Elizabeth", "Maria"};
            for (String user : users) {
                try {
                    Thread.sleep(1500);
                    cList.add(user);
                    System.out.printf("\n%s se ha unido a la conversación.\n", user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread writing = new Thread(() -> {
                for (String user : cList) {
                    System.out.printf("\n%s: Hola.\n", user);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {}
                }
                for (String user : cList) {
                    System.out.printf("\n%s: ¿Cómo has estado?\n", user);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {}
                }
            
        });

        Thread getOuting = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                    if (!cList.isEmpty()) {
                        String user = cList.get(0);
                        cList.remove(0);
                        System.out.printf("\n%s ha abandonado la conversación.\n", user);
                    } else {
                        break;
                    }
                } catch (InterruptedException e) {}
            }
        });

        uJoining.start();

        try {
            uJoining.join();
        } catch (Exception e) {
            // TODO: handle exception
        }
        writing.start();
        getOuting.start();
    }
}
