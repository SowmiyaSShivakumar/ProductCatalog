package com.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.catalog.model.Enterprise;
import com.catalog.model.Residential;

public interface ResidentialRepo extends JpaRepository<Residential,Integer> {
	
	Residential findByResidentialId(int residentialId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update residential r set r.rplanname = ?2 , r.rcost=?3, r.rdiscount=?4, r.rfinal_price=?5,"
			+ "r.rdata=?6, r.rspeed=?7 , r.rvalidity=?8, r.rpostfup=?9, r.rsms=?10, r.rwcall=?11, r.rsubscription=?12,"
			+ "r.rhotspot=?13, r.rdescription=?14 where r.residential_id= ?1 ",nativeQuery=true)
	int updateResidential(int residentialId,
			String rplanname,
			float rcost,
			float rdiscount,
			float rfinalPrice,
			String rdata,
			String rspeed,
			String rvalidity,
			String rpostfup,
			String rsms,
			String rwcall,
			String rsubscription,
			String rhotspot,
			String rdescription);

}
