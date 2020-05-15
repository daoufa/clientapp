package com.ebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ebanking.model.Compte;
import com.ebanking.model.RechargeTelephone;
@CrossOrigin("*")
@RepositoryRestResource
public interface RechargeTelephoneRepository extends JpaRepository<RechargeTelephone, Long> {
	
	List<RechargeTelephone> findByCompte( Compte c);
}
