package com.example.firsth2.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.firsth2.model.Student;
import com.example.firsth2.service.StudentService;  
//creating RestController  
@RestController  
@RequestMapping("/")
public class StudentController   
{  
//autowired the StudentService class  
@Autowired 

StudentService studentService;  

public StudentController(StudentService studentService) {
	this.studentService = studentService;
	}

//creating a get mapping that retrieves all the students detail from the database
@GetMapping("/")  
private List<Student> getAllStudent()   
{  
return studentService.getAllStudent();  
}  

//creating a get mapping that retrieves the detail of a specific student  
@GetMapping("/student/{id}")  
private Student getStudent(@PathVariable("id") int id)   
{  
return studentService.getStudentById(id);  
}  
//creating a delete mapping that deletes a specific student  
@DeleteMapping("/student/{id}")  
private void deleteStudent(@PathVariable("id") int id)   
{  
studentService.delete(id);  
}  
//creating post mapping that post the student detail in the database  
@PostMapping("/student")  
private int saveStudent(@RequestBody Student student)   
{  
studentService.saveOrUpdate(student);  
return student.getId();  
}  

private void displayStudent(@RequestBody Student student) {
	System.out.println(studentService.getAllStudent());
}
}  