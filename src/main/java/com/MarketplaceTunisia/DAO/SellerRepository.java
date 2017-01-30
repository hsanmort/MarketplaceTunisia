package com.MarketplaceTunisia.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




import com.MarketplaceTunisia.Entities.Seller;
import com.MarketplaceTunisia.Entities.Shop;



public interface SellerRepository extends JpaRepository<Seller, Integer> {

	@Query("select s from Seller s where s.name like :x or s.lastName like :x or s.status like :x")
	public Page<Seller> findByMc(@Param("x") String mc, Pageable pageable);

	
//	@Query("UPDATE Seller s SET s.status=1 WHERE s.idUser= :x ")
//	public Seller UpdateSeller(@Param("x") int id);	
	
	@Modifying
	@Query("update Seller s set s.name= :sta where s.idUser= :id")
	public void UpdateStatus(@Param("sta") String sta,@Param("id") int id );
	
	@Query("select s from  Seller s,Shop sh where s.idUser=sh.seller.idUser and sh.idShop= :id")
	public Seller FindSellerByShop(@Param("id") Long id );
	
}
