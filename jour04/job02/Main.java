package jour04.job02;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class GenerateurChaine implements Runnable {

    private int longueur;

    public GenerateurChaine(int longueur) {
        this.longueur = longueur;
    }

    @Override
    public void run() {
        long debut = System.currentTimeMillis();

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder chaine = new StringBuilder();

        for (int i = 0; i < longueur; i++) {
            int index = random.nextInt(caracteres.length());
            chaine.append(caracteres.charAt(index));
        }

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(chaine.toString());
            System.out.println("Chaîne générée et écrite dans output.txt");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture : " + e.getMessage());
        }

        long fin = System.currentTimeMillis();
        System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la longueur de la chaîne : ");
        int longueur = scanner.nextInt();

        Thread thread = new Thread(new GenerateurChaine(longueur));

        thread.start();

        try {
            thread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}