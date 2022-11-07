package com.example.courseproject.repository;

/*
 * Created by IntelliJ IDEA.
 * Class: IExaminerMongoRepository
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Examiner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExaminerMongoRepository extends MongoRepository<Examiner, String> {
    Page<Examiner> findAll(Pageable pageable);
}
