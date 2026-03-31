package jour02.job00;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
       Personne p1 = new Personne("Riera", "Nicolas", LocalDate.of(2006, 9, 8), "Marseille", "1 infinite loop", "7 13 13");
       
       System.out.printf("Nom : %s, Prénom : %s%n", p1.nom, p1.prenom);

       System.out.println(p1.getAdresse());
       p1.setAdresse("2 Infinite Loop");
       System.out.println(p1.getAdresse());
    }
}
