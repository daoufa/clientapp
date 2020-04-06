package com.ebanking.repository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ebanking.model.Client;

@RepositoryRestResource

public interface ClientRepository extends JpaRepository<Client,Long> {


}
