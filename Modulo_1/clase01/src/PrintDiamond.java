/*
 Write a file called PrintDiamond that prints a face using text characters.
 */

public class PrintDiamond {
    public static void main(String[] args) {
        String diamond = 
                """
                  *
                 ***
                *****
               *******
                *****
                 ***
                  *
                """;
        System.out.print(diamond);
    }
}