package com.example.courseproject.repository;

/*
 * Created by IntelliJ IDEA.
 * Class: IStudentMongoRepository
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentMongoRepository extends MongoRepository<Student, String> {

    Page<Student> findAll(Pageable pageable);

}
