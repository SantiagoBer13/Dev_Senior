public class App {
    public static void main(String[] args) throws Exception {
 
        Automovil auto1 = new Automovil("Chevrolet", 2021, null, null);

        Automovil.Rueda rueda = auto1.new Rueda(false, true, false, true);
        Automovil.Motor motor = auto1.new Motor();
        auto1.setRueda(rueda);
        auto1.setMotor(motor);
        

        rueda.verificarEstado();
        auto1.arrancar(); 

        rueda.inflar();
        rueda.verificarEstado();
        auto1.arrancar();

        motor.encender();
        auto1.arrancar();
    }
}