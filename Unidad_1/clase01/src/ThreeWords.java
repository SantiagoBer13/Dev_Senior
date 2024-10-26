import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 Prompt the user for three words and display the three words on the screen. For example,

 Enter word 1: Goodbye
 Enter word 2: and
 Enter word 3: Hello
 Goodbye and hello
 */

public class ThreeWords {
    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word1, word2, word3;
        System.out.print("Enter word 1: ");
        word1 = reader.readLine();
        System.out.print("Enter word 2: ");
        word2 = reader.readLine();
        System.out.print("Enter word 3: ");
        word3 = reader.readLine();
        System.out.printf("%s %s %s", word1, word2, word3);
        reader.close();
    }
}
