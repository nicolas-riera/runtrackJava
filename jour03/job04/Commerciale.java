package jour03.job04;

import java.util.Vector;
import java.util.Scanner;
import java.util.Date;
import java.util.Locale;

public class Commerciale {
    private Vector<Article> articles = new Vector<>();
    private Vector<Client> clients = new Vector<>();
    private Vector<Commande> commandes = new Vector<>();
    private Vector<Ligne> lignes = new Vector<>();

    public void ajouterArticle(Article a) { articles.add(a); }
    public void supprimerArticle(Article a) { articles.remove(a); }
    public void ajouterClient(Client c) { clients.add(c); }
    public void supprimerClient(Client c) { clients.remove(c); }
    public void passerCommande(Commande c) { commandes.add(c); }
    public void annulerCommande(Commande c) { commandes.remove(c); }

    public static void main(String[] args) {
        Commerciale gestion = new Commerciale();
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int choix = -1;

        do {
            System.out.println("\n--- MENU GESTION COMMERCIALE ---");
            System.out.println("1. Ajouter un article");
            System.out.println("2. Supprimer un article");
            System.out.println("3. Ajouter un client");
            System.out.println("4. Supprimer un client");
            System.out.println("5. Passer une commande");
            System.out.println("6. Annuler une commande");
            System.out.println("7. Afficher articles, clients et commandes");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            
            if (sc.hasNextInt()) {
                choix = sc.nextInt();
                sc.nextLine(); 
            } else {
                System.out.println("Veuillez entrer un nombre.");
                sc.nextLine(); 
                continue;
            }

            switch (choix) {
                case 1:
                    System.out.print("Ref : "); 
                    String r = sc.nextLine();
                    System.out.print("Désignation : "); 
                    String d = sc.nextLine();
                    System.out.print("Prix : "); 
                    double p = sc.nextDouble();
                    System.out.print("Stock : "); 
                    int s = sc.nextInt();
                    sc.nextLine(); 
                    gestion.ajouterArticle(new Article(r, d, p, s));
                    System.out.println("Article ajouté.");
                    break;

                case 2:
                    System.out.print("Indice de l'article à supprimer (commence à 0) : ");
                    int iArt = sc.nextInt();
                    sc.nextLine();
                    if(iArt >= 0 && iArt < gestion.articles.size()) {
                        gestion.articles.remove(iArt);
                        System.out.println("Article supprimé.");
                    } else {
                        System.out.println("Indice invalide.");
                    }
                    break;

                case 3:
                    System.out.print("ID : "); 
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Nom : "); 
                    String n = sc.nextLine();
                    System.out.print("Adresse : "); 
                    String a = sc.nextLine();
                    System.out.print("CA (ex: 1500.50) : "); 
                    double ca = sc.nextDouble();
                    sc.nextLine(); 
                    gestion.ajouterClient(new Client(id, n, a, ca));
                    System.out.println("Client ajouté.");
                    break;

                case 4:
                    System.out.print("Indice du client à supprimer (commence à 0) : ");
                    int iCli = sc.nextInt();
                    sc.nextLine();
                    if(iCli >= 0 && iCli < gestion.clients.size()) {
                        gestion.clients.remove(iCli);
                        System.out.println("Client supprimé.");
                    } else {
                        System.out.println("Indice invalide.");
                    }
                    break;

                case 5:
                    if (gestion.clients.isEmpty() || gestion.articles.isEmpty()) {
                        System.out.println("Erreur : Il faut au moins un client ET un article.");
                    } else {
                        System.out.print("Numéro commande : "); 
                        int num = sc.nextInt();
                        sc.nextLine();
                        
                        Commande cmd = new Commande(num, new Date(), gestion.clients.get(0));
                        gestion.passerCommande(cmd);

                        System.out.println("Quel article (indice) ?");
                        for(int i=0; i<gestion.articles.size(); i++) {
                            System.out.println(i + ": " + gestion.articles.get(i).getDesignation());
                        }
                        int choixArt = sc.nextInt();
                        
                        System.out.print("Quantité à commander : ");
                        int qte = sc.nextInt();
                        sc.nextLine();

                        if (choixArt >= 0 && choixArt < gestion.articles.size()) {
                            Article artChoisi = gestion.articles.get(choixArt);
                            
                            int stockActuel = artChoisi.getQuantiteStock();
                            
                            if (stockActuel >= qte) {
                                artChoisi.setQuantiteStock(stockActuel - qte);
                                
                                Ligne l = new Ligne(cmd, artChoisi, qte);
                                gestion.lignes.add(l);
                                
                                System.out.println("Commande validée. Nouveau stock pour " + 
                                                   artChoisi.getDesignation() + " : " + artChoisi.getQuantiteStock());
                            } else {
                                System.out.println("Stock insuffisant ! (Disponible : " + stockActuel + ")");
                            }
                        } else {
                            System.out.println("Indice d'article invalide.");
                        }
                    }
                    break;

                case 6:
                    if (!gestion.commandes.isEmpty()) {
                        Commande cmdASupprimer = gestion.commandes.get(0);

                        for (int i = 0; i < gestion.lignes.size(); i++) {
                            Ligne li = gestion.lignes.get(i);
                            
                            if (li.getCommande().equals(cmdASupprimer)) {
                                Article art = li.getArticle();
                                int qteAnnulee = li.getQuantiteCommande();
                                
                                art.setQuantiteStock(art.getQuantiteStock() + qteAnnulee);
                                
                                System.out.println("Stock restauré pour " + art.getDesignation() + 
                                                   " (+ " + qteAnnulee + ")");
                            }
                        }

                        gestion.lignes.removeIf(l -> l.getCommande().equals(cmdASupprimer));

                        gestion.annulerCommande(cmdASupprimer);

                        System.out.println("Commande n°" + cmdASupprimer.getNumeroCommande() + " annulée.");
                    } else {
                        System.out.println("Aucune commande à annuler.");
                    }
                    break;
                
                case 7:
                    System.out.println("\n-- Articles --");
                    for(Article art : gestion.articles) art.affiche();
                    
                    System.out.println("\n-- Clients --");
                    for(Client cli : gestion.clients) cli.affiche();

                    System.out.println("\n-- Détails des Lignes de Commande --");
                    if (gestion.lignes.isEmpty()) System.out.println("Aucune ligne.");
                    for(Ligne li : gestion.lignes) {
                        System.out.println("Cmd n°" + li.getCommande().getNumeroCommande() + 
                                           " | Article: " + li.getArticle().getDesignation() + 
                                           " | Qté: " + li.getQuantiteCommande());
                    }
                    break;

                case 0:
                    System.out.println("Au revoir.");
                    break;

                default:
                    System.out.println("Choix invalide, réessayez.");
            }
        } while (choix != 0);
        sc.close();
    }
}

