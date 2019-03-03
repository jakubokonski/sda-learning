package pl.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Order implements Serializable {

    private final Account account; // dostęp zamówienia do konta - klasa Account, object account
    private final DiscountPolicy discountPolicy;
    private final List<Item> items;
    private OrderStatus status; // typy enumeryczne, klasa OrderStatus
    private Address address;
    private float discount; // default value = 0, możemy podać: discount = 0;

    //constructor tylko z 2 pierwszych pól, lista będzie pusta, status zmieniany, adres pobierany
    public Order(Account account, DiscountPolicy discountPolicy) {
        this.account = account;
        this.discountPolicy = discountPolicy;
        this.items = new ArrayList<>(); // pusta lista, nie ma w nawiasie, tworzy się automatycznie
        this.status = OrderStatus.IN_PROGRESS;
    }

    public Account getAccount() {
        return account;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) { // dodawanie nowych itemów do listy
        items.add(item);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Address getAddress() {
        return address;
    }
//    public Order getDiscountPolicy; {
//        return discountPolicy;
//    }

    public void applyDiscount(String code) { // przypisanie zniżki
        discount = discountPolicy.getDiscount(code);
    }

    public void sendOrder(Address address) { // wysyłanie
        if (status.equals(OrderStatus.IN_PROGRESS)) {
            this.address = address;
            this.status = OrderStatus.SENT;
        }
    }

    public BigDecimal getTotal() {
        // sum all items, apply discount, return big decimal
        //add item
        BigDecimal total = BigDecimal.ZERO;

        for (Item item : items) {
            BigDecimal itemPrice = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            // total = total + itemPrice
            total = total.add(itemPrice);
        }
        // total = total - (total * discount)
        return total
                .subtract(total.multiply(BigDecimal.valueOf(discount)))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Float.compare(order.discount, discount) == 0 &&
                Objects.equals(account, order.account) &&
                Objects.equals(items, order.items) &&
                status == order.status &&
                Objects.equals(address, order.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, items, status, address, discount);
    }

    @Override
    public String toString() {
        return "Order{" +
                "account=" + account +
                ", status=" + status +
                ", address=" + address +
                ", discount=" + discount +
                '}';
    }
}
