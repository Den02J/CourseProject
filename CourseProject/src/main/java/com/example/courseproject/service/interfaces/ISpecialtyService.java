package com.example.courseproject.service.interfaces;

/*
 * Created by IntelliJ IDEA.
 * Class: ISpecialtyService
 *
 * Author: DenysZhytariu
 * Version 1.0
 */

import com.example.courseproject.model.Specialty;

import java.util.List;

public interface ISpecialtyService {
    List<Specialty> getAll();
    Specialty create(Specialty specialty);
}
