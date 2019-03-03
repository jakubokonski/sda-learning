public class _06_StringBuilders {
    public static void main(String[] args) {
        // string builders are useful for optimizing memory

        //stringbuilder example
        StringBuilder builder = new StringBuilder();
        builder.append("ala");
        builder.append(" ");
        builder.append("ma");
        builder.append(" kotów ");
        builder.append(5);

        // String result = builder; -> tam się nie da
        String result = builder.toString();

        System.out.println(builder);

        // fluent api
        String sentence = new StringBuilder()
                .append("ala ")
                .append("miała ")
                .append("pieska")
                .toString();
        System.out.println(sentence);

        // StringBuffer - wykorzystuje wielowatkowość
        StringBuffer buffer = new StringBuffer()
                .append(" ala ")
                .append(" zgubiła ")
                .append(" chomika");
        System.out.println(buffer);


    }
}
