package Observer;
public class EmailNotificador implements IObservador {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Enviando email " + mensaje);
    }
}
