package com.ebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ebanking.model.Agence;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200") 
public interface AgenceRepository extends JpaRepository<Agence, Long>{

}
