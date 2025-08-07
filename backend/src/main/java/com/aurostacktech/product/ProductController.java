package com.aurostacktech.productmanage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from ProductController!";
    }
}