package com.ebanking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	
	@Id
    @NotEmpty(message = "*Please provide a username")
    @Column(length = 50)
    private String username;
    
  
    @NotEmpty(message = "*Please provide your password")
    @Column(length = 100)
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_code", referencedColumnName = "code")
    private Client client;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_code", referencedColumnName = "code")
    private Agent agent;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;
    
    private Boolean active;
    
    
    @ManyToMany
    @JoinTable(
    		joinColumns = @JoinColumn(name = "username"), 
    		inverseJoinColumns = @JoinColumn(name = "role"))
    private List<Role> roles;
    
    public void addRole(Role role1) {
		if (roles == null) {
			roles = new ArrayList<>();
		}
		roles.add(role1);

	}
    
    public Long getClientCode() {
    	if (this.client!=null)
    	return this.client.getCode();
    	return null;
    }
    public Long getAdminId() {
    	if (this.admin!=null)
    	return this.admin.getId();
    	return null;
    }
    public Long getAgentCode() {
    	if (this.agent!=null)
    	return this.agent.getCode();
    	return null;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	//@JsonIgnore
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
