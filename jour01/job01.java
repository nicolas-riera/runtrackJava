package jour01;

import java.util.Scanner;

public class job01 {
    public static void main(String[] args) {
        Scanner lire = new Scanner(System.in);

        System.out.println("Entrez du texte : ");
        String text = lire.nextLine();

        System.out.printf("Vous avez écrit : %s", text);

    }
}
