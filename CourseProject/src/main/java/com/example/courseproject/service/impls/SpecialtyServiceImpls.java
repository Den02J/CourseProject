package com.example.courseproject.service.impls;

/*
 * Created by IntelliJ IDEA.
 * Class: SpecialtyServiceImpls
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Specialty;
import com.example.courseproject.model.Subject;
import com.example.courseproject.repository.ISpecialtyMongoRepository;
import com.example.courseproject.service.interfaces.ISpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpecialtyServiceImpls implements ISpecialtyService {

    Subject s1 = new Subject("Biology");
    Subject s2 = new Subject("Chemistry");
    Subject s3 = new Subject("English");
    Subject s4 = new Subject("History");
    Subject s5 = new Subject("Geography");
    Subject s6 = new Subject("Math");
    Subject s7 = new Subject("Physics");

    List<Specialty> list = new ArrayList<>(
            Arrays.asList(
                    new Specialty("Biological Research", s1, s2, s3),
                    new Specialty("Psychology", s1, s4, s3),
                    new Specialty("Economy", s6, s3, s5),
                    new Specialty("Management", s6, s3, s4),
                    new Specialty("Journalistic", s3, s4, s5),
                    new Specialty("Agronomy", s1, s2, s5),
                    new Specialty("Ecology", s1, s2, s7)
            )
    );

    @Autowired
    ISpecialtyMongoRepository repository;

    //@PostConstruct
    void init() {
        repository.saveAll(list);
    }

    @Override
    public List<Specialty> getAll() {
        return repository.findAll();
    }

    @Override
    public Specialty create(Specialty specialty) {
        return repository.save(specialty);
    }
}
