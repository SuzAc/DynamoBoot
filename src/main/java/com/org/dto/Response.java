package com.org.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response implements Serializable {

	private static final long serialVersionUID = 8526747595651537720L;

	private String message;

	private Movie data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Movie getData() {
		return data;
	}

	public void setData(Movie data) {
		this.data = data;
	}

}
