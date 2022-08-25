package com.udemy.request;

import lombok.Data;

@Data
public class CreateStudentRequest {
	private String fname;
	private String lname;
	private String email;
}
