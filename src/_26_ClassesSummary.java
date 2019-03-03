public class _26_ClassesSummary { // w jednym pliku może być jedna klasa publiczna, jest taka sama jak nazwa pliku
    public static void main(String[] args) {
        // inheritance
        A a1 = new B();
        // overriding
        a1.test();

        // overloading
        B b1 = new B();
        b1.test();
        b1.test(1);
    }
}

// inheritance A <- B
class A {
    // private dostępny tylko w tej klasie. klasy b i c nie widzą zmiennej i. ZALECANY, chyba że trzeba inaczej
    private int i;

    // protected is visible in this class and inherited classes, raczej unikać
    protected int u;

    // package visible, w całym pakiecie, raczej lepiej "encapsuleować" zmienne
    int p;

    // public visibility - visible everywhere
    public int r;

    /*
    klasy: private / package
    obiekty: private / protected / package / public
    metody: public / protected
     */

    public int getI() { // publiczny getter daje dostęp do zmiennej i przez getI
        return i;
    }
    void test() { // metoda na klasie A
        System.out.println("test A");
    }
    //
    // metody różne widoczności:-------------------------------------------------
    // public - visible everywhere
    public void publicMethod () {
        System.out.println("Public");
    }

    // protected - visible in subclasses
    protected void protectedMethod() {
        System.out.println("Protected");
    }

    // package visibility - cannot override if classes are in different packages
    void packageMethod() {
        System.out.println("Package");
    }

    // private - visible only in class
    private void privateMethod() {
        System.out.println("Private");
    }
}   //--------------------------------------------------

class B extends A {
    private int w;
    private int u;

    @Override // nadpisuje metodę test z klasy niższej override - naspiywanie metod
    void test() {
        System.out.println("test B");
        super.test(); // wykonuje metodę z klasy A
        int u = super.u;
    }

    // overloading definiowanie metod z innymi argumentami
    void test(int k) {
        w = k;
    }
}
final class C extends B { // nie można dziedziczyć z klasy final
    // zawsze stosować final jeśli tworzymy klasę, z której nie można dziedziczyć. Można używac metod i kompozycji.
    private int y;

    void test() {
        int i = getI();
        // i = this.u;
    }
}

// class D extends D {} - cannot extends final class