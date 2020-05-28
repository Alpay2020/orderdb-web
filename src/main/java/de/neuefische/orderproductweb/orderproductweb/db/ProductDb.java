package de.neuefische.orderproductweb.orderproductweb.db;

import de.neuefische.orderproductweb.orderproductweb.model.Order;
import de.neuefische.orderproductweb.orderproductweb.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDb {

    private final List<Product> products = new ArrayList<>(); /*(List.of(
            new Product("Banane", "10"),
            new Product("Apfel", "11"),
            new Product("Ananas", "12"),
            new Product("Birne", "13")
    ));*/



    public List<Product> getProducts(){
        return products;
    }
    public Optional<Product> getProductById(String id){
        for(Product product : products){
            if(product.getId().equals(id)){
                return Optional.of(product);
            }
        }
        return Optional.empty();
        //throw Response exception bad request "product not found"
    }

    public void add(Product newproduct) {
        this.products.add(newproduct);
    }

    public void clearDb() {
        products.clear();
    }
}
