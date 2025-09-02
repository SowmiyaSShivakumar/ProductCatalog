package com.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.catalog.model.Business;
import com.catalog.model.Enterprise;

@Repository
public interface EnterpriseRepo extends JpaRepository<Enterprise,Integer>{

	Enterprise findByEnterpriseId(int enterpriseId);
	

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update enterprise e set e.eplanname=?2 , e.ecost=?3 ,e.ediscount=?4 ,e.efinal_price=?5 ,e.edata=?6 , e.espeed=?7 ,"
			+ "e.evideo=?8 , e.efilesharing=?9 , e.ecloud=?10 , e.evoip=?11 , e.efrequency=?12 , e.eisolation=?13, e.eroaming=?14,"
			+ "e.edescription=?15 where e.enterprise_id=?1 ",nativeQuery=true)
	int updateEnterprise(int enterpriseId,String eplanname,
	float ecost,
	float ediscount,
	float efinalprice,
	String edata,
	String espeed,
	String evideo,
	String efilesharing,
	String ecloud,
	String evoip,
	String efrequency,
	String eisolation,
	String eroaming,
	String edescription);
}
