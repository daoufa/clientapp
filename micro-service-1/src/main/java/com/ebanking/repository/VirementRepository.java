package com.ebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ebanking.model.Virement;
@CrossOrigin("*")
@RepositoryRestResource
public interface VirementRepository extends JpaRepository<Virement, Long> {

}
