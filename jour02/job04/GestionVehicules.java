package jour02.job04;

import java.time.LocalDate;

public class GestionVehicules {
    public static void main(String[] args) {
        
    }
}

class Vehicule {
    protected String marque;
    protected LocalDate dateAchat;
    protected double prixAchat;
    protected double prixCourant;

    public Vehicule(String marque, LocalDate dateAchat, double prixAchat) {
        this.marque = marque;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
    }

    public void affiche() {
        System.out.println("Marque : " + this.marque);
        System.out.println("Date d'achat : " + this.dateAchat);
        System.out.printf("Prix d'achat : %.2f €\n", this.prixAchat);
        System.out.printf("Prix actuel : %.2f €\n", this.prixCourant);
    }

    public void calculePrix(int anneeActuelle) {
    int age = anneeActuelle - this.dateAchat.getYear();
    
    if (age < 0) age = 0;

    double pourcentageReduction = age * 0.01;
    
    this.prixCourant = this.prixAchat * (1.0 - pourcentageReduction);

    if (this.prixCourant < 0) {
        this.prixCourant = 0;
    }
}
}

class Voiture extends Vehicule {
    private double cylindree;
    private int nombrePortes;
    private double puissance;
    private double kilometrage;
    
    public Voiture(String marque, 
                LocalDate dateAchat,
                double prixAchat,
                double cylindree,
                int nombrePortes, 
                double puissance,
                double kilometrage
            ) {
                super(marque, dateAchat, prixAchat);

                this.cylindree = cylindree;
                this.nombrePortes = nombrePortes;
                this.puissance = puissance;
                this.kilometrage = kilometrage;
            }

    @Override
    public void affiche() {
        super.affiche(); 
        
        System.out.println("Cylindrée : " + this.cylindree + " L");
        System.out.println("Nombre de portes : " + this.nombrePortes);
        System.out.println("Puissance : " + this.puissance + " ch");
        System.out.println("Kilométrage : " + this.kilometrage + " km");
    }

    @Override
    public void calculePrix(int anneeActuelle) {
        double reduction = 0.0;

        int age = anneeActuelle - this.dateAchat.getYear();
        reduction += age * 0.02;

        reduction += Math.round(this.kilometrage / 10000.0) * 0.05;

        if (this.marque.equalsIgnoreCase("Renault") || this.marque.equalsIgnoreCase("Fiat")) {
            reduction += 0.10;
        } else if (this.marque.equalsIgnoreCase("Ferrari") || this.marque.equalsIgnoreCase("Porsche")) {
            reduction -= 0.20; 

        // 4. Application et sécurité
        this.prixCourant = this.prixAchat * (1.0 - reduction);
        if (this.prixCourant < 0) {
            this.prixCourant = 0;
            }
        }
    }
}  

class Avion extends Vehicule {
    private String typeMoteur;
    private double heureVol;

    public Avion(String marque, 
                LocalDate dateAchat,
                double prixAchat,
                String typeMoteur,
                double heureVol
            ) {
                super(marque, dateAchat, prixAchat);

                this.typeMoteur = typeMoteur;
                this.heureVol = heureVol;
            }

    @Override
    public void affiche() {
        super.affiche(); 
        
        System.out.println("Type de moteyr : " + this.typeMoteur);
        System.out.println("Nombre d'heures de vol : " + this.heureVol + " heures");
    }

    @Override
    public void calculePrix(int anneeActuelle) {
        double reduction = 0.0;

        if (this.typeMoteur.equalsIgnoreCase("HELICES")) {
            reduction = (Math.floor(this.heureVol / 100.0)) * 0.10;
        } else {
            reduction = (Math.floor(this.heureVol / 1000.0)) * 0.10;
        }

        this.prixCourant = this.prixAchat * (1.0 - reduction);
        
        if (this.prixCourant < 0) {
            this.prixCourant = 0;
            }
    }
}