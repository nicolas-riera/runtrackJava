package jour01.job04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner lire = new Scanner(System.in)) {
            System.out.print("Entrez un nombre : ");
            Double input = lire.nextDouble();

            double carre = input * input;

            System.out.printf("Le carré du nombre est : %.2f", carre);
        }
    }
}
