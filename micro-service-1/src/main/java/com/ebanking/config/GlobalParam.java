package com.ebanking.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class GlobalParam {
	
	private double decouvert = 0.3;
	private double tauxInterets = 0.1;
	
	public double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	public double getTauxInterets() {
		return tauxInterets;
	}
	public void setTauxInterets(double tauxInterets) {
		this.tauxInterets = tauxInterets;
	}
	
}
