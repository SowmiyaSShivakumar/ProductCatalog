package com.catalog.controller;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.model.User;
import com.catalog.repo.UserRepo;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}") private String sender;
	
	//get all users
	@GetMapping("/getusers")
	public List<User> getAllUsers()
	{
		return userrepo.findAll();
	}
	
	//////////// SIGNUP USER ///////////
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/signup")
	public User createUser(@RequestBody User user) 
	{
		return userrepo.save(user);
	}	
	
	//////////// LOGIN USER  ///////////////
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User userdata){
		User user=userrepo.findByMailid(userdata.getMailid());
		System.out.println(user);
		if(user==null) {
			return ResponseEntity.ok(user);
		}else {
		if(user.getPassword().equals(userdata.getPassword())) {
			return ResponseEntity.ok(user);
		}
		return (ResponseEntity<User>) ResponseEntity.internalServerError();}
	}
	
//	@GetMapping("/users/{id}")
//	public ResponseEntity<User> getUser(@PathVariable int id){
//		User user=userrepo.findById(id).orElseThrow();
//		return ResponseEntity.ok(user);
//	}
//	@GetMapping("/uname/{name}")
//	public ResponseEntity<User> getUser(@PathVariable String name)
//	{
//		User user=userrepo.findByName(name);
//		return ResponseEntity.ok(user);
//	}
	
//(required=false,name="views")	
	
	////***********  Send otp mail for admin  login   **************//
	@GetMapping("/generateOTP/{adminmail}")
	public String sendMail(@PathVariable String adminmail)
	{                                                              
		try {		 
	        // Creating a simple mail message
	        SimpleMailMessage mailMessage = new SimpleMailMessage();

	        String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));
	        // Setting up necessary details
	        mailMessage.setFrom(sender);
	        mailMessage.setTo(adminmail);
	        mailMessage.setText("Your otp for admin login is : "+otp);
	        mailMessage.setSubject("Admin Login OTP");

	        // Sending the mail
	        javaMailSender.send(mailMessage);
	        System.out.println("Mail sent successfully"+otp);
	        return otp;
	    }

	    // Catch block to handle the exceptions
	    catch (Exception e) {
	        return "Error while Sending Mail";
	    }
		
	}
}

