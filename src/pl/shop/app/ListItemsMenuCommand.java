package pl.shop.app;

import pl.shop.model.Account;
import pl.shop.model.Order;
import pl.shop.utils.ListUtils;

import java.util.List;

public class ListItemsMenuCommand implements MenuCommand<Order> {
    @Override
    public String getText() {
        return "List items";
    }

    @Override
    public void execute(Order orders) {
        if (orders.getItems().isEmpty()) {
            System.out.println("Orders list is empty.");
        }
        String listItems = ListUtils.toNumeratedList(orders.getItems());
        System.out.println("Items list:" + listItems);
    }
}
