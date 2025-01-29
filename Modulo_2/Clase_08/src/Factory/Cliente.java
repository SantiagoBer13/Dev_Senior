package Factory;
public abstract class Cliente {
    private static int countID = 0;
    private int id = 0 ;
    private String nombre;
    private String email;

    public Cliente( String nombre, String email) {
        Cliente.countID += 1;
        this.id = Cliente.countID;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract double obtenerDescuento();
}