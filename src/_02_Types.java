import java.util.Date;

public class _02_Types {

    public static void main(String[] args) {
        // primitive types

        // integers numbers
        byte b1 = 127; // 1 byte
        byte b2 = -128;

        short s1 = 32_767; // 2 bytes
        short s2 = -32_768;

        // integer
        int i1 = 2_147_483_647; // 4 bytes
        int i2 = -2_147_483_648;

        long l1 = 9_223_372_036_854_775_807L; // 8 bytes
        long l2 = -9_223_372_036_854_775_808L;

        // floating point numbers

        float f1 = 0.9999F; // 4 bytes
        double d1 = 0.99999; // 8 bytes

        // boolean - true / false
        boolean bb1 = true;
        boolean bb2 = false;

        // chars
        char c1 = 'ę';
        char c2 = 'k';
        System.out.println(c1 + 0);
        System.out.println("Char is " + c1 + c2);

        // casting down
         long l3 = 10000L;
         l3 = b1;
         l3 = s1;
         l3 = i1;

         l3 = s1;

         // unsafe
        s1 = (short) l3;
        System.out.println("unsafe short is = " + s1);

        l3 = 32_768;
        s1 = (short) l3;
        System.out.println("2. unsafe short is = " + s1);

        // double and float
        d1 = f1;
        // nie da się f1 = d1;
        f1 = (float) d1;
        double f3 = 10.0 / 3.0;
        System.out.println(f3);

        // integers  and doubles
        d1 = l1;
        System.out.println(d1);
        f1 = l1;
        System.out.println(f1);

        l1 = (long) d1;
        System.out.println("long from double " + l1);

        // reference type
        Date date1 = new Date();

        // null type
        date1 = null;

        date1.getTime();

        System.out.println("after null");
    }
}
