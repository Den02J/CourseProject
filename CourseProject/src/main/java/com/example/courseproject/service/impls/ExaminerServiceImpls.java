package com.example.courseproject.service.impls;

/*
 * Created by IntelliJ IDEA.
 * Class: ExaminerServiceImpls
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Examiner;
import com.example.courseproject.repository.IExaminerMongoRepository;
import com.example.courseproject.service.interfaces.IExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExaminerServiceImpls implements IExaminerService {

    List<Examiner> list = new ArrayList<>(
            Arrays.asList(
                    new Examiner("Vaughn Busfield", "Math"),
                    new Examiner("Kahlil Drieu", "Math"),
                    new Examiner("Connie Woolaston", "English"),
                    new Examiner("Letti Sivyour", "English"),
                    new Examiner("Ricky MacArte", "Physics"),
                    new Examiner("Gregoire Blumire", "Physics"),
                    new Examiner("Jacinda Pilmoor", "Geography"),
                    new Examiner("Karoly Albrecht", "Geography"),
                    new Examiner("Loren Harrad", "Geography"),
                    new Examiner("Dominica Curcher", "Biology"),
                    new Examiner("Sonnie Carnew", "Biology"),
                    new Examiner("Jakob Petruska", "Biology"),
                    new Examiner("Marcellus Thorius", "Chemistry"),
                    new Examiner("Oliviero Freund", "Chemistry"),
                    new Examiner("Drona Kohneke", "Chemistry"),
                    new Examiner("Florencia Jeeks", "History"),
                    new Examiner("Margalo Norwood", "History")
            )
    );

    //@PostConstruct
    void init() {
        repository.saveAll(list);
    }

    @Autowired
    IExaminerMongoRepository repository;

    @Override
    public List<Examiner> getAll() {
        return repository.findAll();
    }

    @Override
    public Examiner create(Examiner examiner) {
        return repository.save(examiner);
    }
}
