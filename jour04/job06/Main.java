package jour04.job06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Somme extends Thread {

    private List<String> listeNombres;
    private long somme;

    public Somme(List<String> listeNombres) {
        this.listeNombres = listeNombres;
    }

    public String getResultat() {
        return String.valueOf(somme);
    }

    @Override
    public void run() {

        for (String elem : listeNombres) {
            this.somme = this.somme + Long.valueOf(elem);
        } 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez vos nombres séparés par des virgules (ex: 1,2,3,4) :");
        String saisie = scanner.nextLine();

        long debut = System.currentTimeMillis();

        String[] elements = saisie.split(",\\s*");

        List<String> listeNombres = new ArrayList<>(Arrays.asList(elements));

        // // generate a very long list
        // List<String> listeNombres = new ArrayList<>();
        // for (int i = 0; i < 50_000_000; i++) {
        //     listeNombres.add(String.valueOf(i));
        // }
        // long debut = System.currentTimeMillis();

        Somme thread1 = new Somme(listeNombres);

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String somme = thread1.getResultat();

        long fin = System.currentTimeMillis();
        System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
        System.out.print(somme);

        scanner.close();
    }
}