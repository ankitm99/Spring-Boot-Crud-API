package com.udemy.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateStudentRequest {
	@NotNull
	private Long id;
	private String fname;
	private String lname;
	private String email;
	
}
