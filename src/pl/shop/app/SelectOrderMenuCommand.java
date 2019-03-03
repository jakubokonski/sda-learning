package pl.shop.app;

import pl.shop.model.Account;
import pl.shop.model.Order;
import pl.shop.utils.ScannerUtils;

import java.util.List;

public class SelectOrderMenuCommand implements MenuCommand<Account> {
    @Override
    public String getText() {
        return "Select order";
    }

    @Override
    public void execute(Account accounts) {

        if (accounts.getOrders().isEmpty()) {
            System.out.println("No orders to list");
            return;
        }

        System.out.println("Please provide order ID:");
        int id = ScannerUtils.nextInt(1, accounts.getOrders().size());
        Order order = accounts.getOrders().get(id - 1);
        MenuSelector<Order> selector = new MenuSelector<Order>(order,
                new ListItemsMenuCommand(),
                new ApplyDiscountMenuCommand(),
                new SendOrderMenuCommand(),
                new ExitMenuCommand<>("Go back")
        );
        selector.select();
    }
}
