import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Encontrar elementos únicos en una lista de números");
        String option;
        do {
            System.out.printf("Ingresa un número: ");
            int number = Integer.parseInt(input.nextLine());
            numbers.add(number);
            System.out.println("¿Deseas continuar? (si/no)");
            option = input.nextLine().toLowerCase();
            if (option.equals("no")) {
                System.out.println("Saliendo.");
                break;
            } else if (!option.equals("si")) {
                System.out.println("Opción no válida.");
            }
        } while (true);
        
        Map<Integer, Integer> uniqueNumbers = findUniqueNumbers(numbers);
        if (uniqueNumbers.size() > 0) {
            System.out.println("Números únicos:");
            for (Integer unique : uniqueNumbers.keySet()) {
                System.out.println(unique);
            }
        } else {
            System.out.println("No hay números únicos.");
        }
        input.close();
    }

    public static Map<Integer, Integer> findUniqueNumbers(ArrayList<Integer> numbers){
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer number : numbers) {
            if(map.containsKey(number)){
                int frecuency = map.get(number);
                map.put(number, frecuency + 1);
            }else{
                map.put(number, 1);
            }
        }
        for(Integer clave : map.keySet()){
            if(map.get(clave) > 1){
                map.remove(clave);
            }
        }

        return map;
    }
}
