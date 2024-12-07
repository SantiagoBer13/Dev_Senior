import java.time.Duration;
import java.util.Scanner;

/*
 * Doc:
 * https://docs.oracle.com/javase/8/docs/api/index.html?java/time/Duration.html
*/

public class Exercise12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de segundos: ");
        long segundosIngresados = input.nextLong();
        input.close();

        convertirSegundos(segundosIngresados);
    }

    public static void convertirSegundos(long totalSegundos) {
        Duration duracion = Duration.ofSeconds(totalSegundos);

        long dias = duracion.toDays();
        duracion = duracion.minusDays(dias);

        long horas = duracion.toHours();
        duracion = duracion.minusHours(horas);

        long minutos = duracion.toMinutes();
        duracion = duracion.minusMinutes(minutos);

        long segundos = duracion.getSeconds();

        System.out.println("\nDías: " + dias);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);
    }
}
