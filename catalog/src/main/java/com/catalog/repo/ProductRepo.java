package com.catalog.repo;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.catalog.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>  {
	
	Product findByProductId(int productId);
	Product findByClassification(String classification);
	Product findTopByOrderByProductIdDesc();
	
	@Transactional
	@Modifying
	@Query(value="update Product p set p.prod_image = ?2 where p.product_id = ?1",nativeQuery=true)
	void add_image(int id,byte[] image);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update product p set p.product_name = ?1 ,p.category=?2 ,p.provider=?4, p.classification=?3 where p.product_id = ?5",nativeQuery=true)
	int updateProduct(String name,String category,String classification,String provider,int id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update business b set b.product_name = ?1 where b.product_name = ?2",nativeQuery=true)
	int updateProductBusiness(String new_name,String old_name);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update residential r set r.product_name = ?1 where r.product_name = ?2",nativeQuery=true)
	int updateProductResidential(String new_name,String old_name);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update enterprise e set e.product_name = ?1 where e.product_name = ?2",nativeQuery=true)
	int updateProductEnterprise(String new_name,String old_name);
	
	@Query(value="select distinct provider from product",nativeQuery=true)
	List<String> getProviders();


}
