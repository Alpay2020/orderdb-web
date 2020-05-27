package de.neuefische.orderproductweb.orderproductweb.model;
import de.neuefische.orderproductweb.orderproductweb.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private ArrayList<Product> products;

}
