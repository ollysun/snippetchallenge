package com.webspoon.coding.challange.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SnippetRequestModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2339733610568092812L;

	@NotEmpty(message = "Please provide the name")
	private String name;

	@NotNull(message = "please provide the expiring time in seconds")
	private Integer expires_in;

	private String snippet;

	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SnippetRequestModel [name=" + name + ", expires_in=" + expires_in + ", snippet=" + snippet
				+ ", password=" + password + "]";
	}

}
