package com.udemy.studentrepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.StudentTable;

@Repository
public interface StudentRepository extends JpaRepository<StudentTable, Long>{
		List<StudentTable> findByFname(String fname);
}
