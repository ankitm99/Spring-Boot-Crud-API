package com.udemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.entity.StudentTable;
import com.udemy.request.CreateStudentRequest;
import com.udemy.request.UpdateStudentRequest;
import com.udemy.studentrepository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public List<StudentTable> getAllStudents() {
		return studentRepository.findAll();
	}

	public StudentTable createStudent(CreateStudentRequest createStudentRequest) {
		StudentTable student = new StudentTable(createStudentRequest);
		
		student = studentRepository.save(student);
		return student;
		
	}
	
	public StudentTable updateStudent(UpdateStudentRequest updateStudentRequest) {
		StudentTable student = studentRepository.findById(updateStudentRequest.getId()).get();
		
		if(updateStudentRequest.getFname()!=null && !updateStudentRequest.getFname().isEmpty()) {
			student.setFname(updateStudentRequest.getFname());
		}
		student = studentRepository.save(student);
		return student;
	}
	
	public String deleteStudent(long id) {
		studentRepository.deleteById(id);
		return "Student has been deleted successfully";
	}
	
}
