public class _01_VariablesAndConstants {

    public static void main(String[] args) {

        // declare
        int i1;

        // initialize variable
        i1 = 0;
        System.out.println(i1);

        // declare na initialize variable
        int i2 = 1;
        System.out.println(i2);

        /*
        Komentarz
        wielolinijkowy
         */

        // change variable
        i1 = 2;
        i2 = 3;

        System.out.println("i1 = " +  i1 + ", i2 = " + i2);

        i1 = i2;
        System.out.println("i1 = " + i1);

        // Constant - cannot be changed
        final int i3 = 10;
        // i3 = i1; will not compile

        final int i4;

        i1 = i3;
        i4 = i1;
        System.out.println("constant i4 = " + i4);

        // constant can be assigned to variables
        final int s1 = 7;
        i1 = s1;

        // constant can be initialized from variable
        final int s2 = i1;
        System.out.println("constant s2 = " + s2 + ", variable i1 = " + i1);

    }
}
