package jour01;

import java.util.Scanner;

public class job04 {
    public static void main(String[] args) {
        Scanner lire = new Scanner(System.in);

        System.out.print("Entrez un nombre : ");
        Double input = lire.nextDouble();

        double carre = input * input;

        System.out.printf("Le carré du nombre est : %.2f", carre);
    }
}
