package jour01;

import java.util.ArrayList; 
import java.util.List;

public class job03 {
    public static void main(String[] args) {
        List<Integer> T = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            T.add(i);
        }

        System.out.printf("T[0]: %d, T[1]: %d, T[5]: %d, T[9]: %d", T.get(0), T.get(1), T.get(5), T.get(9));
        // System.out.printf("T[10]: %d", T.get(10); // ne fonctionne pas car l'index n'existe pas
    }
}
