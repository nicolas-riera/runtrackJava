package jour01;

import java.util.Scanner;

public class job08 {
    public static void main(String[] args) {
        Scanner lire = new Scanner(System.in);

        System.out.println("Entrez un nombre : ");
        int nb = lire.nextInt();
        
        int somme = 0;
        for (int i = 0; i <= nb; i++) {
            somme = somme + (nb*nb);
        }
        System.out.print(somme);
    }
}
