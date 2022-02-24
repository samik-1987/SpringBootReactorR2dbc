package com.example.security.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.example.security.config.StudentConfig;
import com.example.security.controller.TestController;
import com.example.security.entity.Student;
import com.example.security.repository.StudentRepository;

@Service
@ComponentScan(basePackageClasses = {StudentRepository.class})
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentService() {
    }

    public Flux<Student> findStudentsByName(String name) {
        return (name != null) ? studentRepository.findByName(name).delayElements(Duration.ofSeconds(5)) : studentRepository.findAll().delayElements(Duration.ofSeconds(5));
    }

    public Mono<Student> findStudentById(long id) {
        return studentRepository.findById(id);
    }

    
    public Mono<Student> addNewStudent(Student student) {
    	try
    	{
           return studentRepository.save(student);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		return Mono.just(student);
		}
    }

  
    public Mono<Student> updateStudent(long id, Student student) {
        return studentRepository.findById(id)
                .flatMap(s -> {
                    student.setId(s.getId());
                    return studentRepository.save(student);
                });

    }

    public Mono<Void> deleteStudent(Student student) {
        return studentRepository.delete(student);
    }

}