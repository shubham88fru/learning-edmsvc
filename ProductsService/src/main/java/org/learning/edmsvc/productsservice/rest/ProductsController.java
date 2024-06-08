package org.learning.edmsvc.productsservice.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    Environment environment;

    @PostMapping
    public String createProduct() {
        return "POST HANDLED";
    }

    @GetMapping
    public String getProduct() {
        //local.server.port gives the actual port on which the process is listening.
        //Remember, we have server.port to 0 and relying on spring to choose a port for us.
        //That chosen values is given by local.server.port.
        return "HTTP GET " + environment.getProperty("local.server.port");
    }

    @PutMapping
    public String updateProduct() {
        return "HTTP PUT handled";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP DELETE Handled";
    }
}
