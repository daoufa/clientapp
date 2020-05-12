package com.ebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ebanking.model.Compte;
import com.ebanking.model.Operation;

@CrossOrigin("*")
@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation, Long>{


	 List<Operation> findByIsVirement(boolean isVirement);
	Operation findByNumeroAndIsVirement(Long numero,boolean isVirement);
}
