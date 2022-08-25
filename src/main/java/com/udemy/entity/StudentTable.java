package com.udemy.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.udemy.request.CreateStudentRequest;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data 
@Entity
@Table(name="student_table")
public class StudentTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotNull(message="id cannot be null")
	private Long id;
	@Size(min = 2, max = 200, message 
		      = "About Me must be between 10 and 200 characters")
	private String fname;
	private String lname;
	 @Email(message = "Email should be valid")
	private String email;
	
	public StudentTable (CreateStudentRequest createStudentRequest) {
		this.fname = createStudentRequest.getFname();
		this.lname = createStudentRequest.getLname();
		this.email = createStudentRequest.getEmail();
	}
	
}
