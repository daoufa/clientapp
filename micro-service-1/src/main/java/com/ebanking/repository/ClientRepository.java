package com.ebanking.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ebanking.model.Client;

@RepositoryRestResource
@SpringBootApplication
public interface ClientRepository extends JpaRepository<Client, Long> {

}
