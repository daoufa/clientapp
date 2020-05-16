package com.ebanking.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ebanking.model.Client;

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
	
	@RestResource(path="/byNom")
	public List<Client> findByNomContaining(@Param("mc") String clt);
	
	@RestResource(path="/byNomPage")
	public Page<Client> findByNomContaining(@Param("mc") String clt,Pageable pageable);

}
