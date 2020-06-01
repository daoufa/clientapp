package com.ebanking.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public List<RechargeTelephone> findByCompte( Compte c);
	public Page<RechargeTelephone> findByCompte( Compte c,Pageable pageable);
	
	/*@RestResource(path="/byNumero")
	public List<RechargeTelephone> findByNumeroContaining(@Param("num") Long num);
	@RestResource(path="/byNumeroPage")
	public Page<RechargeTelephone> findByNumeroContaining(@Param("num") Long num,Pageable pageable);*/
	
	
}
