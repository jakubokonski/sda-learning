import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class _31_Exceptions {
    public static void main(String[] args) {

        try {
            new FileInputStream("asdda.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(); // bez tej linii nie ma komunikatu o błedzie
        }
    }
}
