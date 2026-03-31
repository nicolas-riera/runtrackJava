package jour02.job05;

public class ABCDEF {
    public static void main(String[] args) {
        // Indiquez si les affectations suivantes sont correctes :
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();
        F f = new F();

        a = b; // Correct
        b = a; // Pas correct, A peut-être B mais B n'est pas forcément 
        a = (A) b; // Correct
        a = null; // Correct
        null = a; // Pas correct, on ne peut pas assigner une variable à null
        a = d; // Correct
        b = d; // Pas correct, idem que b = a
        a = e; // Correct
        d = e; // Correct

        A[] as = new A[10];
        as[0] = new A();
        as[1] = new B();
        as[2] = new D(2);
        as[3] = new E();
        as[4] = new C();
        as[5] = new D(4);
        as[6] = new B();

        rechercher(as);
        additionner(as);
    }

    private static void rechercher(A[] as) {
        int nb = 0;
        for (Object elem : as) {
            if (elem instanceof B) {
                nb++;
            }
        }
        System.out.println("Il y a " + nb + " instances de la classe B");
    }

    private static void additionner(A[] as) {
        int somme = 0;
        for (A elem : as) {
            if (elem instanceof D d) {
                somme = somme + d.d;
                
            }
        }
        System.out.println("Somme des variables d : " + somme);
    }
}

class A {
    public A() {}
}

class B extends A {
    public B() {
        super();
    }
}

class C extends B {
    public C() {
        super();
    }
}

class D extends A {
    protected int d = 1;

    public D(int x) {
        super();
        d = x;
    }

    public D() {
    }
}

class E extends D {
    public E() {
        super();
    }
}

class F extends D {
    public F() {
        super();
    }
}