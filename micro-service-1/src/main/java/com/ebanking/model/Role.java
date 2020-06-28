package com.ebanking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonGetter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
	
    @Id
    @Column(length = 50)
    private String role;
    
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
    
    public List<User> getUsers(){
    	return null;
    }
    
}