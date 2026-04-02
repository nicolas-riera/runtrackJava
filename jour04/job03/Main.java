package jour04.job03;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class GenerateurChaine extends Thread {

    private int longueur;
    private String resultat;

    public GenerateurChaine(int longueur) {
        this.longueur = longueur;
    }

    public String getResultat() {
        return resultat;
    }

    @Override
    public void run() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder chaine = new StringBuilder();

        for (int i = 0; i < longueur; i++) {
            int index = random.nextInt(caracteres.length());
            chaine.append(caracteres.charAt(index));
        }

        resultat = chaine.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la longueur de la chaîne : ");
        int longueur = scanner.nextInt();

        long debut = System.currentTimeMillis();

        int milieu = longueur / 2;

        GenerateurChaine thread1 = new GenerateurChaine(milieu);
        GenerateurChaine thread2 = new GenerateurChaine(longueur - milieu);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String chaineFinale = thread1.getResultat() + thread2.getResultat();

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(chaineFinale);
            System.out.println("Chaîne combinée écrite dans output.txt");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        long fin = System.currentTimeMillis();
        System.out.println("Temps d'exécution : " + (fin - debut) + " ms");

        scanner.close();
    }
}