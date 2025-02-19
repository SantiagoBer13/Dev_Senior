package com.code;

import com.code.Exceptions.ExceptionNotFoundIdUser;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        UserManager manager = UserManager.getInstance();

        // Caso de prueba 1:
        // Agregar un usuario con parametros correctos.
        System.out.println("--- Caso de prueba 1 ---");
        System.out.println("Agregar un usuario con parametros correctos.");
        main.testCase1(manager);

        // Caso de prueba 2:
        // Agregar un usuario con parametros incorrectos.
        System.out.println("\n--- Caso de prueba 2 ---");
        System.out.println("Agregar un usuario con parametros incorrectos.");
        main.testCase2(manager);

        // Caso de prueba 3:
        // Obtener un usuario con id correcto.
        System.out.println("\n--- Caso de prueba 3 ---");
        System.out.println("Obtener un usuario con id correcto.");
        main.testCase3(manager);

        // Caso de prueba 4:
        // Obtener un usuario con id incorrecto.
        System.out.println("\n--- Caso de prueba 4 ---");
        System.out.println("Obtener un usuario con id incorrecto.");
        main.testCase4(manager);

        // Caso de prueba 5:
        // Eliminar un usuario con id correcto.
        System.out.println("\n--- Caso de prueba 5 ---");
        System.out.println("Eliminar un usuario con id correcto.");
        main.testCase5(manager);

        // Caso de prueba 6:
        // Eliminar un usuario con id incorrecto.
        System.out.println("\n--- Caso de prueba 6 ---");
        System.out.println("Eliminar un usuario con id incorrecto.");
        main.testCase6(manager);

    }

    public void testCase1(UserManager manager){
        manager.addUser( "Cesar", "O4rNj@example.com", "Developer");
    }

    public void testCase2(UserManager manager){
        manager.addUser( "", "O4rNjexample.com", "");
    }

    public void testCase3(UserManager manager){
        manager.getUser(1);
    }

    public void testCase4(UserManager manager){
        try {
            manager.getUser(10);
        } catch (ExceptionNotFoundIdUser e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void testCase5(UserManager manager){
        manager.deleteUser(1);
    }

    public void testCase6(UserManager manager){
        manager.deleteUser(10);
    }
}