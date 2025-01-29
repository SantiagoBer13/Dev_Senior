package Singleton;
import java.util.HashMap;
import java.util.Map;

import Factory.Cliente;

public class GestorClientes {
    private static GestorClientes instancia;
    private Map<Integer, Cliente> clientes = new HashMap<>();

    private GestorClientes() {}

    public static GestorClientes getInstancia() {
        if (instancia == null) {
            instancia = new GestorClientes();
        }
        return instancia;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public Cliente obtenerCliente(int id) {
        return clientes.get(id);
    }
}