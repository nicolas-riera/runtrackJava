package jour02.job00;

import java.time.LocalDate;

public class Personne {
    public String nom;
    public String prenom;

    protected LocalDate dateNaissance;
    protected String lieuNaissance;

    private String adresse;
    private String telephone;

    public Personne(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    // Les attributs privés ont besoin de getters et de setters 

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
