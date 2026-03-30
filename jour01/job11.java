package jour01;

import java.util.Scanner;

public class job11 {
    public static void main(String[] args) {
    Scanner lire = new Scanner(System.in);

    System.out.print("Entrez un nombre entier : ");
    int nb = lire.nextInt();

    int factoriel = 1;
    for (int i = 1; i <= nb; i++) {
        factoriel = factoriel * i;
    }
    System.out.println(factoriel);
    }
}
