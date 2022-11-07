package com.example.courseproject.service.impls;

/*
 * Created by IntelliJ IDEA.
 * Class: StudentServiceImpls
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Student;
import com.example.courseproject.repository.IStudentMongoRepository;
import com.example.courseproject.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpls implements IStudentService {

//    List<Student> list = new ArrayList<>(
//            Arrays.asList(
//                    new Student("1", "firstname1", "lastname1", "Math"),
//                    new Student("2", "firstname2", "lastname2", "Geography"),
//                    new Student("3", "firstname3", "lastname3", "History"),
//                    new Student("4", "firstname3", "lastname3", "History")
//            )
//    );
    @Autowired
    IStudentMongoRepository repository;

    //@PostConstruct
//    void init() {
//        repository.saveAll(list);
//    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public Student get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
