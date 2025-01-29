package Factory;

import Cliente.TipoCliente;

public class ClienteFactory {
    public static Cliente crearCliente(TipoCliente tipo, String nombre, String email) {
        if (tipo == TipoCliente.VIP) {
            return new ClienteVIP( nombre, email);
        } else {
            return new ClienteRegular( nombre, email);
        }
    }
}