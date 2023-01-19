package com.esmt.m223isi.microservices.authentificationmicroservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.esmt.m223isi.microservices.authentificationmicroservice.bean.UserAuthentification;
import com.esmt.m223isi.microservices.authentificationmicroservice.repository.UserAuthentificationRepository;



@RestController
public class UserAuthentificationController {
	
	@Autowired
	UserAuthentificationRepository repository;
	
	
	@GetMapping("/user-authentification/login/{login}/password/{password}")
	public UserAuthentification getUserAuth ( 
			@PathVariable String login, @PathVariable String password) {
		
		UserAuthentification userAuth = repository.findByLoginPassword(login, password);
		if(userAuth==null)
			throw new RuntimeException ("Utilisateur non trouvé pour"+login+"->"+password);
		return userAuth;
	}
		
			
	
}
