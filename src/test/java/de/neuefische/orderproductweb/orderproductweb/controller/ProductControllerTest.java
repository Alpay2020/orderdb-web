package de.neuefische.orderproductweb.orderproductweb.controller;

import de.neuefische.orderproductweb.orderproductweb.db.ProductDb;
import de.neuefische.orderproductweb.orderproductweb.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ProductControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductDb productDb;

    @BeforeEach
    public void resetDatabase() {
        productDb.clearDb();
    }
    @Test
    public void getProductsShouldReturnEmptyArray(){

        //GIVEN

        //WHEN
        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:"+port +"/products/all", Product[].class);
        HttpStatus statusCode = response.getStatusCode();
        Product[] products = response.getBody();

        //THEN
        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(0, products.length);
    }

    /*@Test //ProductConroller@POSTMapping("add")
    public void postProductAndGetProductsShouldReturnAllProducts(){

        //POST
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(
                "http://localhost:"+port+"/products/add", new Product("Tomate","23"), Product.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(new Product("Tomate","23"), postResponse.getBody());

        //WHEN
        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:" + port + "/products/all", Product[].class);
        HttpStatus statusCode = response.getStatusCode();
        Product[] products = response.getBody();

        //THEN
        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(1, products.length);
        assertEquals(new Product("Tomate", "23"), products[0]);
    }*/
    @Test//ProductConroller@PUTMapping("add")
    public void putProductShouldAddProductToDb() {
        //GIVEN
        HttpEntity<Product> requestEntity = new HttpEntity<>(new Product("Kirsche","24"));

        //WHEN
        ResponseEntity<Product> postResponse = restTemplate.exchange("http://localhost:" + port + "/products/add", HttpMethod.PUT, requestEntity, Product.class);

        //THEN
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(new Product("Kirsche","24"), postResponse.getBody());
        assertTrue(productDb.getProducts().contains(new Product("Kirsche","24")));
    }

    @Test
    public void getProductsShouldReturnAllProducts() {
        //GIVEN
        productDb.add(new Product("Erdbeere","25"));
        productDb.add(new Product("Kokosnuss", "26"));


        //WHEN
        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:" + port + "/products/all", Product[].class);
        HttpStatus statusCode = response.getStatusCode();
        Product[] products = response.getBody();

        //THEN
        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(2, products.length);
        assertEquals(new Product("Erdbeere","25"), products[0]);
        assertEquals(new Product("Kokosnuss", "26"), products[1]);
    }


}