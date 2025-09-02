package com.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.model.Business;
import com.catalog.model.Product;

@Repository
public interface BusinessRepo extends JpaRepository<Business,Integer> {
	
	Business findByBplanName(String bplanName);
	Business findByBusinessId(int businessId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Business b set b.bplan_name = ?2, b.bcost= ?3 , b.bdiscount=?4 ,b.bfinal_price=?5 ,"
			+ "b.bdata=?6 ,b.bspeed=?7 ,b.bupload=?8 ,b.bdwonload=?9, b.bvoice=?10, b.bparallel=?11,b.bvideo=?12,b.b_static_ip=?13,"
			+ "b.b_license=?14, b.bdescription=?15, b.bhotspot=?16  where b.business_id = ?1",nativeQuery=true)
	int updateBusiness(int businessId,String bplanName,
			float bcost,
			float bdiscount,
			float bfinalPrice,
			String bdata,
			String bspeed,
			String bupload,
			String bdwonload,
			String bvoice,
			String bparallel,
			String bvideo,
			int bStaticIp,
			int bLicense,
			String bdescription,	
			String bhotspot);
	
}
