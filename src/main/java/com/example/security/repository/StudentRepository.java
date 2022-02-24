package com.example.security.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.security.entity.Student;

import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

    public Flux<Student> findByName(String name);

}
