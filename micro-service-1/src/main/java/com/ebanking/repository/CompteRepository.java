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

@CrossOrigin("*")
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
	

 List<Compte> findByClient(Client client);
 List<Compte> findByIsEpargne(boolean isEpargne);
 Compte findByNumCompteAndIsEpargne(Long numCompte,boolean isEpargne);

}
