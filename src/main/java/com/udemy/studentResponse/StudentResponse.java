package com.udemy.studentResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.udemy.entity.StudentTable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data //it is equivalent to @Getter @Setter @ToString @EqualsAndHashCode

public class StudentResponse {
	

	private Long id;
	//@JsonProperty("first_name")
	private String fname;
	private String lname;
	//@JsonIgnore
	private String email;
	public StudentResponse(StudentTable student) {
		super();
		this.id = student.getId();
		this.fname = student.getFname();
		this.lname = student.getLname();
		this.email = student.getEmail();
	}
	
	
	
}
