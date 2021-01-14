package com.webspoon.coding.challange.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Snippet {
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "GMT+1")
	private Timestamp expires_at;

	private String snippetString;

	private String url;

	private String password;

	public Snippet() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getExpires_at() {
		return expires_at;
	}

	public void setExpires_at(Timestamp expires_at) {
		this.expires_at = expires_at;
	}

	public String getSnippetString() {
		return snippetString;
	}

	public void setSnippetString(String snippetString) {
		this.snippetString = snippetString;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Snippet [name=" + name + ", expires_at=" + expires_at + ", snippetString=" + snippetString + ", url="
				+ url + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}