package jour01.job05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner lire = new Scanner(System.in)) {
            System.out.print("Entrez un premier nombre : ");
            Double nb1 = lire.nextDouble();

            System.out.print("Entrez un deuxième nombre : ");
            Double nb2 = lire.nextDouble();

            System.out.print("Entrez un troisième nombre : ");
            Double nb3 = lire.nextDouble();

            if (nb1 > nb2 && nb1 > nb3) {
                System.out.printf("Nombre maximun : %.2f", nb1);
            } else if (nb2 > nb1 && nb2 > nb3) {
                System.out.printf("Nombre maximun : %.2f", nb2);
            } else {
                System.out.printf("Nombre maximun : %.2f", nb3);
            }
        }
    }
}
