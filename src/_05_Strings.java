public class _05_Strings {
    public static void main(String[] args) {

        // strings are immutable, once created cannot be changed

        String str1 = "abc"; // typ string
        str1 = "edc";


        // how to create strings
        str1 = new String(); // it's empty string ""
        str1 = ""; // pusty, to samo co wyzej
        str1 = new String(new char[] {'a', 'b'}); // string z włsna tablicą z wartościami a b

        // how to concatenate strings
        String str2 = "yupi";
        String str3 = "dupi";
        str1 = str2 + " " + str3;
        System.out.println(str1);

        // how to concatenate with other types
        String str4 = "with int: " + 5;
        String str5 = "with double: " + 5.99;
        String str6 = "with boolean: " + true;

        System.out.println(str4 + ", " + str5 + ", " + str6);

        // how to compare strings
        String str7 = new String("test"); // new String - constructor
        String str8 = "tesT"; // bezpośrednie przypisanie
        // Stringi porównywc jak obiekty
        System.out.println("compare 1: " + (str7.equals(str8)));

        System.out.println("Compare ignore case: " + (str7.equalsIgnoreCase(str8))); // class String .equals metoda

        // what is length?
        System.out.println("length: " + ("Ala ma kota".length()));

        // how to get substring
        String sentence = "ala ma kota";
        String subword = sentence.substring(4, 6);
        System.out.println("subword: " + subword);

        // how to replace characters
        String replace = sentence.replace('a', 'n');
        System.out.println("replace char: " + replace);

        // how to remove spaces from start and end
        String sentence2 = "    ala miała kota    ";
        String trimmed = sentence2.trim();

        System.out.println("trimmed spaces: '" + trimmed + "'");

        // how to check if string contains word
        System.out.println("contains \"kot\": " + (sentence.contains("kot")));

        // lowercase uppercase
        String upper = "ala".toUpperCase();
        System.out.println("Upper: " + upper);
        System.out.println("Lower: " + upper.toLowerCase());

        String lower = "KOTa".toLowerCase();
        System.out.println("Lower " + lower);

        // how to check if the string starts with or ends with
        boolean startsWith = "ala ma kota".startsWith("ala");
        boolean endsWith = "ala ma kota".endsWith("kota");
        System.out.println("Starts with: " + startsWith + ", endswith: " + endsWith);

    }
}
