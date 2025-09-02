package com.catalog.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.model.Business;
import com.catalog.model.Enterprise;
import com.catalog.model.Product;
import com.catalog.model.Residential;
import com.catalog.repo.BusinessRepo;
import com.catalog.repo.EnterpriseRepo;
import com.catalog.repo.ResidentialRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlanController {

	@Autowired
	private BusinessRepo brepo;
	
	@Autowired
	private EnterpriseRepo erepo;
	
	@Autowired
	private ResidentialRepo rrepo;
	
	@GetMapping("/getallbusiness")
	public List<Business> getBusiness() {
		List<Business> buss=brepo.findAll();
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<buss.size();i++) {
			if(!a.contains(buss.get(i).getProduct().getProductId())) {
			//prod.get(i).setProd_image(decompressBytes(prod.get(i).getProd_image()));
			buss.get(i).getProduct().setProd_image(decompressBytes(buss.get(i).getProduct().getProd_image()));
			a.add(buss.get(i).getProduct().getProductId());
		}}
		return buss;
	}
	
	@PostMapping("/addbusiness")
	public Business addBusiness(@RequestBody Business business) {
		return brepo.save(business);
	}
	
	@PostMapping("/updatebusiness")
	public int updateBusiness(@RequestBody Business b) {
		return brepo.updateBusiness(b.getBusinessId(),b.getBplanName(), b.getBcost(), b.getBdiscount(),b.getBfinalPrice(),b.getBdata(),b.getBspeed(),b.getBupload(),b.getBdwonload(), b.getBvoice(), b.getBparallel(),b.getBvideo(),b.getbStaticIp(),b.getbLicense(), b.getBdescription(), b.getBhotspot());
	}
	
	/*  b.businessId,b.bplanName, b.bcost, b.bdiscount,b.bfinalPrice,b.bdata,b.bspeed,b.bupload,b.bdownload, b.bvoice, b.bparallel,b.bvideo,b.bStaticIp,b.bLicense, b.bdescription, b.bhotspot
	 */
	
	@GetMapping("/deletebusiness/{id}")
	public boolean deleteBusiness(@PathVariable int id) {
		 brepo.deleteById(id);
		 return true;
	}
	
	@GetMapping("/getbusinessbyid/{id}")
	public Business getBusinessById(@PathVariable int id) {
	    Business buss = brepo.findByBusinessId(id);
	    if(buss != null)
	    buss.getProduct().setProd_image(decompressBytes(buss.getProduct().getProd_image()));
	    return buss;
	}
	
	//////////////////////////////////  ENTERPRISE CONTROLLER   //////////////////////////////////////////////////
	
	@GetMapping("/getallenterprise")
	public List<Enterprise> getAllEnterprise() {
		List<Enterprise> ent=erepo.findAll();
		ArrayList<Integer> a=new ArrayList<>();
		for(Enterprise e:ent) {	
			if(!a.contains(e.getProduct().getProductId())) {
			e.getProduct().setProd_image(decompressBytes(e.getProduct().getProd_image()));
			a.add(e.getProduct().getProductId());
			}
			System.out.println(a);
		}
		System.out.println(a);
//		for(int i=0;i<ent.size();i++) {
////			if(ent.get(i).getProduct().getProd_image() == null)
//			ent.get(i).getProduct().setProd_image(decompressBytes(ent.get(i).getProduct().getProd_image()));
//		}
		return ent;
	}
	
	@PostMapping("/addenterprise")
	public Enterprise addEnterprise(@RequestBody Enterprise enterprise) {
		System.out.println(enterprise.getEplanname());
		return erepo.save(enterprise);
	}
	
	@PostMapping("/updateenterprise")
	public int updateEnterprise(@RequestBody Enterprise e) {
		return erepo.updateEnterprise(e.getEnterpriseId(),e.getEplanname(),e.getEcost(),e.getEdiscount(),e.getEfinalPrice(),
				e.getEdata(),e.getEspeed(),e.getEvideo(),e.getEfilesharing(),e.getEcloud(),e.getEvoip(),e.getEfrequency(),
				e.getEisolation(),e.getEroaming(),e.getEdescription());
		
		/*e.enterpriseId,eplanname,e.ecost,e.ediscount,e.efinalprice,e.edata,
		 *  e.espeed,e.evideo, e.efilesharing, e.ecloud, e.evoip , e.efrequency, e.eisolation, e.eroaming,e.edescription*/
	}
	
	@GetMapping("/deleteenterprise/{id}")
	public boolean deleteEnterprise(@PathVariable int id) {
		 erepo.deleteById(id);
		 return true;
	}
	
	@GetMapping("/getenterprisebyid/{id}")
	public Enterprise getEnterpriseById(@PathVariable int id) {
	    Enterprise ent = erepo.findByEnterpriseId(id);
	    if(ent != null)
	    ent.getProduct().setProd_image(decompressBytes(ent.getProduct().getProd_image()));
	    return ent;
	}
	
	////////////////////////////    RESIDENTIAL CONTROLLER /////////////////////////
	
	@GetMapping("/getallresidential")
	public List<Residential> getResidential() {
		List<Residential> res=rrepo.findAll();
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<res.size();i++) {
			if(!a.contains(res.get(i).getProduct().getProductId()))
			res.get(i).getProduct().setProd_image(decompressBytes(res.get(i).getProduct().getProd_image()));
			a.add(res.get(i).getProduct().getProductId());
		}
		return res;
	}
	
	@PostMapping("/addresidential")
	public Residential addResidential(@RequestBody Residential res) {
		return rrepo.save(res);
	}
	
	@PostMapping("/updateresidential")
	public int updateResidential(@RequestBody Residential r) {
		return rrepo.updateResidential(r.getResidentialId(),r.getRplanname(),r.getRcost(),r.getRdiscount(),r.getRfinalPrice(),
				r.getRdata(),r.getRspeed(),r.getRvalidity(),r.getRpostfup(),r.getRsms(),r.getRwcall(),r.getRsubscription(),
				r.getRhotspot(),r.getRdescription());
		
		/*residentialId, rplanname,rcost,rdiscount,rfinalPrice,rdata,rspeed,rvalidity, 
		 * rpostfup, rsms, rwcall, rsubscription, rhotspot, rdescription*/
	}
	
	@GetMapping("/deleteresidential/{id}")
	public boolean deleteResidential(@PathVariable int id) {
		 rrepo.deleteById(id);
		 return true;
	}
	
	@GetMapping("/getresidentialbyid/{id}")
	public Residential getResidentialById(@PathVariable int id) {
	    Residential res = rrepo.findByResidentialId(id);
	    if(res != null)
	    res.getProduct().setProd_image(decompressBytes(res.getProduct().getProd_image()));
	    return res;
	}
	
	
	
	

	
	
	
	
	// uncompress the image bytes before returning it to the angular application
			public static byte[] decompressBytes(byte[] data) {
				Inflater inflater = new Inflater();
				inflater.setInput(data);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				try {
					while (!inflater.finished()) {
						int count = inflater.inflate(buffer);
						outputStream.write(buffer, 0, count);
					}
					outputStream.close();
				} catch (IOException ioe) {
				} catch (DataFormatException e) {
				}
				return outputStream.toByteArray();
			}
	
}
