public class Exercise20 {
    public static void main(String[] args) {
        byte rows = 8;
        byte cols = 8;

        for (byte i = 0; i < rows; i++) {
            for (byte j = 0; j < cols; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("| N ");
                } else {
                    System.out.print("| B ");
                }
            }
            System.out.println("|");
        }
    }
}