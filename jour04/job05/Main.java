package jour04.job05;

import java.util.Scanner;

class Compteur extends Thread {

    private long longueur;
    private long compte;

    public Compteur(int longueur) {
        this.longueur = longueur;
    }

    public String getResultat() {
        return String.valueOf(compte);
    }

    @Override
    public void run() {

        for (int i = 1; i <= longueur; i++) {
            compte = i;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\"Entrez jusqu'à combien il faut compter : ");
        int longueur = scanner.nextInt();

        long debut = System.currentTimeMillis();

        int milieu = longueur / 2;

        Compteur thread1 = new Compteur(milieu);
        Compteur thread2 = new Compteur(longueur - milieu); 

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String compte1 = thread1.getResultat();
        String compte2 = thread2.getResultat();
        long compte_final = Long.valueOf(compte1) + Long.valueOf(compte2);

        long fin = System.currentTimeMillis();
        System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
        System.out.print(compte_final);

        scanner.close();
    }
}