package jour01;

import java.util.Scanner;

public class job14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre entier : ");
        int nb = scanner.nextInt();

        int nbInverse = 0;

        while (nb != 0) {
            int chiffre = nb % 10;
            nbInverse = nbInverse * 10 + chiffre; 
            nb /= 10; 
        }

        System.out.println("Le nombre inversé est : " + nbInverse);
    }
}
