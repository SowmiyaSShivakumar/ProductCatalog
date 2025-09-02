package com.catalog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Residential")
public class Residential {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	int residentialId;

	String productName;
	String rplanname;
	float rcost;
	float rdiscount;
	float rfinalPrice;
	String rdata;
	String rspeed;
	String rvalidity;
	String rpostfup;
	String rsms;
	String rwcall;
	String rsubscription;
	String rhotspot;
	String rdescription;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product")
	public Product product;

	public int getResidentialId() {
		return residentialId;
	}

	public void setResidentialId(int residentialId) {
		this.residentialId = residentialId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRplanname() {
		return rplanname;
	}

	public void setRplanname(String rplanname) {
		this.rplanname = rplanname;
	}

	public float getRcost() {
		return rcost;
	}

	public void setRcost(float rcost) {
		this.rcost = rcost;
	}

	public float getRdiscount() {
		return rdiscount;
	}

	public void setRdiscount(float rdiscount) {
		this.rdiscount = rdiscount;
	}

	public float getRfinalPrice() {
		return rfinalPrice;
	}

	public void setRfinalPrice(float rfinalPrice) {
		this.rfinalPrice = rfinalPrice;
	}

	public String getRdata() {
		return rdata;
	}

	public void setRdata(String rdata) {
		this.rdata = rdata;
	}

	public String getRspeed() {
		return rspeed;
	}

	public void setRspeed(String rspeed) {
		this.rspeed = rspeed;
	}

	public String getRvalidity() {
		return rvalidity;
	}

	public void setRvalidity(String rvalidity) {
		this.rvalidity = rvalidity;
	}

	public String getRpostfup() {
		return rpostfup;
	}

	public void setRpostfup(String rpostfup) {
		this.rpostfup = rpostfup;
	}

	public String getRsms() {
		return rsms;
	}

	public void setRsms(String rsms) {
		this.rsms = rsms;
	}

	public String getRwcall() {
		return rwcall;
	}

	public void setRwcall(String rwcall) {
		this.rwcall = rwcall;
	}

	public String getRsubscription() {
		return rsubscription;
	}

	public void setRsubscription(String rsubscription) {
		this.rsubscription = rsubscription;
	}

	public String getRhotspot() {
		return rhotspot;
	}

	public void setRhotspot(String rhotspot) {
		this.rhotspot = rhotspot;
	}

	public String getRdescription() {
		return rdescription;
	}

	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Residential(int residentialId, String productName, String rplanname, float rcost, float rdiscount,
			float rfinalPrice, String rdata, String rspeed, String rvalidity, String rpostfup, String rsms,
			String rwcall, String rsubscription, String rhotspot, String rdescription, Product product) {
		super();
		this.residentialId = residentialId;
		this.productName = productName;
		this.rplanname = rplanname;
		this.rcost = rcost;
		this.rdiscount = rdiscount;
		this.rfinalPrice = rfinalPrice;
		this.rdata = rdata;
		this.rspeed = rspeed;
		this.rvalidity = rvalidity;
		this.rpostfup = rpostfup;
		this.rsms = rsms;
		this.rwcall = rwcall;
		this.rsubscription = rsubscription;
		this.rhotspot = rhotspot;
		this.rdescription = rdescription;
		this.product = product;
	}

	public Residential() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
