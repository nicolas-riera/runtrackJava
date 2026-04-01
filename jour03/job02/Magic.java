package jour03.job02;

import java.util.ArrayList;

abstract class Carte {
    protected int cout;

    public Carte(int cout) {
        this.cout = cout;
    }

    public abstract void afficher();
}

class Terrain extends Carte {
    private char couleur;

    public Terrain(char couleur) {
        super(0); 
        this.couleur = couleur;
        System.out.println("Nouveau terrain créé.");
    }

    @Override
    public void afficher() {
        System.out.println("Terrain (" + couleur + "), coût : " + cout);
    }
}

class Creature extends Carte {
    private String nom;
    private int degats;
    private int pointsDeVie;

    public Creature(int cout, String nom, int degats, int pv) {
        super(cout);
        this.nom = nom;
        this.degats = degats;
        this.pointsDeVie = pv;
        System.out.println("Nouvelle créature créée.");
    }

    @Override
    public void afficher() {
        System.out.println("Créature " + nom + " (" + degats + "/" + pointsDeVie + "), coût : " + cout);
    }
}

class Sortilege extends Carte {
    private String nom;
    private String explication;

    public Sortilege(int cout, String nom, String explication) {
        super(cout);
        this.nom = nom;
        this.explication = explication;
        System.out.println("Nouveau sortilège créé.");
    }

    @Override
    public void afficher() {
        System.out.println("Sortilège " + nom + " : " + explication + ", coût : " + cout);
    }
}

class Jeu {
    private Carte[] cartes;
    private int nombreDeCartes;

    public Jeu() {
        this.cartes = new Carte[10];
        this.nombreDeCartes = 0;
    }

    public void piocher(Carte carte) {
        if (nombreDeCartes < 10) {
            cartes[nombreDeCartes] = carte;
            nombreDeCartes++;
        } else {
            System.out.println("Le jeu est plein !");
        }
    }

    public void jouer() {
        for (int i = 0; i < nombreDeCartes; i++) {
            if (cartes[i] != null) {
                System.out.print("On joue la carte suivante : ");
                cartes[i].afficher();
                cartes[i] = null; 
                return;
            }
        }
        System.out.println("Plus de cartes à jouer.");
    }

    public void afficher() {
        System.out.println("--- Contenu du jeu ---");
        for (Carte c : cartes) {
            if (c != null) {
                c.afficher();
            }
        }
        System.out.println("----------------------");
    }
}

public class Magic {
    public static void main(String[] args) {
        Jeu monJeu = new Jeu();

        monJeu.piocher(new Terrain('b'));
        monJeu.piocher(new Creature(4, "Dragon", 5, 5));
        monJeu.piocher(new Sortilege(2, "Soin", "Restaure 3 PV"));

        monJeu.afficher();

        monJeu.jouer();
        monJeu.jouer();

        System.out.println("\nAprès avoir joué :");
        monJeu.afficher();
    }
}