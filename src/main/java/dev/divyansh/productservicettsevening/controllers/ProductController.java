package dev.divyansh.productservicettsevening.controllers;

import dev.divyansh.productservicettsevening.dtos.FakeStoreApiProductDto;
import dev.divyansh.productservicettsevening.exceptions.NotFoundException;
import dev.divyansh.productservicettsevening.models.Product;
import dev.divyansh.productservicettsevening.repositories.CategoryRepository;
import dev.divyansh.productservicettsevening.repositories.ProductRepository;
import dev.divyansh.productservicettsevening.services.ProductService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public ProductController(ProductService productService, ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productService = productService;
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }


    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() throws Exception{
        List<Product> products=productService.getAllProducts();
        ResponseEntity<List<Product>> response= new ResponseEntity<>(products,HttpStatus.OK);
        return response;
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Custom-Header", "Custom-Value");
        ResponseEntity<Product> response= new ResponseEntity<>(productService.getSingleProduct(productId),headers, HttpStatus.OK);
        return response;
    }
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody FakeStoreApiProductDto fakeStoreApiProductDto) {
        Product product=productService.addNewProduct(fakeStoreApiProductDto);
        ResponseEntity<Product> response= new ResponseEntity<>(product,HttpStatus.OK);
        categoryRepository.save(product.getCategory());
        productRepository.save(product);
        return response;

    }
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId,@RequestBody FakeStoreApiProductDto fakeStoreApiProductDto) {
        Product product=productService.updateProduct(productId,fakeStoreApiProductDto);
        ResponseEntity<Product> response= new ResponseEntity<>(product,HttpStatus.OK);
        return response;

    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        boolean isDeleted=productService.deleteProduct(productId);
        if(isDeleted){
            return "Product with id "+productId+" is deleted";
        }
        return "Product with id "+productId+" is not deleted";

    }
}
