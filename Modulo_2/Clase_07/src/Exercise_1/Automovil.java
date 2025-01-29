public class Automovil {

    private String marca;
    private int anyo;
    private Rueda rueda;
    private Motor motor;

    public Automovil(String marca, int anyo, Rueda rueda, Motor motor) {
        this.marca = marca;
        this.anyo = anyo;
        this.rueda = rueda;
        this.motor = motor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Rueda getRueda() {
        return rueda;
    }

    public void setRueda(Rueda rueda) {
        this.rueda = rueda;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void arrancar() {
        if (rueda.estanInfladas() && motor.estaEncendido()) {
            System.out.println("El automóvil ha arrancado.");
        } else {
            if (!rueda.estanInfladas()) System.out.println("No se puede arrancar: las ruedas están desinfladas.");
            if (!motor.estaEncendido()) System.out.println("No se puede arrancar: el motor esta apagado.");
        }
    }

    public class Motor {

        public boolean motor = false;

        public void encender() {
            motor = true;
            System.out.printf("El motor del %s está encendido.%n", Automovil.this.marca);
        }

        public void apagar() {
            motor = false;
            System.out.printf("El motor del %s está apagado.%n", Automovil.this.marca);
        }

        public boolean estaEncendido(){
            return motor;
        }
    }

    public class Rueda {

        public boolean r1, r2, r3, r4;

        public Rueda(boolean r1, boolean r2, boolean r3, boolean r4) {
            this.r1 = r1;
            this.r2 = r2;
            this.r3 = r3;
            this.r4 = r4;
        }

        public void inflar() {
            if (r1 && r2 && r3 && r4) {
                System.out.println("Todas las ruedas ya están infladas. Listo para arrancar.");
            } else {
                if (!r1) System.out.println("Inflando rueda 1...");
                if (!r2) System.out.println("Inflando rueda 2...");
                if (!r3) System.out.println("Inflando rueda 3...");
                if (!r4) System.out.println("Inflando rueda 4...");
                r1 = true; r2 = true; r3 = true; r4 = true;
                System.out.println("Todas las ruedas han sido infladas.");
            }
        }

        public void desinflar() {
            r1 = false; r2 = false; r3 = false; r4 = false;
            System.out.println("Todas las ruedas han sido desinfladas.");
        }

        public void verificarEstado() {
            System.out.println("Estado de las ruedas:");
            System.out.println("Rueda 1: " + (r1 ? "Inflada" : "Desinflada"));
            System.out.println("Rueda 2: " + (r2 ? "Inflada" : "Desinflada"));
            System.out.println("Rueda 3: " + (r3 ? "Inflada" : "Desinflada"));
            System.out.println("Rueda 4: " + (r4 ? "Inflada" : "Desinflada"));
        }

        public boolean estanInfladas() {
            return r1 && r2 && r3 && r4;
        }
    }

}