package com.ebanking.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ebanking.model.*;
import java.lang.String;
import com.ebanking.model.Compte;
import com.ebanking.model.Client;

@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "http://localhost:4200")
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
	

 List<Compte> findByClient(Client client);

}
