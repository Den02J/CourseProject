package com.example.courseproject.repository;

/*
 * Created by IntelliJ IDEA.
 * Class: ISpecialtyMongoRepository
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Specialty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.security.auth.Subject;

@Repository
public interface ISpecialtyMongoRepository extends MongoRepository<Specialty, String> {
}
