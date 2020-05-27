package de.neuefische.orderproductweb.orderproductweb.db;

import de.neuefische.orderproductweb.orderproductweb.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDb {

    private final List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }
    public void add(Order order) {
        this.orders.add(order);
    }
}
