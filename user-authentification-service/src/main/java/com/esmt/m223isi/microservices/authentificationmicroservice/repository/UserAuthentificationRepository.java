package com.esmt.m223isi.microservices.authentificationmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.m223isi.microservices.authentificationmicroservice.bean.UserAuthentification;

public interface UserAuthentificationRepository extends JpaRepository<UserAuthentification, Long> {

	UserAuthentification findByLoginPassword (String login, String password);
}
