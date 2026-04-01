package jour03.job00;

class AbstractFinal {
    public static void main(String[] args) {
        A[] tab = new A[3];
        tab[0] = new A(); // Erreur :  On ne peut pas instancer un objet à l'aide d'une classe abstraite, car par définition, elle est imcomplète
        tab[1] = new B();
        tab[2] = new C();
        tab[1].b = 2; // Erreur : bien que b existe, tab est de type A et que b n'est pas défini dans A
        ((C)tab[2]).c = 3; // Erreur : la variable c est déclaré comme final, donc elle ne peut pas être modifié
    }
}

abstract class A {
    int a;
}

class B extends A {
    int b;
}

class C extends A {
    final double c = 1;
}

abstract class D extends A {
    double d;
    int operation(int a) {
        return (a * 2);
    }
    abstract calcul(int b) { // Erreur : Elle est définit pour return un int mais ne return rien, aussi elle possède un corps (car {}) mais elle est défini comme abstraite
    }
}