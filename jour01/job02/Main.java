package jour01.job02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner lire = new Scanner(System.in)) {
            System.out.print("Entrez votre nom : ");
            String text = lire.nextLine();
            
            System.out.printf("Bonjour %s !", text);
        }
    }
}
