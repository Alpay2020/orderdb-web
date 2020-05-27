package de.neuefische.orderproductweb.orderproductweb.service;

import de.neuefische.orderproductweb.orderproductweb.db.OrderDb;
import de.neuefische.orderproductweb.orderproductweb.db.ProductDb;
import de.neuefische.orderproductweb.orderproductweb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Orderservice {

    private final OrderDb orderDb;
    private final ProductDb productDb;

    @Autowired
    public Orderservice(OrderDb orderDb, ProductDb productDb) {
        this.orderDb = orderDb;
        this.productDb = productDb;
    }
    public List<Order> getOrders(){
        return orderDb.getOrders();
    }
    public void addOrder(Order order){
        //order.getId() Dann Schleife
        orderDb.add(order);
    }

}
