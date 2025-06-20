package minu.coffee.shopInfo.repository;

import minu.coffee.shopInfo.model.ShopInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopInfoRepo extends JpaRepository<ShopInfo, Long> {
}
