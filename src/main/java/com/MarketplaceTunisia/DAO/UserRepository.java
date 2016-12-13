package com.MarketplaceTunisia.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MarketplaceTunisia.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
