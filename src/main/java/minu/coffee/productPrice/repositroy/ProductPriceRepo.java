package minu.coffee.productPrice.repositroy;

import minu.coffee.product.model.Product;
import minu.coffee.productPrice.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductPriceRepo extends JpaRepository<ProductPrice, Long> {

    Optional<ProductPrice> findByProductAndEnableAndDeleted(Product product, Boolean enable, Boolean deleted);

}
