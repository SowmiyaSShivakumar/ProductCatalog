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
@Table(name="Enterprise")
public class Enterprise {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	int enterpriseId;

	String productName;
	String eplanname;
	float ecost;
	float ediscount;
	float efinalPrice;
	String edata;
	String espeed;
	String evideo;
	String efilesharing;
	String ecloud;
	String evoip;
	String efrequency;
	String eisolation;
	String eroaming;
	String edescription;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product")
	public Product product;

	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getEplanname() {
		return eplanname;
	}

	public void setEplanname(String eplanname) {
		this.eplanname = eplanname;
	}

	public float getEcost() {
		return ecost;
	}

	public void setEcost(float ecost) {
		this.ecost = ecost;
	}

	public float getEdiscount() {
		return ediscount;
	}

	public void setEdiscount(float ediscount) {
		this.ediscount = ediscount;
	}

	public float getEfinalPrice() {
		return efinalPrice;
	}

	public void setEfinalPrice(float efinalprice) {
		this.efinalPrice = efinalprice;
	}

	public String getEdata() {
		return edata;
	}

	public void setEdata(String edata) {
		this.edata = edata;
	}

	public String getEspeed() {
		return espeed;
	}

	public void setEspeed(String espeed) {
		this.espeed = espeed;
	}

	public String getEvideo() {
		return evideo;
	}

	public void setEvideo(String evideo) {
		this.evideo = evideo;
	}

	public String getEfilesharing() {
		return efilesharing;
	}

	public void setEfilesharing(String efilesharing) {
		this.efilesharing = efilesharing;
	}

	public String getEcloud() {
		return ecloud;
	}

	public void setEcloud(String ecloud) {
		this.ecloud = ecloud;
	}

	public String getEvoip() {
		return evoip;
	}

	public void setEvoip(String evoip) {
		this.evoip = evoip;
	}

	public String getEfrequency() {
		return efrequency;
	}

	public void setEfrequency(String efrequency) {
		this.efrequency = efrequency;
	}

	public String getEisolation() {
		return eisolation;
	}

	public void setEisolation(String eisolation) {
		this.eisolation = eisolation;
	}

	public String getEroaming() {
		return eroaming;
	}

	public void setEroaming(String eroaming) {
		this.eroaming = eroaming;
	}

	public String getEdescription() {
		return edescription;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Enterprise(int enterpriseId, String productName, String eplanname, float ecost, float ediscount,
			float efinalPrice, String edata, String espeed, String evideo, String efilesharing, String ecloud,
			String evoip, String efrequency, String eisolation, String eroaming, String edescription, Product product) {
		super();
		this.enterpriseId = enterpriseId;
		this.productName = productName;
		this.eplanname = eplanname;
		this.ecost = ecost;
		this.ediscount = ediscount;
		this.efinalPrice = efinalPrice;
		this.edata = edata;
		this.espeed = espeed;
		this.evideo = evideo;
		this.efilesharing = efilesharing;
		this.ecloud = ecloud;
		this.evoip = evoip;
		this.efrequency = efrequency;
		this.eisolation = eisolation;
		this.eroaming = eroaming;
		this.edescription = edescription;
		this.product = product;
	}

	public Enterprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
