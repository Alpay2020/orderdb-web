package de.neuefische.orderproductweb.orderproductweb.controller;

import de.neuefische.orderproductweb.orderproductweb.model.Order;
import de.neuefische.orderproductweb.orderproductweb.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final Orderservice orderservice;

    @Autowired
    public OrderController(Orderservice orderservice) {
        this.orderservice = orderservice;
    }
    @RequestMapping("all")
    public List<Order> getOrders(){
        return orderservice.getOrders();
    }
    @PutMapping("add")
    public void addOrder(@RequestBody Order neworder){
        orderservice.addOrder(neworder);
    }
}
