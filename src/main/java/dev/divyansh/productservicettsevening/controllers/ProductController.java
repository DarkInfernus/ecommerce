package dev.divyansh.productservicettsevening.controllers;

import dev.divyansh.productservicettsevening.dtos.ProductDto;
import dev.divyansh.productservicettsevening.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public String getAllProducts() {
        return "Getting All Products";
    }
    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId) {
        return "Getting Single Product with id: " + productId;
    }
    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto) {
        return "Adding New Product"+ productDto;
    }
    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId) {
        return "Updating Product with id: " + productId;
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting a Product with id: " + productId;
    }
}
