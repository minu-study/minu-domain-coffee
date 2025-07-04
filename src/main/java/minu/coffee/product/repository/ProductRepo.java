package minu.coffee.product.repository;

import minu.coffee.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
