package dev.divyansh.productservicettsevening.services;

import dev.divyansh.productservicettsevening.dtos.FakeStoreApiProductDto;
import dev.divyansh.productservicettsevening.dtos.ProductDto;
import dev.divyansh.productservicettsevening.exceptions.NotFoundException;
import dev.divyansh.productservicettsevening.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);
    Product addNewProduct(FakeStoreApiProductDto fakeStoreApiProductDto);


    Product updateProduct( Long productId, FakeStoreApiProductDto fakeStoreApiProductDto);


    boolean deleteProduct(Long productId) throws NotFoundException;
}
