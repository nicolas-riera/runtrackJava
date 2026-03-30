package jour01;

import java.util.Scanner;

public class job12 {
    public static void main(String[] args) {
        Scanner lire = new Scanner(System.in);

        System.out.print("Entrez un nombre entier : ");
        int nb = lire.nextInt();

        for (int i = 0; i <= nb; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
