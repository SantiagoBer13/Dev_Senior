import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Contar la frecuencia de palabras en un texto");
        System.out.println("Ingresa el texto: ");
        String text = input.nextLine();
        String[] arrayWords = text.split(" ");

        Map<String, Integer> frecuencys = countFrecuency(arrayWords);

        showMap(frecuencys);

        input.close();
    }

    private static void showMap(Map<String, Integer> frecuencys) {
        for (String clave : frecuencys.keySet()) {
            System.out.println(clave + ": " + frecuencys.get(clave));
        }
    }

    public static Map<String, Integer> countFrecuency(String [] words){
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if(map.containsKey(word)){
                int frecuency = map.get(word);
                map.put(word, frecuency + 1);
            }else{
                map.put(word, 1);
            }
        }
        return map;
    }
}