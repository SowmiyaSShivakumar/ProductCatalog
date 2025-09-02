package com.catalog.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
public class Product {

 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 int productId;
 String productName;
 String category;
 String classification;
 String provider;
 int rating;
 
 @Column(name = "prod_image", length = 100000000)
 @Lob
 public byte[] prod_image;

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getClassification() {
	return classification;
}

public void setClassification(String classification) {
	this.classification = classification;
}

public String getProvider() {
	return provider;
}

public void setProvider(String provider) {
	this.provider = provider;
}

public byte[] getProd_image() {
	return prod_image;
}

public void setProd_image(byte[] prod_image) {
	this.prod_image = prod_image;
}

public int getRating() {
	return rating;
}

public void setRating(int rating) {
	this.rating = rating;
}

public Product(int productId, String productName, String category, String classification, String provider,
		byte[] prod_image) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.category = category;
	this.classification = classification;
	this.provider = provider;
	this.prod_image = prod_image;
}

public Product() {
	super();
	// TODO Auto-generated constructor stub
}
 
 




 
 
	
 
	
}
