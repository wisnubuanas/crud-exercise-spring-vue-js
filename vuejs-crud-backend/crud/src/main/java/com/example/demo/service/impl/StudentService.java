package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.insertStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.getAllStudent();
	}

	@Override
	public Student updateStudent(int id, Student student) {
		// TODO Auto-generated method stub
		return studentRepository.updateStudent(id, student);
	}

	@Override
	public Student deleteStudent(int id) {
		// TODO Auto-generated method stub
		return studentRepository.deleteStudent(id);
	}

	@Override
	public Student updateGetId(int id) {
		// TODO Auto-generated method stub
		return studentRepository.updateGetId(id);
	}

}
