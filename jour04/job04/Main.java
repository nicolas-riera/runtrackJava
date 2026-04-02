package jour04.job04;

import java.util.Scanner;

class Compteur implements Runnable {

    private long longueur;

    public Compteur(long longueur) {
        this.longueur = longueur;
    }

    @Override
    public void run() {
        long debut = System.currentTimeMillis();

        long compte = -1;

        for (int i = 1; i <= longueur; i++) {
            compte = i;
        }

        long fin = System.currentTimeMillis();
        System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
        System.out.println(compte);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez jusqu'à combien il faut compter : ");
        long longueur = scanner.nextLong();

        Thread thread = new Thread(new Compteur(longueur));

        thread.start();

        try {
            thread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}