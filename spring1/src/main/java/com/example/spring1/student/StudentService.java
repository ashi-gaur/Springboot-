package com.example.spring1.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import jakarta.transaction.Transactional;


@Service
@Component
public class StudentService {

	private final StudentRepository studentRepository;
	@Autowired
    public StudentService(StudentRepository studentRepository){
		this.studentRepository=studentRepository;
	}

    public List<Student> getStudents() {
        return studentRepository.findAll();
		
    }

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional =studentRepository.findByEmail(student.getEmail());
		if(studentOptional.isPresent()){
			throw new IllegalStateException("emial taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists=studentRepository.existsById(studentId);
		if(!exists){
			throw new IllegalStateException("student with ID"+studentId+"does not ecists");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
    public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("not exists"));
		if(name!=null && !Objects.equals(student.getName(), name)){
			student.setName(name);
		}
		if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(), email)){
			throw new IllegalStateException("email taken");
	
		}
		student.setEmail(email);
	}
	

}
