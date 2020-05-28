package de.neuefische.orderproductweb.orderproductweb.controller;

import de.neuefische.orderproductweb.orderproductweb.db.ProductDb;
import de.neuefische.orderproductweb.orderproductweb.model.Order;
import de.neuefische.orderproductweb.orderproductweb.model.Product;
import de.neuefische.orderproductweb.orderproductweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("all")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("{id}")
    public Optional<Product> getProducts(@PathVariable String id) {
        return productService.getProducts(id);
    }
    @GetMapping("search")
    public List<Product> searchProductsByName(@RequestParam(name = "q", required = false)String query){
        return productService.searchProductsByName(query);
    }
    @PutMapping("add")
    public Product addProduct(@RequestBody Product newproduct){
        return productService.addProduct(newproduct);
    }

}
