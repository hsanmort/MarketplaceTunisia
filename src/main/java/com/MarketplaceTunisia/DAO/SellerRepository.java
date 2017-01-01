package com.MarketplaceTunisia.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import com.MarketplaceTunisia.Entities.Seller;
import com.MarketplaceTunisia.Entities.User;


public interface SellerRepository extends JpaRepository<Seller, Integer> {

	@Query("select s from Seller s where s.name like :x or s.lastName like :x or s.status like :x")
	public Page<Seller> findByMc(@Param("x") String mc, Pageable pageable);

	
//	@Query("UPDATE Seller s SET s.status=1 WHERE s.idUser= :x ")
//	public Seller UpdateSeller(@Param("x") int id);	
	

	@Query ("update Seller s set s.status= :sta where s.idUser= :id")
	public Seller UpdateStatus(@Param("sta") boolean sta,@Param("id") int id );
	
}
