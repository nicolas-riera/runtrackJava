package jour01.job01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner lire = new Scanner(System.in)) {
            System.out.println("Entrez du texte : ");
            String text = lire.nextLine();
            
            System.out.printf("Vous avez écrit : %s", text);
        }
    }
}
