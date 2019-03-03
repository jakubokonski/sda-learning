import pl.shop.app.ShopApp;
import pl.shop.model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _30_ShopApp {
    public static void main(String[] args) {
        new ShopApp(getAppState()).run();

    }

    private static List<Account> getAppState() {
        try (ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream(new File("data.state")))) {

            return (List<Account>) stream.readObject();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
/*
 dodawać discount
 dodawać adresy
 dodawać adresy wysyłki
 stany realizacji zamówienia
*/