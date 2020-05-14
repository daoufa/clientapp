package com.ebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ebanking.model.RechargeTelephone;
@CrossOrigin("*")
@RepositoryRestResource
public interface RechargeTelephoneRepository extends JpaRepository<RechargeTelephone, Long> {

}
