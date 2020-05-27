package de.neuefische.orderproductweb.orderproductweb.service;

import de.neuefische.orderproductweb.orderproductweb.db.ProductDb;
import de.neuefische.orderproductweb.orderproductweb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductDb productDb;

    @Autowired
    public ProductService(ProductDb productDb) {
        this.productDb = productDb;
    }
    public List<Product> getProducts(){
        return productDb.getProducts();
    }

    public Optional<Product> getProducts(String id) {
        return productDb.getProductById(id);
    }
}
