package org.itstep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/product/{id}")
    public List<Product> getProduct(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id){
    Optional<Product> product = productService.findById(id);
        return product.orElse(null);
    }
}
