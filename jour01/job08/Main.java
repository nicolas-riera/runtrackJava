package jour01.job08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner lire = new Scanner(System.in)) {
            System.out.println("Entrez un nombre : ");
            int nb = lire.nextInt();
            
            int somme = 0;
            for (int i = 0; i <= nb; i++) {
                somme = somme + (nb*nb);
            }
            System.out.print(somme);
        }
    }
}
