package com.catalog.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.catalog.model.Product;
import com.catalog.repo.BusinessRepo;
import com.catalog.repo.ProductRepo;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductRepo prodrepo;
	
	@Autowired
	private BusinessRepo brepo;
	
	@GetMapping("/getproduct")
	public List<Product> getProd() {
		//System.out.println("get all prods");
		List<Product> prod=prodrepo.findAll();
		//System.out.println(prod.size());
		for(int i=0;i<prod.size();i++) {
			prod.get(i).setProd_image(decompressBytes(prod.get(i).getProd_image()));
			//System.out.println(prod.get(i).getProductId());
		}
		return prod;
	}
		
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product)  {
		return prodrepo.save(product);
	}
	
	@PostMapping("/addprodimage")
	public void addProdImage(@RequestPart("image") MultipartFile image) throws IOException {
		Product product=prodrepo.findTopByOrderByProductIdDesc();
		//System.out.println("at adding image");
		System.out.println(image.getBytes());
		prodrepo.add_image(product.getProductId(),compressBytes(image.getBytes()));
	}

	@GetMapping("/get/{id}")
	public Product Product(@PathVariable("id") int id) throws IOException {
	    Product product=prodrepo.findByProductId(id);
		product.setProd_image(decompressBytes(product.getProd_image()));
		//System.out.println(product.getProd_image());
		return product;
	}
	
	@PostMapping("/updateproduct")
	public int updateProd(@RequestBody Product product) {
		//Product product=prodrepo.findByProductId(prod.getProductId());
		Product prod=prodrepo.findByProductId(product.getProductId());
	    System.out.println(prod.getProductId());
	    int a=prodrepo.updateProductBusiness(product.getProductName(),prod.getProductName());
	    //System.out.println(product.getProductName()+""+prod.getProductName()+" "+a);
	    
	    a=prodrepo.updateProductEnterprise(product.getProductName(), prod.getProductName());
	    
	    a=prodrepo.updateProductResidential(product.getProductName(), prod.getProductName());
	    
	    int res=prodrepo.updateProduct(product.getProductName(),product.getCategory(),product.getClassification(),product.getProvider(),product.getProductId());
	    System.out.println(product.getClassification());
	    	    
		return res;
	}
	
	@PostMapping("/changeimage/{id}")
	public void changeImage(@RequestPart("image") MultipartFile image,@PathVariable("id") int id ) throws IOException {
		Product product=prodrepo.findByProductId(id);
		//System.out.println("at adding image");
		prodrepo.add_image(product.getProductId(),compressBytes(image.getBytes()));
	}
	
	@GetMapping("/deleteproduct/{id}")
	public boolean deleteProduct(@PathVariable int id) {
		 prodrepo.deleteById(id);
		 return true;
	}
	
	
	@GetMapping("/getallproviders")
	public List<String> getAllProviders(){
		return prodrepo.getProviders();
	}
	
	
	
	
	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

			return outputStream.toByteArray();
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
