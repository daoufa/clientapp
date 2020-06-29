package com.ebanking.config;

import org.springframework.stereotype.Component;

@Component
public class Authentication {
	private boolean isAuthenticated;

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

}
