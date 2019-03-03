public class _03_Operators {
    public static void main(String[] args) {

        //arithmetical ops: +, -, *, /, %
        byte plus = 122 + 5;
        int plus2 = plus + 40;
        System.out.println("plus2 is = " + plus2);

        int multiply = plus2 * 2;
        int division = plus2 / 100;
        System.out.println("Multi is " + multiply);
        System.out.println("Div is " + division);

        // Div by zero
        // int divByZero = plus2 / 0;
        // System.out.println(plus2);

        // div double by zero
        double d1 = 2.000 / 0;
        System.out.println(d1); // Infinity, nie wywala się

        // modulo
        System.out.println(15 % 7);

        // from int to double
        System.out.println(15 / 2.0);

        // shortcuts
        int x = 4;
        x = x + 4;
        x += 4; // x dodać 4
        System.out.println("x is " + x);

        // increment and decrement
        x = 0;
        x += 1;
        x++; // increment by 1, najpierw x potem dodawanie
        ++x; // adds 1 to x, najpierw dodawanie, potem x
        System.out.println(x);

        x = 0;
        --x;
        x--;
        System.out.println(x--);

        // Operations
        double d2 = (((x - plus) / 100) * 4.5) / 75;
        System.out.println("result is " + d2);

        // relational and logical operators
        boolean equal = (5 == 5);
        System.out.println("is equal " + equal);

        boolean notEqual = (5 != 5);
        System.out.println("is not equal " + notEqual);

        boolean greaterThan = (5 > 5);
        boolean greaterThanOrEqual = (5 >= 5);
        System.out.println("greater " + greaterThan);
        System.out.println("greater or equal " + greaterThanOrEqual);

        boolean lowerThan = (5 < 5);
        System.out.println("Lower than" + lowerThan);

        boolean lowerThanEqual = (5 <= 5);
        System.out.println("lower or equal" + lowerThanEqual);

        // logical operators: && (and), || (or)
        boolean isOk = (5 == 5) && (5 < 10);

        //
        int y = 10;
        int t = 20;
        boolean isTrue = ((y < t) || (t == y)) && (y + 15 < 30);

        // binary operators
        // & - binary and
        // | - binary or
        // ^ - binary xor
        // ~ - binary negation
        // <<, >> - shift operators

        int b1 = 0 & 1;
        System.out.println("0 & 1 is " + b1);

        /*
        x1 = 0 1 1 0 = 6
        v1 = 0 0 1 0 = 2
           = 0 0 1 0 = 2
         */

        // shift
        int b2 = 0 << 0;
        System.out.println("shift result is " + b2);


    }
}
