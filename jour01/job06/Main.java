package jour01.job06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lire = new Scanner(System.in);

        System.out.println("Entrez 5 nombres: ");
        Double moy = lire.nextDouble();

        for (int i = 0; i < 4; i++) {
            Double nb = lire.nextDouble();
            moy = (moy + nb)/2;
        }
        System.out.print(moy);
    }
}
