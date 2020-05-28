package de.neuefische.orderproductweb.orderproductweb.service;

import de.neuefische.orderproductweb.orderproductweb.db.ProductDb;
import de.neuefische.orderproductweb.orderproductweb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Product> searchProductsByName(String query){
        List<Product> matchingProducts = new ArrayList<Product>();
        if (query == null){
            return productDb.getProducts();
        }
        for (int i = 0; i < productDb.getProducts().size(); i++) {
            Product product = productDb.getProducts().get(i);
            if (product.getName().startsWith(query)){
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public Product addProduct(Product newproduct) {
        productDb.add(newproduct);
        return newproduct;
    }
}
