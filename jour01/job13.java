package jour01;

import java.util.Scanner;

public class job13 {
    public static void main(String[] args) {
        Scanner lire = new Scanner(System.in);

        System.out.print("Entrez un nombre entier inférieur ou égal à 9 : ");
        int nb = lire.nextInt();

        if (nb <= 9){
            for (int i = 0; i <= 10; i++) {
                System.out.printf("%d x %d = %d%n", nb, i, nb*i);
            }
        }
    }
}
