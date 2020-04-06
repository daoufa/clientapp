package com.ebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ebanking.model.Compte;

@RepositoryRestResource
public interface CompteRepository extends 
					JpaRepository<Compte, Long> {

}
