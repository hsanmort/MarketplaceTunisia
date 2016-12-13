package com.MarketplaceTunisia.DAO;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.MarketplaceTunisia.Entities.Adress;
import com.MarketplaceTunisia.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.name like :x or u.lastName like :x or u.mail like :x")
	public Page<User> findByMc(@Param("x") String mc, Pageable pageable);
	
	public Page<User> findByname(String name, Pageable pageable);
	public Page<User> findBylastName(String lastName, Pageable pageable);
	public Page<User> findBymail(String mail, Pageable pageable);
	public Page<User> findBystatus(Boolean status, Pageable pageable);
	public Page<User> findByadress(Adress adress, Pageable pageable);
	
}
