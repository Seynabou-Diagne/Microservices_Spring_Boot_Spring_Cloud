package com.app.springmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springmicroservice.bean.AdminCredential;
import com.app.springmicroservice.configuration.Configuration;

@RestController
public class AdminCredentialController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/admincredential")
	public  AdminCredential getAdminCredential() {
		return new  AdminCredential(configuration.getLogin(),configuration.getPassword());
		//return new  AdminCredential("admin","@bwin");

	}
}
