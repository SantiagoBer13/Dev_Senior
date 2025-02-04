import java.util.HashMap;
import java.util.Map;

public class GestionClientes {

    private static GestionClientes gestionClientes;
    private Map<Integer, String> clientes = new HashMap<>();
    private int idGestorCliente = 0;

    private GestionClientes() {};

    public static GestionClientes getGestor(){
        if(gestionClientes == null){
            gestionClientes = new GestionClientes();
        }
        return gestionClientes;
    }

    public void agregarCliente(String nombre) {
        idGestorCliente++;
        this.clientes.put(idGestorCliente, nombre);
    }

    public String buscarCliente(int id) {
        if(!this.clientes.containsKey(id)){
            throw new ClienteNoEncontradoException("Cliente: " + id + " no encontrado");
        }
        return this.clientes.get(id);
    }

}
