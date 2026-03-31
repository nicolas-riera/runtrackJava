package jour01.job12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner lire = new Scanner(System.in)) {
            System.out.print("Entrez un nombre entier : ");
            int nb = lire.nextInt();

            for (int i = 0; i <= nb; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}
