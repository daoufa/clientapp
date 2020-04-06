package com.ebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ebanking.model.Operation;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation, Long>{

}
