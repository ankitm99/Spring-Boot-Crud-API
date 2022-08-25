package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.entity.StudentTable;
import com.udemy.request.CreateStudentRequest;
import com.udemy.request.UpdateStudentRequest;
import com.udemy.service.StudentService;
import com.udemy.studentResponse.StudentResponse;


@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getAll")
	public List<StudentResponse> getAllStudents() {
		List<StudentTable> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponsesList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student->{
			studentResponsesList.add(new StudentResponse(student));
		});
		System.out.println(studentResponsesList);
		return studentResponsesList;
	}
	
	@PostMapping("/create")
	public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
		StudentTable student = studentService.createStudent(createStudentRequest);
		return new StudentResponse(student);
	}
	
	@PutMapping("/update")
	public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		StudentTable student = studentService.updateStudent(updateStudentRequest);
		return new StudentResponse(student);
	}
	
	@DeleteMapping("delete")
	public String deleteStudent(@RequestParam long id) {
		return studentService.deleteStudent(id);
	}
	//we used @RequestBody annotation here so that we can convert json into model class
	
	/*
	 * @Value("${app.name}") private String appnamel;
	 * 
	 * @GetMapping("/get") public StudentResponse getStudent() { StudentResponse
	 * studentResponse = new StudentResponse(1, "ankit", "milmile","pass@123");
	 * return studentResponse; }
	 */
}
