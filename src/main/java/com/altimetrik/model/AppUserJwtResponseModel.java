package com.altimetrik.model;

import java.io.Serializable;

public class AppUserJwtResponseModel implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public AppUserJwtResponseModel(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}