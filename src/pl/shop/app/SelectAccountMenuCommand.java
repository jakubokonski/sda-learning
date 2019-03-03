package pl.shop.app;

import pl.shop.model.Account;
import pl.shop.model.Order;
import pl.shop.utils.ScannerUtils;

import java.util.List;

public class SelectAccountMenuCommand implements MenuCommand<List<Account>> {

    @Override // metoda do generowania tekstu w menu:
    public String getText() {
        return "Select account";
    }

    @Override
    public void execute(List<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("Account is empty. Please create one.");
            return;
        }

        System.out.println("Please provide account ID: ");
        int id = ScannerUtils.nextInt(1, accounts.size());
        Account account = accounts.get(id - 1);
        MenuSelector<Account> selector = new MenuSelector<Account>(account,
                new CreateOrderMenuCommand(),
                new ListOrdersMenuCommand(),
                new SelectOrderMenuCommand(),
                new CreateAddressMenuCommand(),
                new ListAddressMenuCommand(),
                new ExitMenuCommand<>("Go back")
                );
        selector.select();
    }
}
