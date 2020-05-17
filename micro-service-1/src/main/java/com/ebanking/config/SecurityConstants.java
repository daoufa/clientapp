package com.ebanking.config;

public class SecurityConstants {
	
	public static final String SECRET="monSecret8250";
	public static final long EXPIRATION_TIME=864_000_000;//10 jours
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING="Authorization";//nom dum heade dans le quel on pass le token
}
