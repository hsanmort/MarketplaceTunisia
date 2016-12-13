package com.MarketplaceTunisia.DAO;
import com.MarketplaceTunisia.Entities.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{

}
