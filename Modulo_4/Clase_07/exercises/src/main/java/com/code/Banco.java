package com.code;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Banco {

    public static void main(String[] args) {
        var conLinQue = new ConcurrentLinkedQueue<String>();

        var t1 = new Thread(() -> {
            String[] clients = {"Jorge","Elizabeth","Isabela","Lucy"};
            for (String client : clients) {
                try {
                    Thread.sleep(2000);
                    conLinQue.add(client);
                    System.out.printf("%nCliente %s esta en la cola.%n", client);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        var t2 = new Thread(() -> {
            String[] newClients = {"Juan","Edison","Erza","Maria"};
            for (String client : newClients) {
                try {
                    Thread.sleep(2000);
                    conLinQue.add(client);
                    System.out.printf("%nCliente %s esta en la cola.%n", client);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        var t3 = new Thread(() -> {
            System.out.printf("%nEl asesor empezará a atender los clientes...%n");
            while (true) {
                int i = 0;
                System.out.println("\\nClientes en la fila.");
                for (String string : conLinQue) {
                    i++;
                    System.out.printf("%d) %s.%n",i,string);
                }
                String client = conLinQue.peek();
                if (client != null) {
                    try {
                        System.out.printf("%nAsesor está atendiendo al cliente %s.%n", client);
                        Thread.sleep(3000);
                        System.out.printf("%nCliente %s atendido.%n", client);
                        conLinQue.poll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (!t1.isAlive() && !t2.isAlive()) {
                        System.out.printf("%nTodos los clientes han sido atendidos.%n");
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                }
            }
        });
        
    
        t1.start();

        try {
            t1.join();
        } catch (Exception e) {
            // TODO: handle exception
        }

        t2.start();
        t3.start();

    }

}
