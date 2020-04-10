package com.ebanking.repository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ebanking.model.Client;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface ClientRepository extends JpaRepository<Client,Long> {


}
