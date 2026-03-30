package jour01;

import java.util.Scanner;

public class job02 {
    public static void main(String[] args) {
        Scanner lire = new Scanner(System.in);

        System.out.print("Entrez votre nom : ");
        String text = lire.nextLine();

        System.out.printf("Bonjour %s !", text);

    }
}