abstract class Personne {
    protected int identite;
    protected String nomSocial;
    protected String adresse;

    protected Personne(int identite, String nomSocial, String adresse) {
        this.identite = identite;
        this.nomSocial = nomSocial;
        this.adresse = adresse;
    }

    protected int getIdentite() {
        return identite;
    }
    protected void setIdentite(int identite) {
        this.identite = identite;
    }

    protected String getNomSocial() {
        return nomSocial;
    }
    protected void setNomSocial(String nomSocial) {
        this.nomSocial = nomSocial;
    }

    protected String getAdresse() {
        return adresse;
    }
    protected void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    protected void affiche() {
        System.out.println("ID : " + identite + ", Nom : " + nomSocial + ", Adresse : " + adresse);
    }
}

class Client extends Personne {
    private double chiffreAffaire;

    public Client(int identite, String nomSocial, String adresse, double chiffreAffaire) {
        super(identite, nomSocial, adresse);
        this.chiffreAffaire = chiffreAffaire;
    }

    public double getChiffreAffaire(){
        return chiffreAffaire; 
    }
    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Chiffre d'affaire : " + chiffreAffaire);
    }
}

class Article {
    private String reference;
    private String designation;
    private double prixUnitaire;
    private int quantiteStock;

    public Article(String reference, String designation, double prixUnitaire, int quantiteStock) {
        this.reference = reference;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantiteStock = quantiteStock;
    }

    public Article(Article a) {
        this.reference = a.reference;
        this.designation = a.designation;
        this.prixUnitaire = a.prixUnitaire;
        this.quantiteStock = a.quantiteStock;
    }

    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantiteStock() {
        return quantiteStock; 
    }
    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public void affiche() {
        System.out.println("Ref : " + reference + " | " + designation + " | PU : " + prixUnitaire + " | Stock : " + quantiteStock);
    }
}

class Commande {
    private int numeroCommande;
    private Date dateCommande;
    private Client client;

    public Commande(int numeroCommande, Date dateCommande, Client client) {
        this.numeroCommande = numeroCommande;
        this.dateCommande = dateCommande;
        this.client = client;
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }
    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public Date getDateCommande() {
        return dateCommande; 
    }
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}

class Ligne {
    private Commande commande;
    private Article article;
    private int quantiteCommande;

    public Ligne(Commande commande, Article article, int quantiteCommande) {
        this.commande = commande;
        this.article = article;
        this.quantiteCommande = quantiteCommande;
    }

    public Commande getCommande() {
        return commande;
    }
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantiteCommande() {
        return quantiteCommande;
    }
    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }
}