package com.spring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Student;
@Repository
public interface SRepository extends CrudRepository<Student, Integer>
{

}
