package Exercise_1;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private static Inventario inventario;
    private Map<String, Integer> productos = new HashMap<>();

    private Inventario(){};

    public static Inventario getInventario(){
        if(inventario == null){
            inventario = new Inventario();
        }
        return inventario;
    }

    public void agregarProducto(String nombre, int cantidad){
        this.productos.put(nombre.toLowerCase(), cantidad);
    }

    public void mostrarInventario(){
        if(this.productos.isEmpty()){
            System.out.println("No hay productos en el inventario");
            return;
        }    
        System.out.println(this.productos);
    }

    public void eliminarProducto(String nombre){
        if(!this.productos.containsKey(nombre.toLowerCase())){
            throw new ProductoNoEncontradoException("Producto: " + nombre + " no encontrado");
        }
        this.productos.remove(nombre);
    }

    public void buscarProducto(String nombre){
        if(!this.productos.containsKey(nombre.toLowerCase())){
            throw new ProductoNoEncontradoException("Producto: " + nombre + " no encontrado");
        }
        System.out.println("Producto: " + nombre + " en el inventario, Cantidad: " + this.productos.get(nombre));
    }

    public void actualizarCantidad(String nombre, int nuevaCantidad) throws CantidadInvalidaException{
        if(!this.productos.containsKey(nombre.toLowerCase())){
            throw new ProductoNoEncontradoException("Producto: " + nombre + " no encontrado");
        }
        if(nuevaCantidad < 0){
            throw new CantidadInvalidaException("La cantidad no puede ser negativa");
        }
        this.productos.put(nombre, nuevaCantidad);
    }
}
