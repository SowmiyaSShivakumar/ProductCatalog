package com.catalog.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Business")
public class Business {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	int businessId;
	
	String productName;
	String bplanName;
	float bcost;
	float bdiscount;
	float bfinalPrice;
	String bdata;
	String bspeed;
	String bupload;
	String bdwonload;
	String bvoice;
	String bparallel;
	String bvideo;
	int bStaticIp;
	int bLicense;
	String bdescription;	
	String bhotspot;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product")
	public Product product;
	
	public Business(int businessId, String productName, String bplanName, float bcost, float bdiscount,
			float bfinalPrice, String bdata, String bspeed, String bupload, String bdwonload, String bvoice,
			String bparallel, String bvideo, int bStaticIp, int bLicense, String bdescription, String bhotspot,
			Product product) {
		super();
		this.businessId = businessId;
		this.productName = productName;
		this.bplanName = bplanName;
		this.bcost = bcost;
		this.bdiscount = bdiscount;
		this.bfinalPrice = bfinalPrice;
		this.bdata = bdata;
		this.bspeed = bspeed;
		this.bupload = bupload;
		this.bdwonload = bdwonload;
		this.bvoice = bvoice;
		this.bparallel = bparallel;
		this.bvideo = bvideo;
		this.bStaticIp = bStaticIp;
		this.bLicense = bLicense;
		this.bdescription = bdescription;
		this.bhotspot = bhotspot;
		this.product = product;
	}

	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", productName=" + productName + ", bplanName=" + bplanName
				+ ", bcost=" + bcost + ", bdiscount=" + bdiscount + ", bfinalPrice=" + bfinalPrice + ", bdata=" + bdata
				+ ", bspeed=" + bspeed + ", bupload=" + bupload + ", bdwonload=" + bdwonload + ", bvoice=" + bvoice
				+ ", bparallel=" + bparallel + ", bvideo=" + bvideo + ", bStaticIp=" + bStaticIp + ", bLicense="
				+ bLicense + ", bdescription=" + bdescription + ", bhotspot=" + bhotspot + ", product=" + product + "]";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBplanName() {
		return bplanName;
	}

	public void setBplanName(String bplanName) {
		this.bplanName = bplanName;
	}

	public float getBcost() {
		return bcost;
	}

	public void setBcost(float bcost) {
		this.bcost = bcost;
	}

	public float getBdiscount() {
		return bdiscount;
	}

	public void setBdiscount(float bdiscount) {
		this.bdiscount = bdiscount;
	}

	public float getBfinalPrice() {
		return bfinalPrice;
	}

	public void setBfinalPrice(float bfinalPrice) {
		this.bfinalPrice = bfinalPrice;
	}

	public String getBdata() {
		return bdata;
	}

	public void setBdata(String bdata) {
		this.bdata = bdata;
	}

	public String getBspeed() {
		return bspeed;
	}

	public void setBspeed(String bspeed) {
		this.bspeed = bspeed;
	}

	public String getBupload() {
		return bupload;
	}

	public void setBupload(String bupload) {
		this.bupload = bupload;
	}

	public String getBdwonload() {
		return bdwonload;
	}

	public void setBdwonload(String bdwonload) {
		this.bdwonload = bdwonload;
	}

	public String getBvoice() {
		return bvoice;
	}

	public void setBvoice(String bvoice) {
		this.bvoice = bvoice;
	}

	public String getBparallel() {
		return bparallel;
	}

	public void setBparallel(String bparallel) {
		this.bparallel = bparallel;
	}

	public String getBvideo() {
		return bvideo;
	}

	public void setBvideo(String bvideo) {
		this.bvideo = bvideo;
	}

	public int getbStaticIp() {
		return bStaticIp;
	}

	public void setbStaticIp(int bStaticIp) {
		this.bStaticIp = bStaticIp;
	}

	public int getbLicense() {
		return bLicense;
	}

	public void setbLicense(int bLicense) {
		this.bLicense = bLicense;
	}

	public String getBdescription() {
		return bdescription;
	}

	public void setBdescription(String bdescription) {
		this.bdescription = bdescription;
	}

	public String getBhotspot() {
		return bhotspot;
	}

	public void setBhotspot(String bhotspot) {
		this.bhotspot = bhotspot;
	}
	
	

	public Business(int businessId, String productName, String bplanName, float bcost, float bdiscount,
			float bfinalPrice, String bdata, String bspeed, String bupload, String bdwonload, String bvoice,
			String bparallel, String bvideo, int bStaticIp, int bLicense, String bdescription, String bhotspot) {
		super();
		this.businessId = businessId;
		this.productName = productName;
		this.bplanName = bplanName;
		this.bcost = bcost;
		this.bdiscount = bdiscount;
		this.bfinalPrice = bfinalPrice;
		this.bdata = bdata;
		this.bspeed = bspeed;
		this.bupload = bupload;
		this.bdwonload = bdwonload;
		this.bvoice = bvoice;
		this.bparallel = bparallel;
		this.bvideo = bvideo;
		this.bStaticIp = bStaticIp;
		this.bLicense = bLicense;
		this.bdescription = bdescription;
		this.bhotspot = bhotspot;
	}

	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	

	
	
	
	

}
