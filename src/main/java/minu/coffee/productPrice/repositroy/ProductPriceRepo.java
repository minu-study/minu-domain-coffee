package minu.coffee.productPrice.repositroy;

import minu.coffee.productPrice.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepo extends JpaRepository<ProductPrice, Long> {
}
