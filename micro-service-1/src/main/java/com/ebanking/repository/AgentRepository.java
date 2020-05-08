package com.ebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ebanking.model.Agent;


//n'a pas le meme port que client....
@RepositoryRestResource
@CrossOrigin("http://localhost:4201") 
public interface AgentRepository extends JpaRepository<Agent, Long> {

}
