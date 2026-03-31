package jour01.job13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner lire = new Scanner(System.in)) {
            System.out.print("Entrez un nombre entier inférieur ou égal à 9 : ");
            int nb = lire.nextInt();

            if (nb <= 9){
                for (int i = 0; i <= 10; i++) {
                    System.out.printf("%d x %d = %d%n", nb, i, nb*i);
                }
            }
        }
    }
}
