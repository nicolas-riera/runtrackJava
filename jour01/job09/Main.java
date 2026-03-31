package jour01.job09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner lire = new Scanner(System.in);

    System.out.print("Entrez votre âge: ");
    int age = lire.nextInt();
    
    if (age < 18) {
        System.out.print("Vous êtes mineur");
    } else {
        System.out.print("Vous êtes majeur");
    }
    
    }
}
