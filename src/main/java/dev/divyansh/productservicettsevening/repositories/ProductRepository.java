package dev.divyansh.productservicettsevening.repositories;

import dev.divyansh.productservicettsevening.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Product save(Product product);
}
