package com.webspoon.coding.challange.model.request;

public class SnippetUpdateModel {

	private String snippet;

	private String password;

	private Integer expires_In;

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

	public Integer getExpires_In() {
		return expires_In;
	}

	public void setExpires_In(Integer expires_In) {
		this.expires_In = expires_In;
	}

	@Override
	public String toString() {
		return "SnippetUpdateModel [snippet=" + snippet + ", password=" + password + ", expires_In=" + expires_In + "]";
	}

}
