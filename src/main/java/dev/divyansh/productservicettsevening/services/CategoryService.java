package dev.divyansh.productservicettsevening.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {
    String getAllCategories();

    String getProductsInCategory(Long categoryId);
}
