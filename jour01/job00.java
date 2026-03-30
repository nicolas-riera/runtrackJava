package jour01;

public class job00 {
    public static void main(String[] args) {
        char c = 'A';
        String str = "Hello World";
        int i = 3;
        long l = 100000L;
        float f = 3.14f;
        boolean b = true;

        System.out.printf("Char: %c | String: %s | Int: %d | Long: %d | Float: %.2f | Boolean: %b%n", c, str, i, l, f, b);

        // int TOTO = 3.817; // ne fontionne pas, un int est forcément un nombre entier
        // System.out.println(TOTO);
    }
}
