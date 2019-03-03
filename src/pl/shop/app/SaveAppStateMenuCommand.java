package pl.shop.app;

import pl.shop.model.Account;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveAppStateMenuCommand implements MenuCommand<List<Account>> {
    @Override
    public String getText() {
        return "Save to file";
    }

    @Override
    public void execute(List<Account> accounts) {
        /*
        2 bazowe klasy
        InputStream - source of data
        OutputStream - destination of data
         */
//        ObjectOutputStream output = null; // rezerwujemy
//        try {
//             output = new ObjectOutputStream(
//                    new FileOutputStream("data.state"));
//            output.writeObject(accounts); // zapisz do pliku obiekt accounts
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (output != null) {
//                try {
//                    output.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        // try with resources. stream is now autoclosable. will always be closed
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data.state"))) {
            stream.writeObject(accounts);
            System.out.println("File written succesfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
